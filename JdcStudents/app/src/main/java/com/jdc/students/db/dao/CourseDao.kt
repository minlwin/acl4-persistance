package com.jdc.students.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Update
import com.jdc.students.db.entity.Course

@Dao
interface CourseDao {

    @Insert
    suspend fun create(course: Course):Long

    @Update
    suspend fun update(course: Course)
}