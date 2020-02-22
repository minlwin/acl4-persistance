package com.jdc.restaurant.ui.model

import android.app.Application
import android.view.View
import androidx.lifecycle.*
import androidx.navigation.findNavController
import com.jdc.restaurant.R
import com.jdc.restaurant.db.entity.Category
import com.jdc.restaurant.service.CategoryService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CategoryEditModel(application: Application) : AndroidViewModel(application) {

    private val service = CategoryService(application)

    val id = MutableLiveData(0L)

    val category = id.switchMap { if(it == 0L) MutableLiveData(Category()) else service.findById(it) }

    val title = id.map { if(it == 0L) "Add Category" else "Edit Category" }


    fun save(view:View) {

        category.value?.also { c ->
            viewModelScope.launch {

                withContext(Dispatchers.IO) {
                    service.save(c)
                }
                view.findNavController().navigate(R.id.action_save_category)
            }
        }

    }
}