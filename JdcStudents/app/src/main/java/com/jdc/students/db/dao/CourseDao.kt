package com.jdc.students.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.jdc.students.db.entity.Course

@Dao
interface CourseDao {

    @Insert
    suspend fun insert(course: Course):Long

    @Update
    suspend fun update(course: Course)

    @Query("select * from Course where id = :id")
    fun findById(id:Long):LiveData<Course>

    @Query("select * from Course")
    fun findAll():LiveData<List<Course>>

    @Query("select * from Course where lower(name) like :name")
    fun search(name:String):LiveData<List<Course>>
}