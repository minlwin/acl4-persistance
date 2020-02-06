package com.jdc.students.ui.converter

import android.app.DatePickerDialog
import android.content.Context
import android.text.InputType
import android.widget.DatePicker
import android.widget.EditText
import androidx.databinding.InverseMethod
import java.text.SimpleDateFormat
import java.util.*


object DateFormatter {

    val dateViewFormat = SimpleDateFormat("yyyy/MM/dd")

    @JvmStatic
    fun format(date: Date?) = date?.let {
        dateViewFormat.format(it)
    }

    @JvmStatic
    @InverseMethod("format")
    fun parse(string: String?) = string?.let {
        if(it.isNotEmpty()) {
            dateViewFormat.parse(it)
        } else {
            null
        }
    }
}

inline fun datepicker(context: Context, crossinline editText: () -> EditText) {

    val calendar = Calendar.getInstance()

    val onDateSelectListener =
        DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            editText().setText(DateFormatter.format(date = calendar.time))
        }

    val dialog = DatePickerDialog(context, onDateSelectListener, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH))

    editText().inputType = InputType.TYPE_NULL
    editText().setOnClickListener { _ ->
        DateFormatter.parse(editText().text.toString())?.also {
            calendar.time = it
        }

        dialog.updateDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH))
        dialog.show()
    }
}