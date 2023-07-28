package com.application.app.modules.registr.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.application.app.modules.registr.`data`.model.RegistrModel
import com.application.app.network.model.UserLoginModel
import org.koin.core.KoinComponent

class RegistrVM : ViewModel(), KoinComponent {
    val registrModel: MutableLiveData<RegistrModel> = MutableLiveData(RegistrModel())
    var navArguments: Bundle? = null

    fun checkPhoneNumber(phone: String) : Boolean {
        val regexPattern = Regex("^\\+79\\d{9}$")
        return regexPattern.matches(phone)
    }

    fun getAnswerFromApi() : UserLoginModel {
        return UserLoginModel(isUserInBD = true, verificationCode = 1234, accessToken = "214fasf123")
    }

}
