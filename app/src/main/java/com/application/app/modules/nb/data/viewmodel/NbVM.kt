package com.application.app.modules.nb.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.application.app.appcomponents.utility.Constants.Companion.BASE_URL
import com.application.app.modules.nb.`data`.model.NbModel
import com.application.app.modules.nb.`data`.model.SpinnerArrowdownModel
import com.application.app.network.nb.model.NbApiModel
import com.application.app.network.nb.model.NbResponse
import com.application.app.network.nb.service.NbService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.collections.MutableList
import org.koin.core.KoinComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NbVM : ViewModel(), KoinComponent {
    val nbModel: MutableLiveData<NbModel> = MutableLiveData(NbModel())

    var navArguments: Bundle? = null

    val spinnerArrowdownList: MutableLiveData<MutableList<SpinnerArrowdownModel>> = MutableLiveData()

    suspend fun regUser(userInfo: NbApiModel): NbResponse = withContext(Dispatchers.Default) {
        try {
            val api = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(NbService::class.java)
            val answer = api.registerUser(userInfo)
            if (answer.body() != null) {
                return@withContext NbResponse(
                    answer = answer.code(),
                    accessToken = answer.body()!!.accessToken
                )
            }
            return@withContext NbResponse(answer = answer.code(), accessToken = "")
        }catch(e: Exception) {
            return@withContext NbResponse(answer = 404, accessToken = "")
        }
    }

     fun getDateOfBirth(day: Int, month: Int, year: Int): String {
        var answer: String = ""
        answer += if(day < 10)
            "0$day."
        else
            day.toString()

        answer += if(month < 10)
            "0$month."
        else
            month.toString()

        answer += year.toString()
        return answer
    }
}
