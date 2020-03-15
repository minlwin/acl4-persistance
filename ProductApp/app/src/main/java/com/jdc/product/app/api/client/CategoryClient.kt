package com.jdc.product.app.api.client

import com.jdc.product.app.api.dto.Category
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface CategoryClient {

    @GET("categories/types")
    fun types():Call<List<String>>

    @GET("categories")
    fun findAll():Call<List<Category>>

    @GET("categories/types/{type}")
    fun findByType(@Path("type") type:String):Call<List<Category>>

    @POST("categories")
    fun create(@Body c:Category):Call<Category>
}