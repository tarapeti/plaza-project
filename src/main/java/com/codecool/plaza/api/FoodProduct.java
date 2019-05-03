package com.codecool.plaza.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FoodProduct extends Product {

    private int calories;
    private Date bestBefore;

    public FoodProduct(long barcode, String name, String manufacturer, int calories, Date bestBefore) {
        super(barcode, name, manufacturer);
        this.calories = calories;
        this.bestBefore = bestBefore;
    }


    public boolean isStillConsumable() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date today = sdf.parse("2019-02-08");
        int decide = today.compareTo(bestBefore);
        if (decide == 0) {
            return true;
        }
        return false;
    }

    public int getCalories() {
        return calories;
    }

    @Override
    public String toString() {
        return "FoodProduct{" +
                "calories=" + calories +
                ", bestBefore=" + bestBefore +
                '}';
    }
}