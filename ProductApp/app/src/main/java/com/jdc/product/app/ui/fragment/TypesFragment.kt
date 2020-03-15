package com.jdc.product.app.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.jdc.product.app.R
import com.jdc.product.app.ui.adapter.TypeAdapter
import com.jdc.product.app.ui.model.TypesViewModel
import kotlinx.android.synthetic.main.fragment_types.*

class TypesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_types, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler.layoutManager = LinearLayoutManager(requireContext())
        val adapter = TypeAdapter()
        recycler.adapter = adapter

        val model by activityViewModels<TypesViewModel>()
        model.types.observe(viewLifecycleOwner, Observer { adapter.submitList(it) })
    }
}
