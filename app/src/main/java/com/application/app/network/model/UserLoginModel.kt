package com.application.app.network.model

data class UserLoginModel(
    val isUserInBD: Boolean,
    val verificationCode: Int,
    val accessToken: String ?= null,
)
