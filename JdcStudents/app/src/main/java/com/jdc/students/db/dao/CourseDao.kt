package com.jdc.students.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.jdc.students.db.dto.CourseWithClasses
import com.jdc.students.db.entity.Course

@Dao
interface CourseDao {

    @Insert
    fun create(course: Course):Long

    @Update
    fun update(course: Course)

    @Query("select * from Course")
    fun findAll():List<Course>

    @Query("select * from Course where id = :id")
    fun findWithClassesById(id:Long):CourseWithClasses

    @Query("select * from Course")
    fun findById(id:Long):Course
}