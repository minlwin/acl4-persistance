package com.jdc.students.ui.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels

import com.jdc.students.R
import com.jdc.students.databinding.FragmentStudentEditBinding
import com.jdc.students.ui.model.StudentModel

class StudentEditFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_student_edit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val model by viewModels<StudentModel>()
        val binding = FragmentStudentEditBinding.bind(view)

        binding.lifecycleOwner = this
        binding.model = model
    }

}
