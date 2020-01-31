package com.jdc.students.ui.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.jdc.students.R
import com.jdc.students.db.services.CourseService
import com.jdc.students.ui.adapter.CourseAdapter
import kotlinx.android.synthetic.main.fragment_course_list.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class CourseListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_course_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val service = CourseService.getInstance(requireContext())

        val adapter = CourseAdapter()

        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter

        runBlocking {
            withContext(Dispatchers.IO) {
                adapter.submitList(service.findAllCourse())
            }
        }

    }


}
