package com.jdc.restaurant.api.service

import com.jdc.restaurant.api.ClientFactory
import com.jdc.restaurant.api.client.VoucherClient

class VoucherService {

    private val vClient = ClientFactory.generate(VoucherClient::class.java)

    suspend fun findByTable(id:Int) = vClient.findActiveByTable(id).execute().body()
}