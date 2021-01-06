package com.medanis.bnbrvr.models

data class MenusModel (
    var restaurantMenuId: Int? = 0,
    var restaurantId : Int? = 0,
    var plateName : String? = "",
    var plateImage : String? = "",
    var platePrice : String? = "",
    var plateCategory : String? = "",
    var plateDescription : String? = ""
)