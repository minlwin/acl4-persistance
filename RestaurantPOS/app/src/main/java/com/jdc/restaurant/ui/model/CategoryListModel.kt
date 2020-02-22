package com.jdc.restaurant.ui.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.jdc.restaurant.service.CategoryService

class CategoryListModel(application: Application) : AndroidViewModel(application) {


    private val service = CategoryService(application)

    val list = service.findAll()
}