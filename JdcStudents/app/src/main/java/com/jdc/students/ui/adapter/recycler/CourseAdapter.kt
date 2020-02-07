package com.jdc.students.ui.adapter.recycler

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

class CourseAdapter:ListAdapter<Course, CourseAdapter.VH>(
    object : DiffUtil.ItemCallback<Course>() {
        override fun areItemsTheSame(oldItem: Course, newItem: Course) = newItem.id == oldItem.id
        override fun areContentsTheSame(oldItem: Course, newItem: Course) = newItem == oldItem
    }
) {

    class VH(val binding: ItemCourseBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        VH(
            ItemCourseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: VH, position: Int) {
        getItem(position).also { course ->

            holder.binding.c = course

            val bundle = Bundle().also {
                it.putLong("id", course.id)
            }

            holder.binding.name.setOnClickListener {
                it.findNavController().navigate(R.id.action_courses_to_details_course, bundle)
            }

            holder.binding.editBtn.setOnClickListener {
                it.findNavController().navigate(R.id.action_courses_to_edit_course, bundle)
            }

        }
    }
}