package com.codecool.plaza.api;

import com.codecool.plaza.api.Product;
import com.codecool.plaza.api.ShopIsClosedException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopImpl implements Shop {

    private String name;
    private String owner;
    private boolean isOpen;
    private Map<Long, ShopEntryImpl> products = new HashMap<>();

    public ShopImpl(String name, String owner) {
        this.name = name;
        this.owner = owner;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getOwner() {
        return this.owner;
    }

    @Override
    public boolean isOpen() {
        return isOpen;
    }

    @Override
    public void open() {
        this.isOpen = true;
    }

    @Override
    public void close() {
        this.isOpen = false;
    }

    @Override
    public List<Product> getProducts() throws ShopIsClosedException {
        List<Product> productsList = new ArrayList<>();
        if (isOpen) {
            for (ShopEntryImpl shopEntry : products.values()) {
                productsList.add(shopEntry.getProduct());
            }
        } else {
            throw new ShopIsClosedException();
        }
        return null;
    }

    @Override
    public Product findByName(String name) throws NoSuchProductException, ShopIsClosedException {
        if (isOpen) {
            for (ShopEntryImpl shopEntry : products.values()) {
                if (shopEntry.getProduct().getName().equals(name)) {
                    return shopEntry.getProduct();
                }
                throw new NoSuchProductException();
            }
        } else {
            throw new ShopIsClosedException();
        }
        return null;
    }

    @Override
    public float getPrice(long barcode) throws NoSuchProductException, ShopIsClosedException {
        if (isOpen) {
            for (ShopEntryImpl shopEntry : products.values()) {
                if (shopEntry.getProduct().getBarcode() == barcode) {
                    return shopEntry.getPrice();
                }
                throw new NoSuchProductException();
            }
        } else {
            throw new ShopIsClosedException();
        }
        return 0;
    }

    @Override
    public boolean hasProduct(long barcode) throws ShopIsClosedException {
        if (isOpen) {
            for (ShopEntryImpl shopEntry : products.values()) {
                return shopEntry.getProduct().getBarcode() == barcode;
            }
        } else {
            throw new ShopIsClosedException();
        }
        return false;
    }

    @Override
    public void addNewProduct(Product product, int quantity, float price) throws ProductAlreadyExistsException, ShopIsClosedException {
        if (isOpen) {
            if (!products.entrySet().contains(product)) {
                products.put(product.getBarcode(), new ShopEntryImpl(product, quantity, price));
            }
            throw new ProductAlreadyExistsException();
        } else {
            throw new ShopIsClosedException();
        }

    }

    @Override
    public void addProduct(long barcode, int quantity) throws NoSuchProductException, ShopIsClosedException {
        if (isOpen) {
            for (long num : products.keySet()) {
                if (num == barcode) {
                    products.get(num).increaseQuantity(quantity);
                }
                throw new NoSuchProductException();
            }
        } else {
            throw new ShopIsClosedException();
        }
    }

    @Override
    public Product buyProduct(long barcode) throws NoSuchProductException, OutOfStockException, ShopIsClosedException {
        if (isOpen) {
            for (ShopEntryImpl shopEntry : products.values()) {
                if (shopEntry.getProduct().getBarcode() == barcode) {
                    if (shopEntry.getQuantity() == 0) {
                        throw new OutOfStockException();
                    }
                    shopEntry.decreaseQuantity(1);
                    return shopEntry.getProduct();
                }
                throw new NoSuchProductException();
            }
        } else {
            throw new ShopIsClosedException();
        }
        return null;
    }

    @Override
    public List<Product> buyProducts(long barcode, int quantity) throws NoSuchProductException, OutOfStockException, ShopIsClosedException {
        List<Product> productsList = new ArrayList<>();
        if (isOpen) {
            for (ShopEntryImpl shopEntry : products.values()) {
                if (shopEntry.getProduct().getBarcode() == barcode) {
                    for (int i = 0; i < quantity; i++) {
                        if (shopEntry.getQuantity() != 0) {
                            productsList.add(shopEntry.getProduct());
                        }
                        throw new OutOfStockException();
                    }
                }
                throw new NoSuchProductException();
            }
            return productsList;
        } else {
            throw new ShopIsClosedException();
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }

    private class ShopEntryImpl {

        private Product product;
        private int quantity;
        private float price;

        private ShopEntryImpl(Product product, int quantity, float price) {
            this.product = product;
            this.quantity = quantity;
            this.price = price;
        }


        public Product getProduct() {
            return this.product;
        }


        public void setProduct(Product product) {
            this.product = product;
        }


        public int getQuantity() {
            return this.quantity;
        }


        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }


        public void increaseQuantity(int amount) {
            this.quantity += amount;
        }


        public void decreaseQuantity(int amount) {
            this.quantity -= amount;
        }


        public float getPrice() {
            return this.price;
        }


        public void setPrice(int price) {
            this.price = price;
        }
    }
}