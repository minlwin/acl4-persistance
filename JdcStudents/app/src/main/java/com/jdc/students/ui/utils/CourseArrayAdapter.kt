package com.jdc.students.ui.utils

import android.content.Context
import android.text.InputType
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.google.android.material.textview.MaterialAutoCompleteTextView
import com.jdc.students.db.entity.Course

class CourseArrayAdapter private constructor(
    context: Context,
    private val consumer: (Course) -> Unit
) :
    ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, mutableListOf()),
    AdapterView.OnItemClickListener {

    private val courses = mutableListOf<Course>()

    fun submitList(list: List<Course>) {
        courses.clear()
        courses.addAll(list)

        clear()
        addAll(list.map { it.name })
    }

    companion object {
        fun instance(
            context: Context,
            consumer: (Course) -> Unit,
            view: MaterialAutoCompleteTextView
        ) = CourseArrayAdapter(context, consumer).also {
            view.setAdapter(it)
            view.onItemClickListener = it
        }
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        consumer(courses[position])
    }

}