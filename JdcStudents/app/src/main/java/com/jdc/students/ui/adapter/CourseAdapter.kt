package com.jdc.students.ui.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jdc.students.R
import com.jdc.students.databinding.ItemCourseBinding
import com.jdc.students.db.entity.Course
import kotlinx.android.synthetic.main.item_course.view.*

class CourseAdapter() : ListAdapter<Course, CourseAdapter.VH>(
    object : DiffUtil.ItemCallback<Course>() {
        override fun areItemsTheSame(oldItem: Course, newItem: Course) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Course, newItem: Course) = oldItem == newItem
    }
) {

    class VH(val binding: ItemCourseBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = VH(
        ItemCourseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: VH, position: Int) {
        val course = getItem(position)
        holder.binding.c = course

        holder.itemView.edit.setOnClickListener {
            it.findNavController()
                .navigate(R.id.action_courses_to_edit_course, Bundle().also { bundle ->
                    bundle.putLong("id", course.id)
                })
        }

        holder.itemView.name.setOnClickListener {
            it.findNavController()
                .navigate(R.id.action_courses_to_details_course, Bundle().also { bundle ->
                    bundle.putLong("id", course.id)
                })
        }
    }

}