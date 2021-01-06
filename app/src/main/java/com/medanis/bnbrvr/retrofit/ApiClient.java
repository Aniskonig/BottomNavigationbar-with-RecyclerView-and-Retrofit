package com.medanis.bnbrvr.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String BASE_URL = "https://wasali-dz.com/mobileApp/Vendor/";
    private static Retrofit retrofit = null;

    public static Retrofit getApiClient(){
        if(retrofit==null){
            Gson gson = new GsonBuilder().setLenient().create();

            retrofit = new  Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return  retrofit;
    }


}
