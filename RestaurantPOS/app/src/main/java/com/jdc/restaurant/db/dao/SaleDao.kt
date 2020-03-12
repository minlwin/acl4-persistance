package com.jdc.restaurant.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.jdc.restaurant.db.entity.Sale

@Dao
interface SaleDao {
    @Insert
    suspend fun insert(sale:Sale):Long

    @Query("select * from Sale")
    fun findAll():LiveData<List<Sale>>
}