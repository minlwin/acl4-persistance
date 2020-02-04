package com.jdc.students.db.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.*

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = Course::class,
            parentColumns = ["id"],
            childColumns = ["courseId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index(name = "class_room_index_for_course", value = ["courseId"])
    ]
)
data class ClassRoom(
    @PrimaryKey(autoGenerate = true)
    val id:Long = 0,
    val courseId:Long = 0,
    val startDate:Date? = null,
    val times:String = "",
    val days:String = "",
    val fees:Int = 0
)