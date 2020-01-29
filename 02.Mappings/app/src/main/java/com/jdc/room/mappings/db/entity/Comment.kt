package com.jdc.room.mappings.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import java.util.*

@Entity(
    primaryKeys = ["postId", "serialNumber"],
    foreignKeys = [
        ForeignKey(
            entity = Post::class,
            childColumns = ["postId"],
            parentColumns = ["id"]
        )
    ]
)
data class Comment(
    var postId:Int,
    var serialNumber:Int,
    var comment:String?,
    var creation:Date?
)