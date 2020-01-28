package com.jdc.room.mappings.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Post(
    @PrimaryKey
    var id:Int = 0,
    var title:String,
    var contents:String,
    var creation:String
)