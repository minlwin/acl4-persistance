package com.jdc.restaurant.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.jdc.restaurant.R
import com.jdc.restaurant.databinding.FragmentSaleBinding
import com.jdc.restaurant.ui.adapters.OrderAdapter
import com.jdc.restaurant.ui.model.ShoppingCart
import kotlinx.android.synthetic.main.fragment_sale.*

class SaleFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sale, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cart by activityViewModels<ShoppingCart>()
        val binding = FragmentSaleBinding.bind(view)
        binding.lifecycleOwner = this
        binding.cart = cart

        val adapter = OrderAdapter()
        adapter.submitList(cart.orders)

        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter
    }
}