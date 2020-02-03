package com.jdc.students.ui.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager

import com.jdc.students.R
import com.jdc.students.databinding.FragmentCourseDetailsBinding
import com.jdc.students.databinding.FragmentCourseEditBinding
import com.jdc.students.db.services.CourseService
import com.jdc.students.ui.adapter.ClassForCourseAdapter
import kotlinx.android.synthetic.main.fragment_course_details.*
import kotlinx.android.synthetic.main.summary_course.*
import kotlinx.coroutines.runBlocking

class CourseDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_course_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val service = CourseService.getInstance(requireContext())
        val binding = FragmentCourseDetailsBinding.bind(view)
        val id = arguments?.getLong("id")

        classList.layoutManager = LinearLayoutManager(requireContext())
        val adapter = ClassForCourseAdapter().also {
            classList.adapter = it
        }

        id?.also {

            runBlocking {
                val courseWithClasses = service.findWithClassesById(it)
                binding.course = courseWithClasses.course
                adapter.submitList(courseWithClasses.list)
            }

            editBtn.setOnClickListener {
                it.findNavController().navigate(R.id.action_details_course_to_edit_course, arguments)
            }
        }

    }

}
