package com.jdc.restaurant.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jdc.restaurant.R
import com.jdc.restaurant.databinding.ItemProductBinding
import com.jdc.restaurant.db.dto.ProductWithCategory
import com.jdc.restaurant.db.entity.Product
import kotlinx.android.synthetic.main.item_product.view.*

class ProductAdapter(private val addToCart:(Product) -> Unit):ListAdapter<ProductWithCategory, ProductAdapter.VH>(
    object : DiffUtil.ItemCallback<ProductWithCategory>() {
        override fun areItemsTheSame(
            oldItem: ProductWithCategory,
            newItem: ProductWithCategory
        ): Boolean = oldItem.product.id == newItem.product.id

        override fun areContentsTheSame(
            oldItem: ProductWithCategory,
            newItem: ProductWithCategory
        ): Boolean = oldItem == newItem
    }
) {

    class VH(val binding:ItemProductBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = VH (
        ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: VH, position: Int) {

        val dto = getItem(position)
        holder.binding.p = dto

        holder.itemView.edit.setOnClickListener {
            it.findNavController().navigate(R.id.action_add_product, bundleOf("id" to dto.product.id))
        }

        holder.itemView.details.setOnClickListener {
            it.findNavController().navigate(R.id.action_products_to_product, bundleOf("id" to dto.product.id))
        }

        holder.itemView.addBtn.setOnClickListener {
            addToCart(dto.product)
        }
    }
}