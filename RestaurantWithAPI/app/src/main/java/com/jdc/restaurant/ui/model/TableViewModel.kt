package com.jdc.restaurant.ui.model

import androidx.lifecycle.*
import com.jdc.restaurant.api.dto.Table
import com.jdc.restaurant.api.dto.Voucher
import com.jdc.restaurant.api.service.TableService
import com.jdc.restaurant.api.service.VoucherService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TableViewModel:ViewModel() {

    private val tableService = TableService()
    private val voucherService = VoucherService()

    val id:MutableLiveData<Int> = MutableLiveData()

    val table = id.switchMap { findTable(it) }
    val vouchers = id.switchMap { findVouchers(it) }

    private fun findVouchers(id:Int):LiveData<List<Voucher>> {
        val result = MutableLiveData<List<Voucher>>()
        viewModelScope.launch {
            withContext(Dispatchers.IO) { voucherService.findByTable(id) }.also {
                result.value = it ?: mutableListOf<Voucher>()
            }
        }
        return result
    }

    private fun findTable(id:Int):LiveData<Table> {
        val result = MutableLiveData<Table>()
        viewModelScope.launch {
            withContext(Dispatchers.IO) { tableService.findById(id) }.also {
                it?.apply { result.value = this }
            }
        }
        return result
    }
}