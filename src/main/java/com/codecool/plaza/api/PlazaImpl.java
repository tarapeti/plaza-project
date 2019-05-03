package com.codecool.plaza.api;


import java.util.List;

public class PlazaImpl implements Plaza {

    private List<Shop> shops;

    @Override
    public List<Shop> getShops() throws PlazaIsClosedException {
        return shops;
    }

    @Override
    public void addShop(Shop shop) throws ShopAlreadyExistsException, PlazaIsClosedException {
        shops.add(shop);

    }

    @Override
    public void removeShop(Shop shop) throws NoSuchShopException, PlazaIsClosedException {
        shops.remove(shop);

    }

    @Override
    public Shop findShopByName(String name) throws NoSuchShopException, PlazaIsClosedException {
        for (Shop s : shops){
            if (s.getName().equals(name)){
                return s;
            } else {
                throw new NoSuchShopException();
            }
        }
        return null;
    }

    @Override
    public boolean isOpen() {
        return false;
    }

    @Override
    public void open() {

    }

    @Override
    public void close() {

    }
}
