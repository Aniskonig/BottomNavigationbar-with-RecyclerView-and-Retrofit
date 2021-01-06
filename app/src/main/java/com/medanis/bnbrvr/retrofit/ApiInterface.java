package com.medanis.bnbrvr.retrofit;


import com.medanis.bnbrvr.models.CallStoresModel;
import com.medanis.bnbrvr.models.UsersModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("getStoresData.php")
    Call<CallStoresModel> getStoresData(
            @Field("owner_id") Integer owner_id
    );
}
