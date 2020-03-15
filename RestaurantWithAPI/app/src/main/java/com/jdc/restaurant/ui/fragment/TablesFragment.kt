package com.jdc.restaurant.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager

import com.jdc.restaurant.R
import com.jdc.restaurant.api.ClientContext
import com.jdc.restaurant.ui.list.TableAdapter
import com.jdc.restaurant.ui.model.TablesViewModel
import kotlinx.android.synthetic.main.fragment_tables.*

class TablesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tables, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(null == ClientContext.token) {
            view.findNavController().navigate(R.id.action_tables_to_login)
        }

        recycler.layoutManager = GridLayoutManager(requireContext(), 3)

        val adapter = TableAdapter()
        recycler.adapter = adapter

        val model by viewModels<TablesViewModel>()
        model.tables.observe(viewLifecycleOwner, Observer { adapter.submitList(it) })
    }
}
