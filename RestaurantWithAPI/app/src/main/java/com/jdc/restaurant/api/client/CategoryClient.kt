package com.jdc.restaurant.api.client

import com.jdc.restaurant.api.dto.CategoryDto
import retrofit2.Call
import retrofit2.http.GET

interface CategoryClient {

    @GET("categories/types")
    fun findTypes():Call<List<String>>

    @GET("categories/searchwithmenus")
    fun search(query:Map<String, String>):Call<List<CategoryDto>>
}