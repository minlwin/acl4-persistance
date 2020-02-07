package com.jdc.students.ui.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.jdc.students.db.services.ClassService
import java.util.*

class ClassListModel(application: Application) : AndroidViewModel(application) {

    private val service = ClassService.service(application)

    val from = MutableLiveData<Date?>(null)

    val list = from.switchMap {
        if(null == it) service.findAll() else service.search(it)
    }
}