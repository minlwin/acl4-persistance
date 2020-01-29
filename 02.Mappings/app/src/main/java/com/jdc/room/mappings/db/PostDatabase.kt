package com.jdc.room.mappings.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jdc.room.mappings.db.converter.DateConverter
import com.jdc.room.mappings.db.dao.CommentDao
import com.jdc.room.mappings.db.dao.PostDao
import com.jdc.room.mappings.db.entity.Comment
import com.jdc.room.mappings.db.entity.Post

@Database(
    entities = [Post::class, Comment::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(value = [
    DateConverter::class
])
abstract class PostDatabase : RoomDatabase() {

    abstract fun postDao():PostDao
    abstract fun commentDao():CommentDao

    companion object {
        private lateinit var db: PostDatabase

        fun database(context: Context) = if(::db.isInitialized) db else
            Room.databaseBuilder(context, PostDatabase::class.java, "com.jdc.room.mapping.db.PostDatabase")
                .allowMainThreadQueries()
                .build().also {
                    db = it
                }
    }
}