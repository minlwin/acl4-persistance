package com.jdc.room.ignores.db.converter

import androidx.room.TypeConverter
import java.util.*

class DateConverter {

    @TypeConverter
    fun longToDate(long: Long?) = long?.let {
        Date(it)
    }

    @TypeConverter
    fun dateToLong(date: Date?) = date?.time
}