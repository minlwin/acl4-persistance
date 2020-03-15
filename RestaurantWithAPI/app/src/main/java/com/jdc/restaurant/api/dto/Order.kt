package com.jdc.restaurant.api.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.jdc.restaurant.api.utils.DateDeserializer
import com.jdc.restaurant.api.utils.DateSerializer
import java.util.*

data class Order(
    var id:Long = 0,
    @JsonProperty("product")
    var menu:Menu? = null,
    var unitPrice:Int = 0,
    var quantity:Int = 0,
    var status:String = "",
    @JsonSerialize(using = DateSerializer::class)
    @JsonDeserialize(using = DateDeserializer::class)
    var orderTime:Date? = null,
    var remind:Int = 0
)