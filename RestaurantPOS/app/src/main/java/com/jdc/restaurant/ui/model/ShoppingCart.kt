package com.jdc.restaurant.ui.model

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.jdc.restaurant.db.entity.Orders
import com.jdc.restaurant.db.entity.Product

class ShoppingCart(application: Application) : AndroidViewModel(application) {
    private val context:Context = application
    private val orders:MutableList<Orders> = mutableListOf()

    val count:MutableLiveData<Int> = MutableLiveData()

    fun addToCart(product:Product) {
        val currentOrder = orders.firstOrNull { it.id == product.id } ?: Orders(
            productId = product.id,
            productName = product.name,
            unitPrice = product.price
        ).also {
            orders.add(it)
        }

        currentOrder.quantity = currentOrder.quantity + 1

        count.value = orders.map { it.quantity }.sum()

        Toast.makeText(context, "Count is ${count.value}", Toast.LENGTH_SHORT).show()
    }
}