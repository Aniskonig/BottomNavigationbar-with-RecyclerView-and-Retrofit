package com.medanis.bnbrvr.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CallStoresModel {

    @Expose
    @SerializedName("restaurant_array")
    private ArrayList restaurant_array;

    @Expose
    @SerializedName("restaurant_menus")
    private ArrayList restaurant_menus;

    @Expose
    @SerializedName("restaurant_ratings")
    private ArrayList restaurant_ratings;


    @SerializedName("success")
    private boolean success;

    @SerializedName("message")
    private String message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList getRestaurant_array() {
        return restaurant_array;
    }

    public void setRestaurant_array(ArrayList restaurant_array) {
        this.restaurant_array = restaurant_array;
    }

    public ArrayList getRestaurant_menus() {
        return restaurant_menus;
    }

    public void setRestaurant_menus(ArrayList restaurant_menus) {
        this.restaurant_menus = restaurant_menus;
    }

    public ArrayList getRestaurant_ratings() {
        return restaurant_ratings;
    }

    public void setRestaurant_ratings(ArrayList restaurant_ratings) {
        this.restaurant_ratings = restaurant_ratings;
    }
}