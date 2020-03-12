package com.jdc.restaurant.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jdc.restaurant.databinding.ItemOrderBinding
import com.jdc.restaurant.db.entity.Orders

class OrderAdapter(
    private val adder:(Long?) -> Unit,
    private val remover:(Long?) -> Unit
):ListAdapter<Orders, OrderAdapter.VH>(
    object : DiffUtil.ItemCallback<Orders>() {
        override fun areItemsTheSame(oldItem: Orders, newItem: Orders) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Orders, newItem: Orders) = oldItem == newItem
    }
) {

    class VH(val binding:ItemOrderBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = VH(ItemOrderBinding.inflate(
        LayoutInflater.from(parent.context), parent, false
    ))

    override fun onBindViewHolder(holder: VH, position: Int) {
        val order = getItem(position)
        holder.binding.order = order

        holder.binding.plusBtn.setOnClickListener {
            adder(order.productId)
            notifyItemChanged(position)
        }

        holder.binding.minusBtn.setOnClickListener {
            remover(order.productId)
            notifyItemChanged(position)
        }
    }
}