package com.codecool.plaza.api;

import java.util.Map;

public abstract class ShopImpl implements Shop {
    private String name;
    private String owner;
    private Map<Long, ShopEntryImpl> products;

    public ShopImpl(String name, String owner) {

    }

    private class ShopEntryImpl {

        private Product product;
        private int quantity;
        private float price;

        private ShopEntryImpl(Product product, int quantity, float price) {
        }

        public void increaseQuantity(int amount) {

        }

        public void decreaseQuantity(int amount) {
        }


        public Product getProduct() {
            return product;
        }

        public int getQuantity() {
            return quantity;
        }

        public float getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public void setProduct(Product product) {
            this.product = product;
        }


    }
}
