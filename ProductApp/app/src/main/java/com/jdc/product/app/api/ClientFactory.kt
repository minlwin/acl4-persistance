package com.jdc.product.app.api

import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

object ClientFactory {

    fun<T> generate(type:Class<T>):T {
        return Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080/")
            .addConverterFactory(JacksonConverterFactory.create())
            .build().create(type);
    }
}