package com.jdc.room.hello.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Message::class],
    version = 1,
    exportSchema = false
)
abstract class HelloDatabase : RoomDatabase() {

    abstract fun messageDao(): MessageDao

    companion object {

        private lateinit var database: HelloDatabase

        fun get(context: Context) = if (::database.isInitialized) database else
            Room.databaseBuilder(context, HelloDatabase::class.java, "com.jdc.room.hello.HelloDB")
                .build().also { database = it }
    }
}