package com.jdc.restaurant.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.jdc.restaurant.R
import com.jdc.restaurant.databinding.FragmentProductBinding
import com.jdc.restaurant.ui.model.ProductEditModel
import com.jdc.restaurant.ui.model.ShoppingCart
import kotlinx.android.synthetic.main.fragment_product.*

class ProductFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_product, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val modal by viewModels<ProductEditModel>()
        val cart by activityViewModels<ShoppingCart>()

        val binding = FragmentProductBinding.bind(view)
        binding.lifecycleOwner = this
        binding.model = modal

        arguments?.getLong("id")?.also {
            modal.productId.value = it
        }

        addToCard.setOnClickListener {
            modal.dto.value?.product?.also { p ->
                cart.addToCart(p)
            }
        }
    }
}