package com.jdc.restaurant.ui.model

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.navigation.findNavController
import com.jdc.restaurant.R

class ProductEditModel(application: Application) : AndroidViewModel(application) {


    fun save(v:View) {

        v.findNavController().navigate(R.id.action_save_product)
    }

}