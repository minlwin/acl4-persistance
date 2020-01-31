package com.jdc.students.db.converter

import androidx.room.TypeConverter
import java.util.*

class DateConverter {

    @TypeConverter
    fun dateToLong(date: Date?) = date?.let { it.time }

    @TypeConverter
    fun longToDate(long: Long?) = long?.let { Date(it) }
}