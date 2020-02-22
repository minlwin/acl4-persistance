package com.jdc.restaurant.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jdc.restaurant.db.converter.DateConverter
import com.jdc.restaurant.db.dao.CategoryDao
import com.jdc.restaurant.db.dao.OrdersDao
import com.jdc.restaurant.db.dao.ProductDao
import com.jdc.restaurant.db.dao.SaleDao
import com.jdc.restaurant.db.entity.Category
import com.jdc.restaurant.db.entity.Orders
import com.jdc.restaurant.db.entity.Product
import com.jdc.restaurant.db.entity.Sale

@Database(
    entities = [
        Category::class,
        Product::class,
        Sale::class,
        Orders::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(value = [DateConverter::class])
abstract class RestaurantDB : RoomDatabase() {

    abstract fun category():CategoryDao
    abstract fun product():ProductDao
    abstract fun sale():SaleDao
    abstract fun orders():OrdersDao

    companion object {
        private lateinit var instance:RestaurantDB

        fun database(context: Context) = if(::instance.isInitialized) instance
            else Room.databaseBuilder(context, RestaurantDB::class.java, "com.jdc.restaurant.db").build().also {
            instance = it
        }
    }
}