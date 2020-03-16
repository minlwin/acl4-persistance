package com.jdc.product.app.api

import retrofit2.Call
import retrofit2.Response

object Executor {

    @JvmStatic
    suspend fun<T> execute(data:T, function:(T) -> Call<T>):T? {
        return checkStatus(function(data).execute()).body()
    }

    @JvmStatic
    suspend fun<T> execute(function: () -> Call<List<T>>):List<T> {
        return checkStatus(function().execute()).body() ?: listOf()
    }

    @JvmStatic
    suspend fun <T, R> search(data:T, function: (T) -> Call<List<R>>):List<R> {
        return checkStatus(function(data).execute()).body() ?: listOf()
    }

    @JvmStatic
    suspend fun <T, R> findOne(id:T, function: (T) -> Call<R>):R? {
        return checkStatus(function(id).execute()).body()
    }

    @JvmStatic
    private inline fun<T> checkStatus(response: Response<T>):Response<T> {
        if(!response.isSuccessful) {
            throw ClientException("API Error with ${response.code()}")
        }

        return response
    }
}