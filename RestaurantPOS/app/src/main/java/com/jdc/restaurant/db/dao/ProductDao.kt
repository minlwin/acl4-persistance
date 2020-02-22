package com.jdc.restaurant.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.jdc.restaurant.db.dto.ProductWithCategory
import com.jdc.restaurant.db.entity.Product

@Dao
interface ProductDao {

    @Insert
    suspend fun insert(p:Product):Long

    @Update
    suspend fun update(p:Product)

    @Query("select * from Product")
    fun findAll():LiveData<List<ProductWithCategory>>

    @Query("select * from Product where categoryId = :id")
    fun findByCategoryId(id:Long):LiveData<List<ProductWithCategory>>

    @Query("select * from Product where id = :id")
    fun findById(id:Long):LiveData<ProductWithCategory>

}