package com.jdc.restaurant.ui.converter

import androidx.databinding.InverseMethod

object IntegerConverter {

    @JvmStatic
    @InverseMethod("stringToInt")
    fun intToString(data:Int?) = data?.toString()

    @JvmStatic
    fun stringToInt(data:String?) = data?.toInt()
}