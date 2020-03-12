package com.jdc.restaurant.api.dto

data class LoginResult(
    val user:Employee? = null,
    val token:String? = null
)