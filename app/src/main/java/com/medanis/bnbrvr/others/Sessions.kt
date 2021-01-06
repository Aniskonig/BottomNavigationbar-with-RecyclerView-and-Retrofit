package com.medanis.bnbrvr.others

import android.content.Context
import android.content.SharedPreferences

class Sessions(context: Context){
    private var preferences: SharedPreferences = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)

    // Saving Session
    fun saveSession(saveSession: Boolean) {
        preferences.edit().putBoolean("session", saveSession).apply()
    }
    //getting Session
    fun getSession() : Boolean {
        return preferences.getBoolean("session", false)
    }


    // Saving Image
    fun saveImage(saveTk: String) {
        preferences.edit().putString("Image", saveTk).apply()
    }
    //getting Image
    fun getImage() : String? {
        return preferences.getString("Image", "")
    }

    // Saving token
    fun saveToken(saveTk: Int) {
        preferences.edit().putInt("token", saveTk).apply()
    }
    //getting token
    fun getToken() : Int? {
        return preferences.getInt("token", 0)
    }

    // Saving Name
    fun saveName(saveTk: String) {
        preferences.edit().putString("Name", saveTk).apply()
    }
    //getting Name
    fun getName() : String? {
        return preferences.getString("Name", "")
    }

    // Saving Email
    fun saveEmail(saveTk: String) {
        preferences.edit().putString("Email", saveTk).apply()
    }
    //getting Email
    fun getEmail() : String? {
        return preferences.getString("Email", "")
    }

    // Saving PhoneNumber
    fun savePhoneNumber(saveTk: String) {
        preferences.edit().putString("PhoneNumber", saveTk).apply()
    }
    //getting PhoneNumber
    fun getPhoneNumber() : String? {
        return preferences.getString("PhoneNumber", "")
    }

    // Saving UserName
    fun saveUserName(saveTk: String) {
        preferences.edit().putString("UserName", saveTk).apply()
    }
    //getting UserName
    fun getUserName() : String? {
        return preferences.getString("UserName", "")
    }

    // Saving AdsNumber
    fun saveAdsNumber(saveTk: String) {
        preferences.edit().putString("AdsNumber", saveTk).apply()
    }
    //getting AdsNumber
    fun getAdsNumber() : String? {
        return preferences.getString("AdsNumber", "")
    }

    // Saving AccTYpe
    fun saveAccTYpe(saveTk: String) {
        preferences.edit().putString("AccTYpe", saveTk).apply()
    }
    //getting AccTYpe
    fun getAccTYpe() : String? {
        return preferences.getString("AccTYpe", "")
    }

//    //saving Favorite Product
//    fun saveFavoriteProduct(saveFavorite : ArrayList<String>) {
//        preferences.edit().putStringSet("favoriteList", saveFavorite.toMutableSet()).apply()
//    }
//
//    //getting Favorite Product
//    fun getFavoriteProduct(): MutableList<String>? {
//        return preferences.getStringSet("favoriteList", setOf<String>())?.toMutableList()
//    }
/**
    //saving Favorite Product
    fun saveFavoriteProduct(products: MutableList<Products>?) {
        val serializedUser = Gson().toJson(products)
        preferences.edit().putString("products", serializedUser).apply()
    }
    //getting Favorite Product
    fun getFavoriteProduct(): MutableList<Products>? {
        val serializedUser = preferences.getString("products", null)
        val type = object : TypeToken<MutableList<Products>>() {}.type
        return Gson().fromJson(serializedUser, type)
    }

    //getting Favorite Product IDs
    fun getFavoriteProductIDs(): MutableList<String> {
        val productsIDs : MutableList<String> = ArrayList()
        getFavoriteProduct()?.forEach { i ->
            productsIDs.add(i.id.toString())
        }
        return productsIDs
    }

    //saving Favorite Companies
    fun saveFavoriteCompanies(companies: MutableList<PublisherModel>?) {
        val serializedUser = Gson().toJson(companies)
        preferences.edit().putString("companies", serializedUser).apply()
    }

    //getting Favorite Product
    fun getFavoriteCompanies(): MutableList<PublisherModel>? {
        val serializedUser = preferences.getString("companies", null)
        val type = object : TypeToken<MutableList<PublisherModel>>() {}.type
        return Gson().fromJson(serializedUser, type)
    }
    **/
}