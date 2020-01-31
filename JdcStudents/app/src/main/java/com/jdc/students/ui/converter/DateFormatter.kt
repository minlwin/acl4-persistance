package com.jdc.students.ui.converter

import java.text.SimpleDateFormat
import java.util.*


object DateFormatter {

    private val dateViewFormat = SimpleDateFormat("yyyy/MM/dd")

    @JvmStatic
    fun format(date: Date?) = date?.let {
        dateViewFormat.format(it)
    }
}