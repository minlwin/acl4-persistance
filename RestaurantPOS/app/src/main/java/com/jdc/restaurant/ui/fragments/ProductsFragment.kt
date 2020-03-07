package com.jdc.restaurant.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.jdc.restaurant.R
import com.jdc.restaurant.ui.adapters.ProductAdapter
import com.jdc.restaurant.ui.model.ProductListModel
import com.jdc.restaurant.ui.model.ShoppingCart
import kotlinx.android.synthetic.main.fragment_products.*

class ProductsFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_products, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val model by activityViewModels<ProductListModel>()
        val cart by activityViewModels<ShoppingCart>()

        val adapter = ProductAdapter(cart::addToCart)

        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter

        model.list.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
    }
}
