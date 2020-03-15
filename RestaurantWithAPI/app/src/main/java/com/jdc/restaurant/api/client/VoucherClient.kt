package com.jdc.restaurant.api.client

import com.jdc.restaurant.api.dto.Voucher
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface VoucherClient {

    @GET("sales/{table}")
    fun findActiveByTable(@Path("table") table:Int):Call<List<Voucher>>
}