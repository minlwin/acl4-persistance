package com.jdc.room.mappings.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Post(
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0,
    var title:String?,
    var contents:String?,
    var creation:Date?
)