package com.jdc.students.ui.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.jdc.students.R
import com.jdc.students.ui.adapter.StudentAdapter
import com.jdc.students.ui.model.StudentListModel
import kotlinx.android.synthetic.main.fragment_student_list.*

class StudentListFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_student_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        super.init(Action.Search)

        val model by activityViewModels<StudentListModel>()
        val adapter = StudentAdapter()

        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter

        model.data.observe(this, Observer {
            adapter.submitList(it)
        })

        setSearchListener {
            model.keyword.value = it
            true
        }
    }

}
