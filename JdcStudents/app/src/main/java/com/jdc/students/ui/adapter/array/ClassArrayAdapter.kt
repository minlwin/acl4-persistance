package com.jdc.students.ui.adapter.array

import android.content.Context
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import com.jdc.students.db.dto.ClassWithCourse
import com.jdc.students.ui.converter.DateFormatter

class ClassArrayAdapter private constructor(
    context: Context,
    private val consumer: (ClassWithCourse) -> Unit
) :
    ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, mutableListOf()),
    AdapterView.OnItemClickListener {

    private val classRooms = mutableListOf<ClassWithCourse>()

    fun submitList(list: List<ClassWithCourse>) {
        clear()
        addAll(list.map { "${it.course.name} - ${DateFormatter.format(it.classRoom.startDate)}" })

        classRooms.clear()
        classRooms.addAll(list)
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        consumer(classRooms[position])
    }

    companion object {

        fun instance(
            context: Context,
            consumer: (ClassWithCourse) -> Unit,
            view: AutoCompleteTextView
        ) = ClassArrayAdapter(
            context,
            consumer
        ).also {
            view.setAdapter(it)
            view.onItemClickListener = it
        }
    }

}