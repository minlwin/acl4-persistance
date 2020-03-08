package com.jdc.restaurant.db.dao

import androidx.room.Dao
import androidx.room.Insert
import com.jdc.restaurant.db.entity.Sale

@Dao
interface SaleDao {
    @Insert
    suspend fun insert(sale:Sale):Long
}