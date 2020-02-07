package com.jdc.students.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.jdc.students.db.entity.Registration
import com.jdc.students.db.view.Registrations
import java.util.*

@Dao
interface RegistrationDao {

    @Insert
    suspend fun insert(registration: Registration):Long

    @Update
    suspend fun update(registration: Registration)

    @Query("select * from Registrations where id = :id")
    fun findById(id:Long):LiveData<Registrations>

    @Query("select * from Registrations")
    fun findAll():LiveData<List<Registrations>>

    @Query("select * from Registrations where registDate >= :from")
    fun search(from:Date):LiveData<List<Registrations>>
}