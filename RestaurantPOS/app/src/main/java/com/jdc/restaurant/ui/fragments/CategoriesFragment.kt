package com.jdc.restaurant.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jdc.restaurant.R
import com.jdc.restaurant.ui.adapters.CategoryAdapter
import com.jdc.restaurant.ui.model.CategoryListModel
import kotlinx.android.synthetic.main.fragment_categories.*

class CategoriesFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_categories, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler.layoutManager = LinearLayoutManager(requireContext())

        val model by activityViewModels<CategoryListModel>()
        val adapter = CategoryAdapter()

        recycler.adapter = adapter

        model.list.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })

        val edit = object : ItemTouchHelper.SimpleCallback(ItemTouchHelper.RIGHT, ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean = true

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val vh = viewHolder as CategoryAdapter.VH

                vh.binding.c?.also {
                    view.findNavController().navigate(R.id.action_edit_category, bundleOf("id" to it.id))
                }
            }

        }

        val helper = ItemTouchHelper(edit)
        helper.attachToRecyclerView(recycler)
    }
}