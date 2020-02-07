package com.jdc.students.ui.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.jdc.students.db.services.CourseService

class CourseListModel(application: Application) : AndroidViewModel(application) {

    private val service = CourseService.service(application)

    val query = MutableLiveData<String?>("")

    val list = query.switchMap { if(it.isNullOrEmpty()) service.findAll() else service.search(it) }

}