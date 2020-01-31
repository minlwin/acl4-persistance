package com.jdc.students.ui.model

import android.app.Application
import android.os.Bundle
import android.view.View
import androidx.lifecycle.*
import androidx.navigation.findNavController
import com.jdc.students.R
import com.jdc.students.db.entity.Course
import com.jdc.students.db.services.CourseService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CourseEditModel(application: Application) : AndroidViewModel(application) {

    private val courseService = CourseService.getInstance(application)

    val data: MutableLiveData<Course> = MutableLiveData(Course())

    fun save(view: View) {
        data.value?.let { course ->
            viewModelScope.launch {
                val id = courseService.save(course)
                view.findNavController()
                    .navigate(R.id.action_course_save, Bundle().also {
                        it.putLong("id", id)
                    })
            }
        }
    }

}