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
import com.jdc.product.app.databinding.FragmentProductEditBinding
import com.jdc.product.app.ui.adapter.CategoryArrayAdapter
import com.jdc.product.app.ui.model.CategoriesModel
import com.jdc.product.app.ui.model.ProductModel
import com.jdc.product.app.ui.model.TypesViewModel
import kotlinx.android.synthetic.main.fragment_product_edit.*

class ProductEditFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_product_edit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val productModel by viewModels<ProductModel>()
        val binding = FragmentProductEditBinding.bind(view)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.model = productModel

        val typesModel by activityViewModels<TypesViewModel>()
        val typeAdapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_dropdown_item)
        typeSelect.setAdapter(typeAdapter)
        typesModel.types.observe(viewLifecycleOwner, Observer {
            typeAdapter.clear()
            typeAdapter.addAll(it)
        })


        val categoriesModel by viewModels<CategoriesModel>()
        val categoriesAdapter = CategoryArrayAdapter(requireContext())
        categorySelect.setAdapter(categoriesAdapter)
        categoriesModel.list.observe(viewLifecycleOwner, Observer { categoriesAdapter.submitList(it) })

        categorySelect.setOnItemClickListener { _, _, position, _ -> productModel.product.value?.also {
            it.category = categoriesAdapter.getData(position)
        }}

        typeSelect.setOnItemClickListener { _, _, position, _ ->
            typesModel.types?.value?.also {
                categoriesModel.type.value = it[position]
            }
        }
    }
}
