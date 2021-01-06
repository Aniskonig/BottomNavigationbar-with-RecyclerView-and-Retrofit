package com.medanis.bnbrvr.models

data class StoresModel (
    var restaurantId: Int? = 0,
    var ownerId: Int? = 0,
    var restaurantName: String? = "",
    var restaurantPhone: String? = "",
    var restaurantType: String? = "",
    var nrc: String? = "",
    var nis: String? = "",
    var nif: String? = "",
    var workingDays: String? = "",
    var workingHours: String? = "",
    var storeImage: String? = ""
)