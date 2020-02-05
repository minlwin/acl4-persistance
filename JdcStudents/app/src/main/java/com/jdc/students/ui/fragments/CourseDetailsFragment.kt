package com.jdc.students.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.jdc.students.R
import com.jdc.students.databinding.ContentCourseDetailsBinding
import com.jdc.students.ui.model.CourseEditModel
import kotlinx.android.synthetic.main.fragment_course_details.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class CourseDetailsFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_course_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        showSearch(false)

        val model by viewModels<CourseEditModel>()

        val binding = ContentCourseDetailsBinding.bind(content)
        binding.lifecycleOwner = this
        binding.c = model

        arguments?.getLong("id").also {
            model.id.value = it
        }

    }
}
