package com.application.app.modules.startscreen.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.application.app.modules.startscreen.`data`.model.StartScreenModel
import org.koin.core.KoinComponent

class StartScreenVM : ViewModel(), KoinComponent {
  val startScreenModel: MutableLiveData<StartScreenModel> = MutableLiveData(StartScreenModel())

  var navArguments: Bundle? = null
}
