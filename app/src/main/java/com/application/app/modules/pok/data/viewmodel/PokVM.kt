package com.application.app.modules.pok.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.application.app.modules.pok.`data`.model.ListoneRowModel
import com.application.app.modules.pok.`data`.model.PokModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class PokVM : ViewModel(), KoinComponent {
  val pokModel: MutableLiveData<PokModel> = MutableLiveData(PokModel())

  var navArguments: Bundle? = null

  val listoneList: MutableLiveData<MutableList<ListoneRowModel>> = MutableLiveData(mutableListOf())
}
