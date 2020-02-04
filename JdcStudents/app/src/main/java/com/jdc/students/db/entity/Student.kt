package com.jdc.students.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Student(
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0,
    var name:String = "",
    var phone:String = "",
    var email:String = ""
)