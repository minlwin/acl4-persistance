package com.jdc.students.ui.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jdc.students.R
import com.jdc.students.databinding.ItemStudentBinding
import com.jdc.students.db.entity.Student

class StudentAdapter : ListAdapter<Student, StudentAdapter.VH>(
    object : DiffUtil.ItemCallback<Student>() {
        override fun areItemsTheSame(oldItem: Student, newItem: Student) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Student, newItem: Student) = oldItem == newItem
    }
) {

    class VH(val binding: ItemStudentBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = VH(ItemStudentBinding.inflate(
        LayoutInflater.from(parent.context), parent, false
    ))

    override fun onBindViewHolder(holder: VH, position: Int) {
        getItem(position).also { student ->

            holder.binding.student = student

            val bundle = Bundle().also {
                it.putLong("id", student.id)
            }

            holder.binding.editBtn.setOnClickListener {
                it.findNavController().navigate(R.id.action_list_to_edit_student, bundle)
            }

            holder.binding.name.setOnClickListener {
                it.findNavController().navigate(R.id.action_list_to_details, bundle)
            }
        }

    }
}