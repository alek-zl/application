package com.application.app.network.nb.model


data class NbApiModel(
    val phone: String,
    val name: String,
    val gender: String,
    val dateOfBirth: String,
)

data class NbResponse(
    val answer: Int,
    val accessToken: String,
)

