package com.jdc.students.db.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.*

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = ClassRoom::class,
            parentColumns = ["id"],
            childColumns = ["classId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Student::class,
            parentColumns = ["id"],
            childColumns = ["studentId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index(
            name = "registration_index_1",
            value = ["classId"]
        ),
        Index(
            name = "registration_index_2",
            value = ["studentId"]
        ),
        Index(
            name = "registration_index_3",
            value = ["registDate"]
        )
    ]
)
data class Registration(
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0,
    var classId:Long = 0,
    var studentId:Long = 0,
    var registDate:Date? = null
)