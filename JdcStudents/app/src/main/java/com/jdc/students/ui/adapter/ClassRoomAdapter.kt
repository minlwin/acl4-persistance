package com.jdc.students.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jdc.students.databinding.ItemClassRoomBinding
import com.jdc.students.db.dto.ClassWithCourse

class ClassRoomAdapter : ListAdapter<ClassWithCourse, ClassRoomAdapter.VH>(object :
    DiffUtil.ItemCallback<ClassWithCourse>() {
    override fun areItemsTheSame(oldItem: ClassWithCourse, newItem: ClassWithCourse) =
        oldItem.classRoom.id == newItem.classRoom.id

    override fun areContentsTheSame(oldItem: ClassWithCourse, newItem: ClassWithCourse) =
        oldItem == newItem
}) {

    class VH(val binding: ItemClassRoomBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = VH(
        ItemClassRoomBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.binding.data = getItem(position)
    }
}