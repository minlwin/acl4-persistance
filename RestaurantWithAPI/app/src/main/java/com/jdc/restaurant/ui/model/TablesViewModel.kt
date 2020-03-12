package com.jdc.restaurant.ui.model

import androidx.lifecycle.ViewModel
import com.jdc.restaurant.api.service.TableService

class TablesViewModel:ViewModel() {
    val tables = TableService().getAll()
}