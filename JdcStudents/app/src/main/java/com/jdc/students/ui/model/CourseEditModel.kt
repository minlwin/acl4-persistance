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

    private val service = CourseService.service(application)

    val id = MutableLiveData(0L)

    val data = id.switchMap { if (it == 0L) MutableLiveData(Course()) else service.findById(it) }
    val title = id.map { if (it == 0L) "Add New Course" else "Edit Course" }

    fun save(view: View) {
        viewModelScope.launch {
            try {

                data.value?.also { course ->

                    validate(course)

                    val courseId = withContext(Dispatchers.IO) {
                        service.save(course)
                    }

                    view.findNavController()
                        .navigate(R.id.action_course_save, Bundle().also { bundle ->
                            bundle.putLong("id", courseId)
                        })
                }

            } catch (e: Throwable) {

            }
        }
    }

    fun edit(view: View) {
        view.findNavController().navigate(R.id.action_details_course_to_edit_course, Bundle().also {
            id.value?.also { courseId ->
                it.putLong("id", courseId)
            }
        })
    }

    private fun validate(course: Course) {

    }
}