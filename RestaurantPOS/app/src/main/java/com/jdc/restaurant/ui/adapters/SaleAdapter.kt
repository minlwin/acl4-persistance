package com.jdc.restaurant.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jdc.restaurant.databinding.ItemSaleBinding
import com.jdc.restaurant.db.entity.Sale

class SaleAdapter: ListAdapter<Sale, SaleAdapter.VH>(
    object : DiffUtil.ItemCallback<Sale>() {
        override fun areItemsTheSame(oldItem: Sale, newItem: Sale) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Sale, newItem: Sale) = oldItem == newItem
    }
) {

    class VH(val binding: ItemSaleBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = VH(
        ItemSaleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: VH, position: Int) {
        val data = getItem(position)
        holder.binding.sale = data
    }
}