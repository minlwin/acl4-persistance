package com.jdc.room.mappings.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jdc.room.mappings.db.dao.CommentDao
import com.jdc.room.mappings.db.dao.PostDao
import com.jdc.room.mappings.db.entity.Comment
import com.jdc.room.mappings.db.entity.Post

@Database(
    entities = [Post::class, Comment::class],
    version = 1,
    exportSchema = false
)
abstract class PostDatabase : RoomDatabase() {

    abstract fun postDao():PostDao
    abstract fun commentDao():CommentDao
}