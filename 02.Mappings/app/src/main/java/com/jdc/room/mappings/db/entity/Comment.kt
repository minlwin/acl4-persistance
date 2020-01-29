package com.jdc.room.mappings.db.entity

import androidx.room.*
import java.util.*

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = Post::class,
            childColumns = ["postId"],
            parentColumns = ["id"]
        )
    ]
)
data class Comment(
    @PrimaryKey @Embedded
    var id:CommentPK,
    var comment:String?,
    var creation:Date?
)

data class CommentPK(
    var postId:Int,
    var serialNumber:Int
)