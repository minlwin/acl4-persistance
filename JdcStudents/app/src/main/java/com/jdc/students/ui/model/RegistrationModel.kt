package com.jdc.students.ui.model

import android.app.Application
import android.os.Bundle
import android.view.View
import androidx.lifecycle.*
import androidx.navigation.findNavController
import com.jdc.students.R
import com.jdc.students.db.dto.ClassWithCourse
import com.jdc.students.db.services.RegistrationService
import com.jdc.students.db.view.Registrations
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class RegistrationModel(application: Application) : AndroidViewModel(application) {

    private val service = RegistrationService.service(application)

    val id = MutableLiveData(0L)

    val data = id.switchMap { if(it == 0L) MutableLiveData(Registrations()) else service.findById(it) }

    val title = id.map { if(it == 0L) "Add Registration" else "Edit Registration" }

    fun setClass(dto:ClassWithCourse) {
        data.value?.also {
            it.classId = dto.classRoom.id
        }
    }

    fun edit(view:View) {
        val registrationId = id.value

        if(null != registrationId && registrationId != 0L) {
            view.findNavController().navigate(R.id.action_registration_edit, Bundle().also {
                it.putLong("id", registrationId)
            })
        }
    }

    fun save(view: View) {

        viewModelScope.launch {

            data.value?.also { registrations ->
                try {

                    validate(registrations)

                    val registrationId = withContext(Dispatchers.IO) {
                        registrations.registDate = Date()
                        service.save(registrations)
                    }

                    view.findNavController().navigate(R.id.action_registration_save, Bundle().also { bundle ->
                        bundle.putLong("id", registrationId)
                    })

                } catch (e:Throwable) {

                }
            }
        }
    }

    private fun validate(registrations: Registrations) {

    }
}