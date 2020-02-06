package com.jdc.students.ui.utils

import android.content.Context
import android.text.InputType
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.google.android.material.textview.MaterialAutoCompleteTextView
import com.jdc.students.db.entity.Course

class CourseArrayAdapter private constructor(context: Context) :
    ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, mutableListOf()),
    AdapterView.OnItemClickListener{

    private val courses = mutableListOf<Course>()
    private var selectedIndex:Int? = null

    val selectedItem:Course?
        get() = selectedIndex?.let {
            courses[it]
        }

    fun submitList(list:List<Course>) {
        courses.clear()
        courses.addAll(list)

        clear()
        addAll(list.map { it.name })
    }

    companion object {
        fun instance(context:Context, view: () -> MaterialAutoCompleteTextView):CourseArrayAdapter {
            val adapter = CourseArrayAdapter(context)
            val input = view()
            input.setAdapter(adapter)
            input.onItemClickListener = adapter
            return adapter
        }
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        selectedIndex = position
    }

}