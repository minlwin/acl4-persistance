package com.jdc.restaurant.api.dto

data class CategoryDto(
    var id:Long = 0,
    var type:String = "",
    var name:String = "",
    var menus:Int = 0
)