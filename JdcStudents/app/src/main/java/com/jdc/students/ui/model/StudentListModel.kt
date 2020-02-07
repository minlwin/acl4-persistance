package com.jdc.students.ui.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.jdc.students.db.services.StudentService

class StudentListModel(application: Application) : AndroidViewModel(application) {

    private val service = StudentService.service(application)

    val keyword = MutableLiveData<String?>(null)

    val data = keyword.switchMap { if(null == it || it.isEmpty()) service.findAll() else service.search(it) }
}