package com.jdc.students.ui.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.jdc.students.R

class CourseEditFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_course_edit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        
    }
}
