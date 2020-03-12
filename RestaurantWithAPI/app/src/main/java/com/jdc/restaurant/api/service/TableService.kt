package com.jdc.restaurant.api.service

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jdc.restaurant.api.ClientFactory
import com.jdc.restaurant.api.client.TableClient
import com.jdc.restaurant.api.dto.Table
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TableService {

    private val client = ClientFactory.generate(TableClient::class.java)

    fun getAll():LiveData<List<Table>> {
        val result = MutableLiveData<List<Table>>()

        client.findAll().enqueue(object : Callback<List<Table>> {
            override fun onFailure(call: Call<List<Table>>, t: Throwable) {
                throw t
            }

            override fun onResponse(call: Call<List<Table>>, response: Response<List<Table>>) {
                response.body()?.also {
                    result.value = it
                }
            }
        })

        return result
    }
}