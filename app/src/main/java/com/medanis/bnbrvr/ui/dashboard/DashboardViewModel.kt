package com.medanis.bnbrvr.ui.dashboard;

import android.app.Application
import androidx.lifecycle.*
import com.medanis.bnbrvr.models.FullStoresModel
import com.medanis.bnbrvr.models.RatingsModel
import com.medanis.bnbrvr.models.StoresModel
import com.medanis.bnbrvr.others.CustomCallback
import com.medanis.bnbrvr.others.getStoresDataByID
import com.medanis.bnbrvr.models.MenusModel

class DashboardViewModel(application: Application) : AndroidViewModel(application) {
    private val context = getApplication<Application>().applicationContext
    val fullStoresList : MutableList<FullStoresModel> = ArrayList()

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }


    val text: LiveData<String> = _text

        /**
         * Calling Data
         */

        private val _getData = MutableLiveData<MutableList<FullStoresModel>>().apply {
            getStoresDataByID(context, 27, object :
                    CustomCallback {
                override fun getStoreDataLists(
                        storesList: MutableList<StoresModel>,
                        storesMenusList: MutableList<MenusModel>,
                        storeRatingsList: MutableList<RatingsModel>
                ) {
//                Log.e("storesList", storesList.toString())
                    fullStoresList.clear()
                    for (i in 0 until storesList.size) {
                        var storeRating = 0.0
                        var numberOfRatings = 0
                        var menusNumber = 0
                        for (j in 0 until storeRatingsList.size) {
                            if (storeRatingsList[j].ratedItemId == storesList[i].restaurantId) {
                                numberOfRatings++
                                storeRating += storeRatingsList[j].ratingValue!!
                            }
                        }
                        for (k in 0 until storesMenusList.size) {
                            if (storesMenusList[k].restaurantId == storesList[i].restaurantId) {
                                menusNumber++
                            }
                        }
                        if (numberOfRatings != 0) {
                            storeRating /= numberOfRatings
                        }
                        val rate = String.format("%.1f", storeRating)

                        fullStoresList.add(
                            FullStoresModel(
                                storesList[i].restaurantId,
                                storesList[i].ownerId,
                                storesList[i].restaurantName,
                                storesList[i].restaurantPhone,
                                storesList[i].restaurantType,
                                storesList[i].nrc,
                                storesList[i].nis,
                                storesList[i].nif,
                                storesList[i].workingDays,
                                storesList[i].workingHours,
                                storesList[i].storeImage,
                                menusNumber,
                                rate
                            )
                        )
                    }

                    value =fullStoresList

                }
            })
        }

    val data: LiveData<MutableList<FullStoresModel>> = _getData

}