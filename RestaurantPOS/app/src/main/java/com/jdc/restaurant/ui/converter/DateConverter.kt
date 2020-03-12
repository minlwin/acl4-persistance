package com.jdc.restaurant.ui.converter

import java.text.SimpleDateFormat
import java.util.*

object DateConverter {

    private val df = SimpleDateFormat("yyyy-MM-dd HH:mm")

    @JvmStatic
    fun format(date:Date?) = date?.let {
        df.format(it)
    }
}