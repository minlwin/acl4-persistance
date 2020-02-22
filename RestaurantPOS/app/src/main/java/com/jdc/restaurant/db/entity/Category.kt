package com.jdc.restaurant.db.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    indices = [
        Index(value = ["name"], unique = true)
    ]
)
data class Category(
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0,
    var name:String = "",
    var description:String = ""
)