package com.codecool.plaza.api;

abstract class Product {
    protected long barcode;
    protected String name;
    protected String manufacturer;

    protected Product(long barcode, String name1, String s, String name, String manufacturer){

    }

    protected Product() {
    }

    public long getBarcode() {
        return barcode;
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public String toString() {
        return "Product{" +
            "barcode=" + barcode +
            ", name='" + name + '\'' +
            ", manufacturer='" + manufacturer + '\'' +
            '}';
    }

}
