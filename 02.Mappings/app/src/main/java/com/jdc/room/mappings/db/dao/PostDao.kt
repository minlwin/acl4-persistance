package com.jdc.room.mappings.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.jdc.room.mappings.db.dto.PostWithComments
import com.jdc.room.mappings.db.entity.Post

@Dao
interface PostDao {

    @Query("select * from Post")
    fun findAll():List<Post>

    @Insert
    fun create(post: Post):Long

    @Query("select * from Post where id = :postId")
    fun findById(postId:Int):PostWithComments
}