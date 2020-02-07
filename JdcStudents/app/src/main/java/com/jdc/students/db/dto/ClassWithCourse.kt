package com.jdc.students.db.dto

import androidx.room.Embedded
import androidx.room.Relation
import com.jdc.students.db.entity.ClassRoom
import com.jdc.students.db.entity.Course

data class ClassWithCourse(
    @Embedded
    val classRoom:ClassRoom,
    @Relation(
        parentColumn = "courseId",
        entityColumn = "id"
    )
    val course: Course
)