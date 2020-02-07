package com.jdc.students.ui.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.jdc.students.db.services.RegistrationService
import java.util.*

class RegistrationListModel(application: Application) : AndroidViewModel(application) {

    val service = RegistrationService.service(application)

    val from = MutableLiveData<Date?>(null)

    val data = from.switchMap { if(null == it) service.findAll() else service.search(it) }
}