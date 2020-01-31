package com.jdc.students.db.services

import android.content.Context
import androidx.room.Transaction
import com.jdc.students.db.StudentDatabase
import com.jdc.students.db.entity.Course

class CourseService(context: Context) {

    private val courseDao = StudentDatabase.database(context).courseDao()

    @Transaction
    suspend fun save(course: Course): Long = if(course.id == 0L) {
        courseDao.create(course)
    } else {
        courseDao.update(course).let {
            course.id
        }
    }

    suspend fun findAllCourse() = courseDao.findAll()

    suspend fun findWithClassesById(id:Long) = courseDao.findWithClassesById(id)

    suspend fun findById(id:Long) = courseDao.findById(id)

    companion object {
        fun getInstance(context: Context) = CourseService(context)
    }
}