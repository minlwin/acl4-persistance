package com.jdc.room.mappings.db.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.*

@Entity(
    indices = [
        Index(
            name = "post_index_01",
            value = ["title"]
        )
    ]
)
data class Post(
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0,
    var title:String?,
    var contents:String?,
    var creation:Date?
)