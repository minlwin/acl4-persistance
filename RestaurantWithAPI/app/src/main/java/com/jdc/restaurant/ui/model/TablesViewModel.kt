package com.jdc.restaurant.ui.model

import androidx.lifecycle.*
import com.jdc.restaurant.api.dto.Table
import com.jdc.restaurant.api.service.TableService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TablesViewModel:ViewModel() {

    private val data:MutableLiveData<List<Table>> = MutableLiveData()

    val tables:LiveData<List<Table>> = data.map { it }

    init {
        viewModelScope.launch {
            data.value = withContext(Dispatchers.IO) {
                TableService().getAll()
            }
        }
    }

}