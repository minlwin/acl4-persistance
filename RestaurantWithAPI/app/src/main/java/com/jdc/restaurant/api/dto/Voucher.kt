package com.jdc.restaurant.api.dto

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.jdc.restaurant.api.utils.DateDeserializer
import com.jdc.restaurant.api.utils.DateSerializer
import java.util.*

data class Voucher(
    var id:Long = 0,
    var table:Table? = null,
    @JsonSerialize(using = DateSerializer::class)
    @JsonDeserialize(using = DateDeserializer::class)
    var saleDate:Date? = null,
    var subTotal:Int = 0,
    var tax:Int = 0,
    var status:String = "",
    var orders:MutableList<Order> = mutableListOf()
)