package com.jdc.restaurant.ui.model

import android.app.Application
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import com.jdc.restaurant.R
import com.jdc.restaurant.db.dto.ProductWithCategory
import com.jdc.restaurant.service.ProductService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProductEditModel(application: Application) : AndroidViewModel(application) {

    private val service = ProductService(application)
    private val context = application

    val productId = MutableLiveData(0L)

    val dto = productId.switchMap { if(it == 0L) MutableLiveData(ProductWithCategory()) else
        service.findById(it)
    }


    fun save(v:View) {

        dto.value?.also {

            viewModelScope.launch {
                try {
                    it.product.categoryId = it.category?.id ?: 0L

                    val id = withContext(Dispatchers.IO) {
                        service.save(it.product)
                    }

                    v.findNavController().navigate(R.id.action_save_product, bundleOf("id" to id))
                } catch (e:Throwable) {
                    Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
                }
            }

        }

    }

    fun edit(v:View) {
        v.findNavController().navigate(R.id.action_edit_product, bundleOf("id" to productId.value))
    }

}