package com.application.app.network.login.services

import com.application.app.network.login.model.RequestUserLogin
import com.application.app.network.login.model.UserLoginModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserLoginService {

    @POST("api/auth/login")
    suspend fun loginUser(@Body requestBody: RequestUserLogin): Response<UserLoginModel>
}