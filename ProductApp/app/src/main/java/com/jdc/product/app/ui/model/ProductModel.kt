package com.jdc.product.app.ui.model

import android.view.View
import androidx.lifecycle.*
import androidx.navigation.findNavController
import com.jdc.product.app.R
import com.jdc.product.app.api.ClientException
import com.jdc.product.app.api.dto.Product
import com.jdc.product.app.api.service.ProductService
import com.jdc.product.app.ui.model.validator.ProductValidator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProductModel : ViewModel() {

    private val service = ProductService()
    val id:MutableLiveData<Int> = MutableLiveData(0)
    val error = MutableLiveData("")

    val product = id.switchMap { if(it == 0) MutableLiveData(Product()) else findById(it) }

    fun save(v:View) {

        try {

            ProductValidator.validate(product.value)

            viewModelScope.launch {
                withContext(Dispatchers.IO) {
                    product.value?.also {
                        service.save(it)
                    }
                }

                v.findNavController().navigate(R.id.action_global_products)
            }
        } catch (e:ClientException) {
            error.value = e.message
        }

    }

    private fun findById(id:Int):LiveData<Product> {
        val result = MutableLiveData<Product>()
        viewModelScope.launch {
            result.value = withContext(Dispatchers.IO) {
                service.findById(id)
            }
        }
        return result
    }
}