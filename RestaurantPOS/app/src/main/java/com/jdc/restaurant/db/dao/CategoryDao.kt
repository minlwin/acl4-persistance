package com.jdc.restaurant.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.jdc.restaurant.db.entity.Category
import java.util.*

@Dao
interface CategoryDao {

    @Query("select * from Category")
    fun findAll():LiveData<List<Category>>

    @Query("select * from Category where id = :id")
    fun findById(id:Long):LiveData<Category>

    @Insert
    suspend fun insert(c:Category):Long

    @Update
    suspend fun update(c:Category)
}