package com.jdc.product.app.api.dto

data class Product(
    var id:Int = 0,
    var name:String = "",
    var category: Category? = null,
    var price:Int = 0,
    var soledOut:Boolean = false
)