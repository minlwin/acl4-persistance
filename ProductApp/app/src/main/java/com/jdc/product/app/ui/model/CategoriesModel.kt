package com.jdc.product.app.ui.model

import androidx.lifecycle.*
import com.jdc.product.app.api.dto.Category
import com.jdc.product.app.api.service.CategoryService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CategoriesModel:ViewModel() {

    private val service = CategoryService()

    val type = MutableLiveData<String>()
    val list = type.switchMap { if(it.isEmpty()) findAll() else findByType(it) }

    private fun findAll():LiveData<List<Category>> {
        val result = MutableLiveData<List<Category>>()

        viewModelScope.launch {
            result.value = withContext(Dispatchers.IO) {
                service.findAll()
            }
        }
        return result
    }

    private fun findByType(type:String):LiveData<List<Category>> {
        val result = MutableLiveData<List<Category>>()

        viewModelScope.launch {
            result.value = withContext(Dispatchers.IO) {
                service.findByType(type)
            }
        }
        return result
    }
}