package com.medanis.bnbrvr.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CallStoresModelW {

    @Expose
    @SerializedName("restaurant_array")
    private ArrayList<StoreW> restaurant_array;

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


    public ArrayList<StoreW> getRestaurant_array() {
        return restaurant_array;
    }

    public void setRestaurant_array(ArrayList<StoreW> restaurant_array) {
        this.restaurant_array = restaurant_array;
    }
}