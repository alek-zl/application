package com.application.app.network.login.model

data class RequestUserLogin(
    val phoneNumber: String,
)

data class UserLoginModel(
    val codeAnswer: Int,
    val isUserInBD: Boolean,
    val verificationCode: Int,
    val accessToken: String ?= null,
)
