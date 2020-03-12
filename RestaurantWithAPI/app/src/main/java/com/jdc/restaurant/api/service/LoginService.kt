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

    fun login(userName:String, password:String):LiveData<Boolean> {

        val result = MutableLiveData(false)
        val call = client.login(Login(userName, password))

        call.enqueue(object : Callback<LoginResult> {

            override fun onFailure(call: Call<LoginResult>, t: Throwable) {
                result.value = false
                t.printStackTrace()
                throw t
            }

            override fun onResponse(call: Call<LoginResult>, response: Response<LoginResult>) {
                response.body()?.also {
                    ClientContext.loginUser = it.user
                    ClientContext.token = it.token
                }
            }

        })

        return result
    }
}