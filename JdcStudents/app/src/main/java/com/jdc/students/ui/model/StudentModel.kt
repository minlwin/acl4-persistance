package com.jdc.students.ui.model

import android.app.Application
import android.os.Bundle
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import com.jdc.students.R
import com.jdc.students.db.entity.Student
import com.jdc.students.db.services.StudentService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class StudentModel(application: Application) : AndroidViewModel(application) {

    private val service = StudentService.service(application)

    val id = MutableLiveData(0L)

    val data = id.switchMap { if(it == 0L) MutableLiveData(Student()) else service.findById(it) }

    fun save(view:View) {

        viewModelScope.launch {

            data.value?.also { student ->

                try {

                    validate(student)

                    val id = withContext(Dispatchers.IO) {
                        service.save(student)
                    }

                    view.findNavController().navigate(R.id.action_save_student, Bundle().also {
                        b -> b.putLong("id", id)
                    })
                } catch (e:Throwable) {

                }

            }
        }
    }

    fun edit(view: View) {
        id.value?.also {
            if(it > 0L) {
                view.findNavController().navigate(R.id.action_details_to_edit_student, Bundle().also { bundle ->
                    bundle.putLong("id", it)
                })
            }
        }
    }

    private fun validate(student: Student) {

    }
}