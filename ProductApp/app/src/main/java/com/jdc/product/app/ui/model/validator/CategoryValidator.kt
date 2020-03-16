package com.jdc.product.app.ui.model.validator

import com.jdc.product.app.api.ClientException
import com.jdc.product.app.api.dto.Category

object CategoryValidator {

    @JvmStatic
    fun validate(c:Category?) {

        if(null != c) {

            if(c.type.isEmpty()) {
                throw ClientException("Please select Type of Category!")
            }

            if(c.name.isEmpty()) {
                throw ClientException("Please enter Name of Category")
            }
        }
    }
}