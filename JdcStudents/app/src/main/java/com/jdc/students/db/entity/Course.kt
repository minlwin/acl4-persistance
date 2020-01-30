package com.jdc.students.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Course(
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0,
    var name:String = "",
    var duration:Double = 0.0,
    var fees:Int = 0,
    var description:String = ""
)