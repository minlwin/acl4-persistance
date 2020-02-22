package com.jdc.restaurant.ui.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels

import com.jdc.restaurant.R
import com.jdc.restaurant.databinding.FragmentProductEditBinding
import com.jdc.restaurant.ui.model.ProductEditModel

class ProductEditFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_product_edit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val model by viewModels<ProductEditModel>()
        val binding = FragmentProductEditBinding.bind(view)
        binding.lifecycleOwner = this

    }

}
