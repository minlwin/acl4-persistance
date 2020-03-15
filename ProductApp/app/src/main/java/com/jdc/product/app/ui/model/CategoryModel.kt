package com.jdc.product.app.ui.model

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import com.jdc.product.app.R
import com.jdc.product.app.api.dto.Category
import com.jdc.product.app.api.service.CategoryService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CategoryModel : ViewModel() {

    private val service = CategoryService()

    val category:LiveData<Category> = MutableLiveData(Category())

    fun save(v:View) {
        viewModelScope.launch {
            category.value?.apply {
                withContext(Dispatchers.IO) {
                    service.create(this@apply)
                }?.apply {
                    v.findNavController().navigate(R.id.action_global_categories)
                }
            }
        }
    }
}