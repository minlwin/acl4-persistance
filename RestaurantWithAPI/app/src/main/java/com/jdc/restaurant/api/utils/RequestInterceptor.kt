package com.jdc.restaurant.api.utils

import com.jdc.restaurant.api.ClientContext
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

object RequestInterceptor:Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val originalRequest = chain.request()
        val newRequest:Request? = ClientContext.token?.let {
            originalRequest.newBuilder().addHeader("Authorization", it).build()
        }

        return chain.proceed(newRequest ?: originalRequest)
    }

}