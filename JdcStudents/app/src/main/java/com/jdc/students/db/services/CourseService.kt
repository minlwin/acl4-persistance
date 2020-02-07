package com.jdc.students.db.services

import android.content.Context
import androidx.room.Transaction
import com.jdc.students.db.StudentDatabase
import com.jdc.students.db.entity.Course

class CourseService private constructor(context: Context) {

    private val dao = StudentDatabase.database(context).courseDao()

    fun findById(id: Long) = dao.findById(id)

    fun findAll() = dao.findAll()

    fun search(string: String) = dao.search("%${string.toLowerCase()}%")

    @Transaction
    suspend fun save(course: Course): Long = if (course.id == 0L)
        dao.insert(course) else dao.update(course).let { course.id }

    companion object {

        private lateinit var instance: CourseService

        fun service(context: Context) = if (::instance.isInitialized) instance
        else CourseService(context).also {
            instance = it
        }
    }
}