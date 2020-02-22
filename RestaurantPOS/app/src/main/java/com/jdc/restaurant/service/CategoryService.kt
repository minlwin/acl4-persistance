package com.jdc.restaurant.service

import android.content.Context
import com.jdc.restaurant.db.RestaurantDB
import com.jdc.restaurant.db.entity.Category

class CategoryService(private val context: Context) {

    private val dao = RestaurantDB.database(context).category()

    fun findAll() = dao.findAll()

    fun findById(id:Long) = dao.findById(id)

    suspend fun save(category: Category):Long = if(category.id == 0L) dao.insert(category) else
        dao.update(category).let { category.id }
}