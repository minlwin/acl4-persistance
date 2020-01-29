package com.jdc.room.mappings.db.dto

import androidx.room.Embedded
import androidx.room.Relation
import com.jdc.room.mappings.db.entity.Comment
import com.jdc.room.mappings.db.entity.Post

data class PostWithComments(
    @Embedded
    val post: Post,
    @Relation(
        parentColumn = "id",
        entityColumn = "postId"
    )
    val comments: List<Comment>
)