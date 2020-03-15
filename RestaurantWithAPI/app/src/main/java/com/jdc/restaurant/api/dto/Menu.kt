package com.jdc.restaurant.api.dto

data class Menu(
    var id:Long = 0,
    var code:String = "",
    var name:String = "",
    var category: Category? = null,
    var price:Int = 0,
    var size:String = "",
    var image:String = ""
)