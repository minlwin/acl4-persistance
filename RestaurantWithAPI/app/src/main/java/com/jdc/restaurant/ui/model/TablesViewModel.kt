package com.jdc.restaurant.ui.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.jdc.restaurant.api.dto.Table
import com.jdc.restaurant.api.service.TableService

class TablesViewModel:ViewModel() {
    val tables:LiveData<List<Table>> by lazy {
        TableService().getAll()
    }
}