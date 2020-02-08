package com.jdc.restaurant.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.jdc.restaurant.R
import com.jdc.restaurant.databinding.FragmentCategoryEditBinding
import com.jdc.restaurant.ui.model.CategoryEditModel

class CategoryEditFragment:BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return  inflater.inflate(R.layout.fragment_category_edit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val model by viewModels<CategoryEditModel>()
        val binding = FragmentCategoryEditBinding.bind(view)
        binding.lifecycleOwner = this
        binding.model = model
    }
}