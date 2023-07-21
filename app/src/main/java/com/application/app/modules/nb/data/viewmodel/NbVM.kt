package com.application.app.modules.nb.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.application.app.modules.nb.`data`.model.NbModel
import com.application.app.modules.nb.`data`.model.SpinnerArrowdownModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class NbVM : ViewModel(), KoinComponent {
  val nbModel: MutableLiveData<NbModel> = MutableLiveData(NbModel())

  var navArguments: Bundle? = null

  val spinnerArrowdownList: MutableLiveData<MutableList<SpinnerArrowdownModel>> = MutableLiveData()
}
