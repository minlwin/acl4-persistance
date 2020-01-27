package com.jdc.room.hello.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MessageDao {
    @Insert
    fun create(message: Message)

    @Query("select * from Message")
    fun findAll():List<Message>
}