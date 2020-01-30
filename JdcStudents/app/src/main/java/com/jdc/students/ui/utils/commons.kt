package com.jdc.students.ui.utils

object MyanmarKyatConverter {

    @JvmStatic
    fun convertToKyat(value:Int?) = value?.let {
        "$it MMK"
    }
}