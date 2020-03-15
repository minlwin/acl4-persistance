package com.jdc.restaurant.api.service

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jdc.restaurant.api.ClientContext
import com.jdc.restaurant.api.ClientFactory
import com.jdc.restaurant.api.client.LoginClient
import com.jdc.restaurant.api.dto.Login
import com.jdc.restaurant.api.dto.LoginResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginService {

    private val client = ClientFactory.generate(LoginClient::class.java)

    suspend fun login(userName:String, password:String):Boolean {

        try {
            client.login(Login(userName, password)).execute().body()?.also {
                ClientContext.loginUser = it.user
                ClientContext.token = it.token
            }

            return true
        } catch (t:Throwable) {
            t.printStackTrace()
        }
        return false
    }
}