package com.jdc.product.app.ui.converter

import androidx.databinding.InverseMethod

object IntegerConverter {

    @JvmStatic
    @InverseMethod("toInt")
    fun toString(data:Int?) = data?.toString()

    @JvmStatic
    fun toInt(data:String?) = data?.toInt()
}