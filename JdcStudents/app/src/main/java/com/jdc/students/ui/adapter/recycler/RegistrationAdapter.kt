package com.jdc.students.ui.adapter.recycler

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jdc.students.R
import com.jdc.students.databinding.ItemRegistrationBinding
import com.jdc.students.db.view.Registrations
import kotlinx.android.synthetic.main.item_registration.view.*

class RegistrationAdapter : ListAdapter<Registrations, RegistrationAdapter.VH>(
    object : DiffUtil.ItemCallback<Registrations>() {
        override fun areItemsTheSame(oldItem: Registrations, newItem: Registrations) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Registrations, newItem: Registrations) =
            oldItem == newItem
    }
) {

    class VH(val binding: ItemRegistrationBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        VH(
            ItemRegistrationBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindViewHolder(holder: VH, position: Int) {
        getItem(position).also { data ->
            holder.binding.data = data

            val bundle = Bundle().also {
                it.putLong("id", data.id)
            }

            holder.itemView.name.setOnClickListener {
                it.findNavController().navigate(R.id.action_registrations_to_details, bundle)
            }

            holder.itemView.editBtn.setOnClickListener {
                it.findNavController().navigate(R.id.action_registration_edit, bundle)
            }
        }
    }
}