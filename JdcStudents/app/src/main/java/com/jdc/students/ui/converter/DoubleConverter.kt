package com.jdc.students.ui.converter

import android.widget.Toast
import androidx.databinding.InverseMethod
import com.jdc.students.MainActivity

object DoubleConverter {

    @JvmStatic
    fun doubleToString(double: Double?) = double?.toString()

    @JvmStatic
    @InverseMethod("doubleToString")
    fun stringToDouble(string: String?) = string?.let {
        try {
            it.toDouble()
        } catch (e:Throwable) {
            Toast.makeText(MainActivity.context, "Please Digit Correctly", Toast.LENGTH_LONG).show()
        }
    }
}