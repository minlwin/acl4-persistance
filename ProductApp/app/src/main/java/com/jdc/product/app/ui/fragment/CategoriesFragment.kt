package com.jdc.product.app.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.jdc.product.app.R
import com.jdc.product.app.ui.adapter.CategoryAdapter
import com.jdc.product.app.ui.model.CategoriesModel
import kotlinx.android.synthetic.main.fragment_categories.*

class CategoriesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_categories, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = CategoryAdapter()

        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter

        val model by viewModels<CategoriesModel> ()
        model.list.observe(viewLifecycleOwner, Observer { adapter.submitList(it) })
        model.type.observe(viewLifecycleOwner, Observer {
            val activity = requireActivity() as AppCompatActivity
            activity.supportActionBar?.title = if(it.isEmpty()) "Categories" else it
        })
        model.type.value = arguments?.getString("type") ?: ""


    }
}
