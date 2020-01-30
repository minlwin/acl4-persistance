package com.jdc.students.db.services

import android.content.Context
import com.jdc.students.db.StudentDatabase
import com.jdc.students.db.entity.Course

class CourseService(context: Context) {

    private val courseDao = StudentDatabase.database(context).courseDao()

    suspend fun save(course: Course): Long = if(course.id == 0L) {
        courseDao.create(course)
    } else {
        courseDao.update(course).let {
            course.id
        }
    }

    companion object {
        fun getInstance(context: Context) = CourseService(context)
    }
}