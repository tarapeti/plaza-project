package com.codecool.plaza.api;

public class ClothingProduct extends Product {
    private String material;
    private String type;

    public ClothingProduct(long barcode, String name, String manufacturer, String material, String type){
        super(barcode, name, manufacturer, material, type);

    }

    public String getMaterial() {
        return material;
    }

    public String getType() {
        return type;
    }
}
