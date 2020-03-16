package com.jdc.product.app.ui.model

import androidx.lifecycle.*
import com.jdc.product.app.api.dto.Product
import com.jdc.product.app.api.service.ProductService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProductsModel: ViewModel() {

    private val service = ProductService()

    val category = MutableLiveData(0)
    val list = category.switchMap { if (it == 0) findAll() else findByCategory(it) }

    private fun findAll():LiveData<List<Product>> {
        val result = MutableLiveData<List<Product>>()

        viewModelScope.launch {
            result.value = withContext(Dispatchers.IO) {
                service.findAll()
            }
        }
        return result
    }

    private fun findByCategory(id:Int):LiveData<List<Product>> {
        val result = MutableLiveData<List<Product>>()

        viewModelScope.launch {
            result.value = withContext(Dispatchers.IO) {
                service.search(id)
            }
        }

        return result
    }
}