package com.jdc.product.app.ui.adapter

import android.content.Context
import android.widget.ArrayAdapter
import com.jdc.product.app.api.dto.Category

class CategoryArrayAdapter(context: Context) : ArrayAdapter<String>(
    context, android.R.layout.simple_spinner_dropdown_item
) {

    private val data = mutableListOf<Category>()

    fun submitList(list:List<Category>) {
        clear()
        addAll(list.map { it.name })
        data.clear()
        data.addAll(list)
    }

    fun getData(position: Int) = data[position]
}