package com.jdc.students.db.dto

import androidx.room.Embedded
import androidx.room.Relation
import com.jdc.students.db.entity.ClassRoom
import com.jdc.students.db.entity.Course

data class CourseWithClasses(
    @Embedded
    val course: Course,
    @Relation(
        parentColumn = "id",
        entityColumn = "courseId"
    )
    val list:List<ClassRoom>
)