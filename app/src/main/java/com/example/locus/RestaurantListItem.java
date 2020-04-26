package com.example.locus;

public class RestaurantListItem {

    //store restaurant ID
    private int rImageDrawable;
    //store restaurant name
    private String rName;

    //constructor creating instance of restaurant object
    public RestaurantListItem(int rImageDrawable, String rName) {
        this.rImageDrawable = rImageDrawable;
        this.rName = rName;
    }

    //getters and setters
    public int getrImageDrawable() {
        return rImageDrawable;
    }

    public void setrImageDrawable(int rImageDrawable) {
        this.rImageDrawable = rImageDrawable;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }
}
