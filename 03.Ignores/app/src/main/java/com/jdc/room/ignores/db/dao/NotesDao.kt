package com.jdc.room.ignores.db.dao

import androidx.room.*
import com.jdc.room.ignores.db.entity.Notes

@Dao
interface NotesDao {

    @Insert
    fun create(notes: Notes):Long

    @Update
    fun update(notes: Notes)

    @Delete
    fun delete(notes: Notes)

    @Query("select * from Notes where id = :id")
    fun findById(id:Long):Notes

    @Query("select * from Notes")
    fun findAll():List<Notes>
}