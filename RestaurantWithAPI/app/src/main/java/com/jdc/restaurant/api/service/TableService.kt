package com.jdc.restaurant.api.service

import com.jdc.restaurant.api.ClientFactory
import com.jdc.restaurant.api.client.TableClient
import com.jdc.restaurant.api.dto.Table

class TableService {

    private val client = ClientFactory.generate(TableClient::class.java)

    suspend fun getAll():List<Table> {
        return client.findAll().execute().body() ?: listOf()
    }

    suspend fun findById(id:Int) = client.findById(id).execute().body()
}