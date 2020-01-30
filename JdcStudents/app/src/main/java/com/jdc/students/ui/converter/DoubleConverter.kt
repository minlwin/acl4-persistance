package com.jdc.students.ui.converter

import androidx.databinding.InverseMethod

object DoubleConverter {

    @JvmStatic
    fun doubleToString(double: Double?) = double?.toString()

    @JvmStatic
    @InverseMethod("doubleToString")
    fun stringToDouble(string: String?) = string?.let {
        it.toDouble()
    }
}