package com.jdc.product.app.api.service

import com.jdc.product.app.api.ClientFactory
import com.jdc.product.app.api.Executor
import com.jdc.product.app.api.client.CategoryClient
import com.jdc.product.app.api.dto.Category

class CategoryService {

    private val client = ClientFactory.generate(CategoryClient::class.java)

    suspend fun getTypes():List<String> {
        return Executor.execute { client.types() }
    }

    suspend fun create(c:Category):Category? {
        return Executor.execute(c, client::create)
    }

    suspend fun findAll() = Executor.execute { client.findAll() }

    suspend fun findByType(type:String) = Executor.search(type, client::findByType)
}