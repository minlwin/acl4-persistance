package com.jdc.restaurant.service

import android.content.Context
import com.jdc.restaurant.db.RestaurantDB
import com.jdc.restaurant.db.entity.Orders
import com.jdc.restaurant.db.entity.Sale

class SaleService(context: Context) {

    private val saleDao = RestaurantDB.database(context)
        .sale()

    private val ordersDao = RestaurantDB.database(context)
        .orders()

    suspend fun create(list:List<Orders>) {

        val sale = Sale(total = list.map { it.quantity * it.unitPrice }.sum())

        val id = saleDao.insert(sale)

        list.forEach {
            it.saleId = id
            ordersDao.insert(it)
        }
    }

    fun findAll() = saleDao.findAll()
}