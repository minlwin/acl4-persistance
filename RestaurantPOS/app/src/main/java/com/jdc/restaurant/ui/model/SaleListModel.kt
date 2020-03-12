package com.jdc.restaurant.ui.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.jdc.restaurant.service.SaleService

class SaleListModel(application: Application) : AndroidViewModel(application) {

    val list = SaleService(application).findAll()
}