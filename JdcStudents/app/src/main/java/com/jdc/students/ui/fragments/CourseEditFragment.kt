package com.jdc.students.ui.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels

import com.jdc.students.R
import com.jdc.students.databinding.FragmentCourseEditBinding
import com.jdc.students.db.services.CourseService
import com.jdc.students.ui.model.CourseEditModel
import kotlinx.android.synthetic.main.layout_toolbar.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class CourseEditFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_course_edit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val service = CourseService.getInstance(requireContext())
        val model by viewModels<CourseEditModel> ()

        val binding = FragmentCourseEditBinding.bind(view)
        binding.lifecycleOwner = this
        binding.model = model


        arguments?.getLong("id")?.also {

            runBlocking {
                withContext(Dispatchers.IO) {
                    val activity = requireActivity() as AppCompatActivity
                    activity.supportActionBar?.title = "Edit Course"
                    model.data.value = service.findById(it)
                }
            }
        }
    }
}
