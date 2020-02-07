package com.jdc.students.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.jdc.students.db.entity.Student

@Dao
interface StudentDao {

    @Insert
    suspend fun insert(student:Student):Long

    @Update
    suspend fun update(student: Student)

    @Query("select * from Student where id = :id")
    fun findById(id:Long):LiveData<Student>

    @Query("select * from Student")
    fun findAll():LiveData<List<Student>>

    @Query("""
        select * from Student where 
            name like :keyword or 
            phone like :keyword or 
            email like :keyword
    """)
    fun search(keyword:String):LiveData<List<Student>>
}