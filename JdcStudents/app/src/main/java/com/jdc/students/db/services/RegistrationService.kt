package com.jdc.students.db.services

import android.content.Context
import androidx.room.Transaction
import com.jdc.students.db.StudentDatabase
import com.jdc.students.db.view.Registrations
import java.util.*

class RegistrationService private constructor(context: Context) {

    private val dao = StudentDatabase.database(context).registrationDao()
    private val service = StudentService.service(context)

    @Transaction
    suspend fun save(registrations: Registrations):Long {

        registrations.studentId = service.save(registrations.student)

        return if(registrations.id == 0L) {
            dao.insert(registrations.registration)
        } else {
            dao.update(registrations.registration).let { registrations.id }
        }
    }

    fun findById(id:Long) = dao.findById(id)

    fun findAll() = dao.findAll()

    fun search(date: Date) = dao.search(date)

    companion object {
        fun service(context: Context) = RegistrationService(context)
    }
}