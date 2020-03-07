package com.jdc.restaurant.ui.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.jdc.restaurant.service.ProductService

class ProductListModel(application: Application) : AndroidViewModel(application) {

    private val service = ProductService(application)

    val categoryId = MutableLiveData<Long>(0L)

    val list = categoryId.switchMap { if(it == 0L) service.findAll() else service.findByCategory(it)}
}