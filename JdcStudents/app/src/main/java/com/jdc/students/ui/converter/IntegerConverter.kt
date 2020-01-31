package com.jdc.students.ui.converter

import androidx.databinding.InverseMethod

object IntegerConverter {

    @JvmStatic
    fun intToString(int: Int?) = int?.toString()

    @JvmStatic
    @InverseMethod("intToString")
    fun stringToInt(string: String?) = string?.toInt()
}