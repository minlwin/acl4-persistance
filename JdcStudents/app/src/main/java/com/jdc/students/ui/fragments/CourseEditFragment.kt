package com.jdc.students.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.jdc.students.R
import com.jdc.students.databinding.FragmentCourseEditBinding
import com.jdc.students.ui.model.CourseEditModel

class CourseEditFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_course_edit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        val model by viewModels<CourseEditModel>()
        val binding = FragmentCourseEditBinding.bind(view)
        binding.lifecycleOwner = this
        binding.model = model

        model.title.observe(this, Observer {
            toolbar.title = it
        })

        arguments?.getLong("id")?.also {
            model.id.value = it
        }

    }
}
