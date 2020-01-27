package com.jdc.room.hello.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Message(
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0,
    var data:String
)