package com.codecool.plaza.api;

import java.util.ArrayList;
import java.util.List;

public class PlazaImpl implements Plaza {

    private List<Shop> shops = new ArrayList<>();
    private boolean isopen;

    public PlazaImpl() {

    }

    @Override
    public List<Shop> getShops() throws PlazaIsClosedException {
        if (isopen) {
            return shops;
        } else {
            throw new PlazaIsClosedException();
        }

    }

    @Override
    public void addShop(Shop shop) throws ShopAlreadyExistsException, PlazaIsClosedException {
        if (isopen) {
            if (!shops.contains(shop)) {
                shops.add(shop);
            } else {
                throw new ShopAlreadyExistsException();
            }
        } else {
            throw new PlazaIsClosedException();
        }
    }

    @Override
    public void removeShop(Shop shop) throws NoSuchShopException, PlazaIsClosedException {
        if (isopen) {
            if (shops.contains(shop)) {
                shops.remove(shop);
            } else {
                throw new NoSuchShopException();
            }
        } else {
            throw new PlazaIsClosedException();
        }
    }

    @Override
    public Shop findShopByName(String name) throws NoSuchShopException, PlazaIsClosedException {
        if (isopen) {
            for (Shop shop : shops) {
                if (shop.getName().equals(name)) {
                    return shop;
                } else {
                    throw new NoSuchShopException();
                }

            }
        } else {
            throw new PlazaIsClosedException();
        }
        return null;
    }

    @Override
    public boolean isIsopen() {
        return isopen;
    }

    @Override
    public void open() {
        this.isopen = true;
    }

    @Override
    public void close() {
        this.isopen = false;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}