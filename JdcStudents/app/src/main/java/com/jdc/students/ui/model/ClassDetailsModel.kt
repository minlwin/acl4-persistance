package com.jdc.students.ui.model

import android.app.Application
import android.os.Bundle
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.navigation.findNavController
import com.jdc.students.R
import com.jdc.students.db.services.ClassService

class ClassDetailsModel(application: Application) : AndroidViewModel(application) {

    private val service = ClassService.service(application)

    val id = MutableLiveData(0L)

    val data = id.map { service.findByIdForDetails(it) }

    fun edit(view: View) {
        id.value?.also { classId ->
            view.findNavController().navigate(R.id.action_details_class_to_edit_class, Bundle().also {
                it.putLong("id", classId)
            })
        }
    }
}