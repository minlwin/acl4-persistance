package com.jdc.students.db.services

import android.content.Context
import com.jdc.students.db.StudentDatabase
import com.jdc.students.db.entity.Student

class StudentService private constructor(context: Context) {

    private val dao = StudentDatabase.database(context).studentDao()

    suspend fun save(student: Student) = if(student.id == 0L)
        dao.insert(student) else dao.update(student).let { student.id }

    fun findById(id:Long) = dao.findById(id)

    fun findAll() = dao.findAll()

    fun search(keyword:String) = dao.search(keyword)

    companion object {

        fun service(context: Context) = StudentService(context)
    }
}