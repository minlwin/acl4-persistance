package com.jdc.room.mappings.db.entity

import androidx.room.Entity

@Entity(
    primaryKeys = ["postId", "serialNumber"]
)
data class Comment(
    var postId:Int,
    var serialNumber:Int,
    var comment:String,
    var creation:String
)