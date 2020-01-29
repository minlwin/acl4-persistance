package com.jdc.room.mappings.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.jdc.room.mappings.db.entity.Comment

@Dao
interface CommentDao {
    @Insert
    fun create(comment: Comment)

    @Query("select * from Comment where postId = :postId")
    fun findByPostId(postId:Int):List<Comment>
}