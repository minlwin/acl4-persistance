package com.jdc.students.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jdc.students.databinding.ItemClassForCourseBinding
import com.jdc.students.db.entity.ClassRoom

class ClassForCourseAdapter :
    ListAdapter<ClassRoom, ClassForCourseAdapter.VH>(object : DiffUtil.ItemCallback<ClassRoom>() {
        override fun areItemsTheSame(oldItem: ClassRoom, newItem: ClassRoom) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: ClassRoom, newItem: ClassRoom) = oldItem == newItem
    }) {

    class VH(val binding: ItemClassForCourseBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = VH(
        ItemClassForCourseBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.binding.data = getItem(position)
    }
}