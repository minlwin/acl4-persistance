package com.jdc.product.app.ui.model.validator

import com.jdc.product.app.api.ClientException
import com.jdc.product.app.api.dto.Product

object ProductValidator {

    fun validate(p:Product?) {
        if(null != p) {

            if(p.category == null) {
                throw ClientException("Please select Category!")
            }

            if(p.name.isEmpty()) {
                throw ClientException("Please enter Product Name!")
            }

            if(p.price == 0) {
                throw ClientException("Please enter Price of Product!")
            }
        }
    }
}