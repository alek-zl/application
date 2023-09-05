package com.application.app.network.nb.service

import com.application.app.network.nb.model.NbApiModel
import com.application.app.network.nb.model.NbResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface NbService {

    @POST("api/auth/register")
    suspend fun registerUser(@Body requestBody: NbApiModel): Response<NbResponse>
}