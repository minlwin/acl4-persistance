package com.jdc.students.ui.utils

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Filter
import android.widget.TextView
import com.jdc.students.db.entity.Course

class CourseArrayAdapter(
    context: Context,
    private val resource: Int,
    private val list: MutableList<Course>
) :
    ArrayAdapter<Course>(context, resource, list) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val course = getItem(position)
        val view = convertView as TextView ?: LayoutInflater.from(parent.context).inflate(
            resource,
            parent,
            false
        ) as TextView

        course?.also {
            view.text = course.name
        }

        return view
    }

    override fun getFilter(): Filter {

        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {

                val result = Filter.FilterResults()

                val query = constraint?.toString()?.toLowerCase()

                result.values = if (query.isNullOrEmpty()) list else list.map { it.name }.filter {
                    it.toLowerCase().startsWith(query)
                }

                return result
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                notifyDataSetChanged()
            }

        }
    }
}