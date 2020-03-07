package com.jdc.restaurant.ui.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer

import com.jdc.restaurant.R
import com.jdc.restaurant.databinding.FragmentProductEditBinding
import com.jdc.restaurant.ui.adapters.CategoryArrayAdapter
import com.jdc.restaurant.ui.model.CategoryListModel
import com.jdc.restaurant.ui.model.ProductEditModel
import kotlinx.android.synthetic.main.fragment_product_edit.*

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
        binding.lifecycleOwner = viewLifecycleOwner
        binding.model = model

        val categories by activityViewModels<CategoryListModel>()

        val categoryArrayAdapter = CategoryArrayAdapter(requireContext())

        categorySelect.setAdapter(categoryArrayAdapter)

        categories.list.observe(viewLifecycleOwner, Observer {
            categoryArrayAdapter.submitList(it)
        })

        categorySelect.setOnItemClickListener { _, _, position, _ ->
            model.dto.value?.apply {
                this.category = categoryArrayAdapter.getCategory(position)
            }
        }

        arguments?.getLong("id")?.also {
            model.productId.value = it
        }

    }

}
