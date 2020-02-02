package com.jdc.using.room.db

import androidx.room.*

@Entity
data class Student(
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0,
    var name:String,
    var phone:String,
    var email:String,
    var address:String
)

@Dao
interface StudentDao {
    @Insert
    fun create(student: Student)

    @Update
    fun update(student: Student)

    @Query("delete from Student where id = :id")
    fun deleteById(id:Long)

    @Query("select * from Student")
    fun getAll():List<Student>
}