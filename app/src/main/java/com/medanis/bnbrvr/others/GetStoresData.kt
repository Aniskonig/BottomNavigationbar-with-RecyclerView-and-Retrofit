package com.medanis.bnbrvr.others

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.medanis.bnbrvr.models.*
import com.medanis.bnbrvr.retrofit.ApiClient
import com.medanis.bnbrvr.retrofit.ApiInterface
import org.json.JSONArray
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

var myStoreList: MutableList<StoresModel> = ArrayList()
var myStoresMenusList: MutableList<MenusModel> = ArrayList()
var myStoresRatingsList: MutableList<RatingsModel> = ArrayList()


fun getStoresDataByID(context: Context, ownerID: Int, callback: CustomCallback) {
//    showProgressBar(progressBar)

    val apiInterface = ApiClient.getApiClient().create(ApiInterface::class.java)
    val storesCall: Call<CallStoresModel> = apiInterface.getStoresData(ownerID)

    storesCall.enqueue(object : Callback<CallStoresModel?> {
        override fun onResponse(
            call: Call<CallStoresModel?>,
            response: Response<CallStoresModel?>
        ) {
            if (response.body() != null) {

                val callStoresModel: CallStoresModel = response.body()!!
                if (callStoresModel.isSuccess) {

                    val restaurants = callStoresModel.restaurant_array
                    val rest = JSONArray(restaurants)

                    for (i in 0 until rest.length()) {
                        val store = rest.getJSONObject(i)
                        val restaurantId = store.getInt("restaurant_id")
                        val ownerId = store.getInt("owner_id")
                        val restaurantName = store.getString("restaurant_name")
                        val restaurantPhone = store.getString("restaurant_phone")
                        val restaurantType = store.getString("restaurant_type")
                        val nrc = store.getString("nrc")
                        val nis = store.getString("nis")
                        val nif = store.getString("nif")
                        val workingDays = store.getString("working_days")
                        val workingHours = store.getString("working_hours")
                        val storeImage = store.getString("store_image")

                        myStoreList.add(
                            StoresModel(
                                restaurantId,
                                ownerId,
                                restaurantName,
                                restaurantPhone,
                                restaurantType,
                                nrc,
                                nis,
                                nif,
                                workingDays,
                                workingHours,
                                storeImage
                            )
                        )
                    }

                    val callMenus = callStoresModel.restaurant_menus
                    val menus = JSONArray(callMenus)

                    for (i in 0 until menus.length()) {
                        val menu = menus.getJSONObject(i)
                        val restaurantMenuId = menu.getInt("restaurant_menu_id")
                        val restaurantId = menu.getInt("restaurant_id")
                        val plateName = menu.getString("plate_name")
                        val plateImage = menu.getString("plate_image")
                        val platePrice = menu.getString("plate_price")
                        val plateCategory = menu.getString("plate_category")
                        val plateDescription = menu.getString("plate_description")

                        myStoresMenusList.add(
                            MenusModel(
                                restaurantMenuId,
                                restaurantId,
                                plateName,
                                plateImage,
                                platePrice,
                                plateCategory,
                                plateDescription
                            )
                        )
                    }

                    val ratingsArr = callStoresModel.restaurant_ratings
                    val ratings = JSONArray(ratingsArr)

                    for (i in 0 until ratings.length()) {
                        val rating = ratings.getJSONObject(i)
                        val id = rating.getInt("id")
                        val userId = rating.getInt("user_id")
                        val ratedItemId = rating.getInt("rated_item_id")
                        val ratingValue = rating.getInt("rating_value")

                        myStoresRatingsList.add(RatingsModel(id, userId, ratedItemId, ratingValue))
                    }

                } else {
                    Toast.makeText(
                        context,
                        "Getting Stores failed: " + callStoresModel.message,
                        Toast.LENGTH_LONG
                    ).show()
                    Log.e("callStoresModel.message", callStoresModel.message)
                }
//                dismissProgressBar(progressBar)
//                if (myStoreList.isNotEmpty()){
//                    recyclerView.visibility = View.VISIBLE
//                }
                val fullStoresList : MutableList<FullStoresModel> = ArrayList()

                fullStoresList.clear()
                for (i in 0 until myStoreList.size) {
                    var storeRating = 0.0
                    var numberOfRatings = 0
                    var menusNumber = 0
                    for (j in 0 until myStoresRatingsList.size) {
                        if (myStoresRatingsList[j].ratedItemId == myStoreList[i].restaurantId) {
                            numberOfRatings++
                            storeRating += myStoresRatingsList[j].ratingValue!!
                        }
                    }
                    for (k in 0 until myStoresMenusList.size) {
                        if (myStoresMenusList[k].restaurantId == myStoreList[i].restaurantId) {
                            menusNumber++
                        }
                    }
                    if (numberOfRatings != 0) {
                        storeRating /= numberOfRatings
                    }
                    val rate = String.format("%.1f", storeRating)

                    fullStoresList.add(
                        FullStoresModel(
                            myStoreList[i].restaurantId,
                            myStoreList[i].ownerId,
                            myStoreList[i].restaurantName,
                            myStoreList[i].restaurantPhone,
                            myStoreList[i].restaurantType,
                            myStoreList[i].nrc,
                            myStoreList[i].nis,
                            myStoreList[i].nif,
                            myStoreList[i].workingDays,
                            myStoreList[i].workingHours,
                            myStoreList[i].storeImage,
                            menusNumber,
                            rate
                        )
                    )
                }
//                val myOptionsAdapter = StoresAdapter(
//                    context,
//                    fullStoresList
//                )
//                recyclerView.layoutManager = LinearLayoutManager(
//                    context,
//                    LinearLayoutManager.VERTICAL,
//                    false
//                )
//                recyclerView.adapter = myOptionsAdapter
                callback.getStoreDataLists(myStoreList, myStoresMenusList, myStoresRatingsList)
            }
        }

        override fun onFailure(call: Call<CallStoresModel?>, t: Throwable) {

//            dismissProgressBar(progressBar)
            Toast.makeText(context, "Error: couldn't connect: $t", Toast.LENGTH_LONG)
                .show()
            Log.e("Error.message", t.toString())

        }
    })
}