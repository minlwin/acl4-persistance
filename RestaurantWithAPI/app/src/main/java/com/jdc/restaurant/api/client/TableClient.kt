package com.jdc.restaurant.api.client

import com.jdc.restaurant.api.dto.Table
import retrofit2.Call
import retrofit2.http.GET

interface TableClient {

    @GET("tables")
    fun findAll():Call<List<Table>>
}