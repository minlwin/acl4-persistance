package com.jdc.product.app.api.service

import com.jdc.product.app.api.ClientFactory
import com.jdc.product.app.api.client.CategoryClient
import com.jdc.product.app.api.dto.Category

class CategoryService {

    private val client = ClientFactory.generate(CategoryClient::class.java)

    suspend fun getTypes():List<String> {
        return client.types().execute().body() ?: listOf()
    }

    suspend fun create(c:Category):Category? {
        return client.create(c).execute().body()
    }

    suspend fun findAll() = client.findAll().execute().body()

    suspend fun findByType(type:String) = client.findByType(type).execute().body()
}