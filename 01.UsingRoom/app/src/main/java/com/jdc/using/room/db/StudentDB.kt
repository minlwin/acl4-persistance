package com.jdc.using.room.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Student::class],
    version = 1,
    exportSchema = false
)
abstract class StudentDB : RoomDatabase() {

    abstract fun studentDao(): StudentDao

    companion object {

        private lateinit var db: StudentDB

        fun getDatabase(context: Context) = if (::db.isInitialized) db else
            Room.databaseBuilder(context, StudentDB::class.java,
                "com.jdc.using.room.db.StudentDB")
                .build().also {
                    db = it
                }
    }
}