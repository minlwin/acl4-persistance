package com.jdc.students.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.jdc.students.db.dto.CourseWithClasses
import com.jdc.students.db.entity.Course

@Dao
interface CourseDao {

    @Insert
    suspend fun create(course: Course):Long

    @Update
    suspend fun update(course: Course)

    @Query("select * from Course")
    suspend fun findAll():List<Course>

    @Transaction
    @Query("select * from Course where id = :id")
    suspend fun findWithClassesById(id:Long):CourseWithClasses

    @Query("select * from Course where id = :id")
    suspend fun findById(id:Long):Course
}