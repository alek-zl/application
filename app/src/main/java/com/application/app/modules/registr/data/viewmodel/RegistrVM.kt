package com.application.app.modules.registr.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.application.app.appcomponents.utility.Constants
import com.application.app.modules.registr.`data`.model.RegistrModel
import com.application.app.network.login.model.RequestUserLogin
import com.application.app.network.login.model.UserLoginModel
import com.application.app.network.login.services.UserLoginService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.KoinComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RegistrVM : ViewModel(), KoinComponent {
    val registrModel: MutableLiveData<RegistrModel> = MutableLiveData(RegistrModel())
    var navArguments: Bundle? = null

    fun checkPhoneNumber(phone: String) : Boolean {
        val regexPattern = Regex("^\\+79\\d{9}$")
        return regexPattern.matches(phone)
    }

    suspend fun getAnswerFromApi(phoneNumber: String) : UserLoginModel = withContext(Dispatchers.Main) {
        val api = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserLoginService::class.java)
        val answer = api.loginUser(RequestUserLogin(phoneNumber = phoneNumber))
        if(answer.body() != null) {
            return@withContext UserLoginModel(
                codeAnswer = answer.code(),
                isUserInBD = answer.body()!!.isUserInBD,
                verificationCode = answer.body()!!.verificationCode,
                accessToken = answer.body()!!.accessToken)
        }
        return@withContext UserLoginModel(codeAnswer = answer.code(), isUserInBD = false, verificationCode = -1, accessToken = null)
    }

}
