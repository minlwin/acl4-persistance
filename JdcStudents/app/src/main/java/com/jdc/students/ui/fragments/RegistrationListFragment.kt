package com.jdc.students.ui.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.jdc.students.R
import com.jdc.students.ui.adapter.RegistrationAdapter
import com.jdc.students.ui.model.RegistrationListModel
import kotlinx.android.synthetic.main.fragment_student_list.*

class RegistrationListFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_registration_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        super.init(Action.Date)

        val model by activityViewModels<RegistrationListModel>()
        val adapter = RegistrationAdapter()

        model.data.observe(this, Observer {
            adapter.submitList(it)
        })

        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter

        setDateSearchListener { model.from.value = it }
    }

}
