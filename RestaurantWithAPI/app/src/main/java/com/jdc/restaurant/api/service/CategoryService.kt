package com.jdc.restaurant.api.service

import com.jdc.restaurant.api.ClientFactory
import com.jdc.restaurant.api.client.CategoryClient
import com.jdc.restaurant.api.dto.CategoryDto

class CategoryService {

    private val client = ClientFactory.generate(CategoryClient::class.java)

    suspend fun types():List<String> {
        return client.findTypes().execute().body() ?: listOf()
    }

    suspend fun search(type:String?, name:String?):List<CategoryDto>{

        val query = HashMap<String, String>()

        type?.also {
            if(it.isNotEmpty()) {
                query["type"] = type
            }
        }

        name?.also {
            if(it.isNotEmpty()) {
                query["name"] = name
            }
        }

        return client.search(query).execute().body() ?: listOf()
    }
}