package com.jdc.product.app.api.service

import com.jdc.product.app.api.ClientFactory
import com.jdc.product.app.api.Executor
import com.jdc.product.app.api.client.ProductClient
import com.jdc.product.app.api.dto.Product

class ProductService {

    private val client = ClientFactory.generate(ProductClient::class.java)

    suspend fun save(p:Product) = Executor.execute(p,
        if(p.id == 0) client::create else client::update)

    suspend fun findAll() = Executor.execute { client.search(mapOf()) }

    suspend fun findById(id:Int) = Executor.findOne(id, client::findById)

    suspend fun search(categoryId:Int) = Executor.search(mapOf("category" to categoryId.toString()), client::search)
}