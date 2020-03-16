package com.jdc.product.app.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.jdc.product.app.R
import com.jdc.product.app.ui.adapter.ProductAdapter
import com.jdc.product.app.ui.model.ProductsModel
import kotlinx.android.synthetic.main.fragment_products.*

class ProductsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_products, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ProductAdapter()
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter

        val model by viewModels<ProductsModel>()
        model.list.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })

        arguments?.getInt("category")?.also {
            model.category.value = it
        }
    }
}
