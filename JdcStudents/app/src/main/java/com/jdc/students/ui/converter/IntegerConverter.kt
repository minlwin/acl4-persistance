package com.jdc.students.ui.converter

import android.widget.Toast
import androidx.databinding.InverseMethod
import com.jdc.students.MainActivity

object IntegerConverter {

    @JvmStatic
    fun intToString(int: Int?) = int?.toString()

    @JvmStatic
    @InverseMethod("intToString")
    fun stringToInt(string: String?) = string?.let {
        try {
            it.toInt()
        } catch (e:Throwable) {
            Toast.makeText(MainActivity.context, "Please Digit Correctly", Toast.LENGTH_LONG).show()
        }
    }
}