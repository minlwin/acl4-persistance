package com.jdc.restaurant.ui.adapters

import android.content.Context
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.jdc.restaurant.db.entity.Category
import java.util.*

class CategoryArrayAdapter(context: Context) : ArrayAdapter<String>(
    context,
    android.R.layout.simple_spinner_dropdown_item,
    mutableListOf()
) {

    private val list = mutableListOf<Category>()

    fun submitList(list:List<Category>) {
        this.list.clear()
        this.list.addAll(list)

        clear()
        addAll(list.map { it.name })
    }

    fun getCategory(position:Int) = list[position]
}