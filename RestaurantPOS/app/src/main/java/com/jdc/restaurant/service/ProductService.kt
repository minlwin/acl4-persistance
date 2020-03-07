package com.jdc.restaurant.service

import android.content.Context
import com.jdc.restaurant.db.RestaurantDB
import com.jdc.restaurant.db.entity.Product
import java.lang.RuntimeException

class ProductService(context: Context) {

    private val dao = RestaurantDB.database(context).product()

    fun findById(id:Long) = dao.findById(id)

    suspend fun save(product:Product):Long {

        if(product.name.isEmpty()) {
            throw RuntimeException("Please enter Product Name.")
        }

        if(product.categoryId == 0L) {
            throw RuntimeException("Please select Category.")
        }

        return if(product.id == 0L)
            dao.insert(product) else dao.update(product).let {
            product.id
        }
    }

    fun findAll() = dao.findAll()

    fun findByCategory(id:Long) = dao.findByCategoryId(id)

}