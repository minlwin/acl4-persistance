package com.jdc.restaurant.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.jdc.restaurant.R
import com.jdc.restaurant.ui.adapters.SaleAdapter
import com.jdc.restaurant.ui.model.SaleListModel
import kotlinx.android.synthetic.main.fragment_sales.*

class SalesFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sales, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val modal by activityViewModels<SaleListModel>()

        val adapter = SaleAdapter()
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter

        modal.list.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
    }
}