package com.jdc.restaurant.db.dao

import androidx.room.Dao
import androidx.room.Insert
import com.jdc.restaurant.db.entity.Orders

@Dao
interface OrdersDao {
    @Insert
    suspend fun insert(orders: Orders):Long
}