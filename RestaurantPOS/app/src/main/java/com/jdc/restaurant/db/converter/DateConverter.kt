package com.jdc.restaurant.db.converter

import androidx.room.TypeConverter
import java.util.*

class DateConverter {

    @TypeConverter
    fun toDate(long: Long?) = long?.let { Date(it) }

    @TypeConverter
    fun toLong(date: Date?) = date?.let { it.time }
}