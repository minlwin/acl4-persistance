package com.jdc.students.ui.model

import android.app.Application
import android.os.Bundle
import android.view.View
import androidx.lifecycle.*
import androidx.navigation.findNavController
import com.jdc.students.R
import com.jdc.students.db.entity.Course
import com.jdc.students.db.services.CourseService
import kotlinx.coroutines.launch

class CourseEditModel(application: Application):AndroidViewModel(application) {

    private val courseService = CourseService.getInstance(application)

    val data:LiveData<Course> = MutableLiveData(Course())

    fun save(view:View) {
        viewModelScope.launch {
            data.value?.also {  course ->
                courseService.save(course).also { id ->
                    view.findNavController()
                        .navigate(R.id.action_course_save, Bundle().also { b ->
                            b.putLong("courseId", id)
                        })
                }
            }
        }
    }

}