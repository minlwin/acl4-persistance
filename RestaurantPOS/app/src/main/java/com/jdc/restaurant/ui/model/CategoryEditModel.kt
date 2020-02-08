package com.jdc.restaurant.ui.model

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.navigation.findNavController
import com.jdc.restaurant.R

class CategoryEditModel(application: Application) : AndroidViewModel(application) {

    fun save(view:View) {

        view.findNavController().navigate(R.id.action_save_category)
    }
}