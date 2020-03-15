package com.jdc.product.app.ui.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jdc.product.app.api.service.CategoryService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TypesViewModel:ViewModel() {

    private val service = CategoryService()

    val types = MutableLiveData<List<String>>()

    init {
        viewModelScope.launch {
            types.value = withContext(Dispatchers.IO) {
                service.getTypes()
            }
        }
    }
}