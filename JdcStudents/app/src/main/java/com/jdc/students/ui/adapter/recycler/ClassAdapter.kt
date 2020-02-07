package com.jdc.students.ui.adapter.recycler

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jdc.students.R
import com.jdc.students.databinding.ItemClassBinding
import com.jdc.students.db.dto.ClassWithCourse
import kotlinx.android.synthetic.main.item_class.view.*

class ClassAdapter : ListAdapter<ClassWithCourse, ClassAdapter.VH>(
    object : DiffUtil.ItemCallback<ClassWithCourse>() {
        override fun areItemsTheSame(oldItem: ClassWithCourse, newItem: ClassWithCourse) =
            oldItem.classRoom.id == newItem.classRoom.id

        override fun areContentsTheSame(
            oldItem: ClassWithCourse,
            newItem: ClassWithCourse
        ) = oldItem == newItem

    }
) {

    class VH(val binding: ItemClassBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        VH(
            ItemClassBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: VH, position: Int) {

        getItem(position).also { classDto ->

            holder.binding.dto = classDto

            val bundle = Bundle().also {
                it.putLong("id", classDto.classRoom.id)
            }

            holder.itemView.editBtn.setOnClickListener {
                it.findNavController().navigate(R.id.action_classRooms_to_edit_class, bundle)
            }

            holder.itemView.name.setOnClickListener {
                it.findNavController().navigate(R.id.action_classRooms_to_details_class, bundle)
            }
        }
    }
}