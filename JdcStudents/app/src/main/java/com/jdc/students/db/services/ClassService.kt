package com.jdc.students.db.services

import android.content.Context
import androidx.room.Transaction
import com.jdc.students.db.StudentDatabase
import com.jdc.students.db.entity.ClassRoom
import java.util.*

class ClassService private constructor(context: Context) {

    private val dao = StudentDatabase.database(context).classRoomDao()

    @Transaction
    suspend fun save(classRoom: ClassRoom) = if(classRoom.id == 0L)
        dao.insert(classRoom) else dao.update(classRoom).let { classRoom.id }

    fun findById(id:Long) = dao.findById(id)

    @Transaction
    fun findByIdForDetails(id:Long) = dao.findByIdForDetails(id)

    @Transaction
    fun findAll() = dao.findAll()

    @Transaction
    fun search(keyword:String) = dao.search(keyword)

    @Transaction
    fun search(from:Date) = dao.search(from)

    companion object {
        private lateinit var instance:ClassService

        fun service(context: Context) = if(::instance.isInitialized)
            instance else ClassService(context).also {
            instance = it
        }
    }
}