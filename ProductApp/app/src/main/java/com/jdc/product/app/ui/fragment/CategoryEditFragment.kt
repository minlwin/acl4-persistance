package com.jdc.product.app.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer

import com.jdc.product.app.R
import com.jdc.product.app.databinding.FragmentCategoryEditBinding
import com.jdc.product.app.ui.model.CategoryModel
import com.jdc.product.app.ui.model.TypesViewModel
import kotlinx.android.synthetic.main.fragment_category_edit.*

class CategoryEditFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_category_edit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val types by activityViewModels<TypesViewModel>()
        val model by viewModels<CategoryModel>()

        val binding = FragmentCategoryEditBinding.bind(view)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.model = model

        val adapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_dropdown_item)
        type.setAdapter(adapter)

        types.types.observe(viewLifecycleOwner, Observer {
            adapter.clear()
            adapter.addAll(it)
        })

    }
}
