package com.jdc.room.mappings.db.converter

import androidx.room.TypeConverter
import java.util.*

class DateConverter {

    @TypeConverter
    fun dateToLong(date:Date?) = date?.time

    @TypeConverter
    fun longToDate(long: Long?) = long?.let { Date(it) }
}