package com.jdc.restaurant.ui.model

import android.app.Application
import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import com.jdc.restaurant.R
import com.jdc.restaurant.db.entity.Orders
import com.jdc.restaurant.db.entity.Product
import com.jdc.restaurant.service.SaleService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class ShoppingCart(application: Application) : AndroidViewModel(application) {

    private val context:Context = application
    private val saleService = SaleService(context)

    val orders:MutableList<Orders> = mutableListOf()

    val count:MutableLiveData<Int> = MutableLiveData(0)
    val total:MutableLiveData<Int> = MutableLiveData(0)

    val saleDate = MutableLiveData(Date())

    fun addToCart(product:Product) {
        val currentOrder = orders.firstOrNull { it.productId == product.id } ?: Orders(
            productId = product.id,
            productName = product.name,
            unitPrice = product.price
        ).also {
            orders.add(it)
        }

        currentOrder.quantity = currentOrder.quantity + 1
        update()
    }

    fun addToCart(productId: Long?) {
        orders.find { it.productId == productId }?.also {
            it.quantity = it.quantity + 1

            if(it.quantity == 0) {
                orders.remove(it)
            }

            update()
        }
    }

    fun removeFromCart(productId: Long?) {
        orders.find { it.productId == productId }?.also {
            it.quantity = it.quantity - 1

            if(it.quantity == 0) {
                orders.remove(it)
            }

            update()
        }
    }

    private fun update() {
        count.value = orders.map { it.quantity }.sum()
        total.value = orders.map { it.quantity * it.unitPrice }.sum()
    }

    fun clear(v:View) {
        initCart()
        v.findNavController().navigate(R.id.action_global_home)
    }

    private fun initCart() {
        orders.clear()
        count.value = 0
        total.value = 0
    }

    fun paid(v:View) {

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                saleService.create(orders)
            }
            initCart()
            v.findNavController().navigate(R.id.sales)
        }

    }
}