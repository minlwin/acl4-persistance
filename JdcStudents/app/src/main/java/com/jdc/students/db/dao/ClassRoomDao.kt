package com.jdc.students.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.jdc.students.db.dto.ClassWithCourse
import com.jdc.students.db.entity.ClassRoom

@Dao
interface ClassRoomDao {

    @Insert
    suspend fun insert(classRoom: ClassRoom):Long

    @Insert
    suspend fun update(classRoom: ClassRoom)

    @Query("select * from ClassRoom where id = :id")
    fun findById(id:Long):LiveData<ClassRoom>

    @Query("select * from ClassRoom where id = :id")
    fun findByIdForDetails(id:Long):LiveData<ClassWithCourse>

    @Query("select * from ClassRoom")
    fun findAll():LiveData<List<ClassWithCourse>>

    @Query("""
        select cl.* from ClassRoom cl 
            join Course c on cl.courseId = c.id
            where lower(c.name) like :keyword or lower(cl.days) like :keyword 
            or lower(cl.times) like :keyword or lower(c.description) like :keyword
    """)
    fun search(keyword: String):LiveData<List<ClassWithCourse>>
}