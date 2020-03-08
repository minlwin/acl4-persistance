package com.jdc.restaurant.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jdc.restaurant.databinding.ItemSaleBinding
import com.jdc.restaurant.db.entity.Orders

class OrderAdapter:ListAdapter<Orders, OrderAdapter.VH>(
    object : DiffUtil.ItemCallback<Orders>() {
        override fun areItemsTheSame(oldItem: Orders, newItem: Orders) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Orders, newItem: Orders) = oldItem == newItem
    }
) {

    class VH(val binding:ItemSaleBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = VH(ItemSaleBinding.inflate(
        LayoutInflater.from(parent.context), parent, false
    ))

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.binding.order = getItem(position)
    }
}