package com.application.app.modules.menu.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.application.app.modules.menu.`data`.model.MenuModel
import com.application.app.modules.menu.`data`.model.MenuRowModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class MenuVM : ViewModel(), KoinComponent {
  val menuModel: MutableLiveData<MenuModel> = MutableLiveData(MenuModel())

  var navArguments: Bundle? = null

  val menuList: MutableLiveData<MutableList<MenuRowModel>> = MutableLiveData(mutableListOf())
}
