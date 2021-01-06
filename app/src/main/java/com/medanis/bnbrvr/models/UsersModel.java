package com.medanis.bnbrvr.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class UsersModel {

    @Expose
    @SerializedName("fullname")
    private String fullname;

    @Expose
    @SerializedName("email")
    private String email;

    @Expose
    @SerializedName("username")
    private String username;

    @Expose
    @SerializedName("password")
    private String password;

    @Expose
    @SerializedName("daira")
    private String daira;

    @Expose
    @SerializedName("commune")
    private String commune;

    @Expose
    @SerializedName("phone")
    private String phone;

    @Expose
    @SerializedName("address")
    private String address;

    @Expose
    @SerializedName("type")
    private String type;

    @SerializedName("success")
    private boolean success;

    @SerializedName("message")
    private String message;

    @SerializedName("id")
    private int id;

    @Expose
    @SerializedName("restaurant_array")
    private ArrayList restaurantArray;

    public ArrayList getRestaurantArray() {
        return restaurantArray;
    }

    public void setRestaurantArray(ArrayList restaurantArray) {
        this.restaurantArray = restaurantArray;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDaira() {
        return daira;
    }

    public void setDaira(String daira) {
        this.daira = daira;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
