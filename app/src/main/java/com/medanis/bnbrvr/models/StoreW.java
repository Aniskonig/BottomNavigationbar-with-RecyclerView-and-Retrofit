package com.medanis.bnbrvr.models;

import com.google.gson.annotations.SerializedName;

public class StoreW {

    @SerializedName("restaurant_id")
    private int id_restaurant;

    @SerializedName("owner_id")
    private int owner_id ;

    @SerializedName("restaurant_name")
    private String name;

    @SerializedName("restaurant_phone")
    private String phone;

    @SerializedName("restaurant_type")
    private String type ;

    @SerializedName("store_image")
    private String lien_image;

    public StoreW(int id_restaurant, int owner_id, String name, String phone, String type, String lien_image) {
        this.id_restaurant = id_restaurant;
        this.owner_id = owner_id;
        this.name = name;
        this.phone = phone;
        this.type = type;
        this.lien_image = lien_image;
    }


    public int getId_restaurant() {
        return id_restaurant;
    }

    public void setId_restaurant(int id_restaurant) {
        this.id_restaurant = id_restaurant;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLien_image() {
        return lien_image;
    }

    public void setLien_image(String lien_image) {
        this.lien_image = lien_image;
    }
}
