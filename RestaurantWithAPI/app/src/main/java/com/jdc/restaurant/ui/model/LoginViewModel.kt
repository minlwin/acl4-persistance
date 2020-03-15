package com.jdc.restaurant.ui.model

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import com.jdc.restaurant.R
import com.jdc.restaurant.api.service.LoginService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.RuntimeException

class LoginViewModel: ViewModel() {

    private val service = LoginService()

    val message = MutableLiveData("")
    val username = MutableLiveData("")
    val password = MutableLiveData("")

    fun login(v:View) {
        try {
            if(username.value == null || username.value!!.isEmpty()) {
                throw RuntimeException("Please enter Login Id.")
            }

            if(password.value == null || password.value!!.isEmpty()) {
                throw RuntimeException("Please enter Password.")
            }

            viewModelScope.launch {
                val result = withContext(Dispatchers.IO) {
                    service.login(username.value!!, password.value!!)
                }?.also {
                    v.findNavController().navigate(R.id.tables)
                }
            }
        } catch (t:Throwable) {
            t.printStackTrace()
            message.value = t.message
        }
    }
}