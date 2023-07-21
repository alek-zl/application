package com.application.app.modules.registr.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.application.app.modules.registr.`data`.model.RegistrModel
import org.koin.core.KoinComponent

class RegistrVM : ViewModel(), KoinComponent {
  val registrModel: MutableLiveData<RegistrModel> = MutableLiveData(RegistrModel())

  var navArguments: Bundle? = null
}
