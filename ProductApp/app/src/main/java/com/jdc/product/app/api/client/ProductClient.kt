package com.jdc.product.app.api.client

import com.jdc.product.app.api.dto.Product
import retrofit2.Call
import retrofit2.http.*

interface ProductClient {

    @POST("products")
    fun create(@Body p:Product):Call<Product>

    @PUT("products")
    fun update(@Body p:Product):Call<Product>

    @GET("products/{id}")
    fun findById(@Path("id") id:Int):Call<Product>

    @DELETE("products/{id}")
    fun delete(@Path("id") id:Int)

    @GET("products")
    fun search(@QueryMap query:Map<String, String>):Call<List<Product>>
}