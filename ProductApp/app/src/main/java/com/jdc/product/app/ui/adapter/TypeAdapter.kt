package com.jdc.product.app.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jdc.product.app.R
import com.jdc.product.app.databinding.ItemTypeBinding

class TypeAdapter:ListAdapter<String, TypeAdapter.VH>(
    object : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String) = oldItem == newItem
        override fun areContentsTheSame(oldItem: String, newItem: String) = oldItem == newItem
    }
) {

    class VH(val binding:ItemTypeBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = VH(
        ItemTypeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.binding.type = getItem(position)
        holder.itemView.setOnClickListener {
            it.findNavController().navigate(R.id.action_global_categories, bundleOf("type" to getItem(position)))
        }
    }
}