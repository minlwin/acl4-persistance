package com.jdc.students.ui.model

import android.app.Application
import android.os.Bundle
import android.view.View
import androidx.lifecycle.*
import androidx.navigation.findNavController
import com.jdc.students.R
import com.jdc.students.db.entity.ClassRoom
import com.jdc.students.db.entity.Course
import com.jdc.students.db.services.ClassService
import com.jdc.students.db.services.CourseService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ClassEditModel(application: Application) : AndroidViewModel(application) {

    private val service = ClassService.service(application)
    private val courseService = CourseService.service(application)

    val id = MutableLiveData(0L)

    val data = id.switchMap { if(it == 0L) MutableLiveData(ClassRoom()) else service.findById(it) }

    val title = id.map { if(it == 0L) "Add Class" else "Edit Class" }

    val courseName = id.switchMap { if(it == 0L) MutableLiveData("") else courseService.findById(it).map { c -> c.name } }

    fun setCourse(course:Course) {
        data.value?.also {
            it.courseId = course.id
            it.fees = course.fees
        }
    }

    fun save(view:View) {
        viewModelScope.launch {

            try {

                data.value?.also { classRoom ->

                    validate(classRoom)

                    val classId = withContext(Dispatchers.IO) {
                        service.save(classRoom)
                    }

                    view.findNavController().navigate(R.id.action_edit_class_to_details_class, Bundle().also { bundle ->
                        bundle.putLong("id", classId)
                    })
                }

            } catch (e:Throwable) {
                e.printStackTrace()
            }
        }
    }

    private fun validate(classRoom: ClassRoom) {

    }
}