package com.jdc.using.room.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jdc.using.room.R
import com.jdc.using.room.db.Student
import kotlinx.android.synthetic.main.item_student.view.*

class StudentAdapter:ListAdapter<Student, StudentAdapter.VH>(object : DiffUtil.ItemCallback<Student>() {
    override fun areItemsTheSame(oldItem: Student, newItem: Student) = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: Student, newItem: Student) = oldItem == newItem
}) {

    class VH(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = VH(
        LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false)
    )

    override fun onBindViewHolder(holder: VH, position: Int) {
        val view = holder.itemView
        val student = getItem(position)

        view.name.text = student.name
        view.phone.text = student.phone
        view.email.text = student.email
        view.address.text = student.address
    }
}

