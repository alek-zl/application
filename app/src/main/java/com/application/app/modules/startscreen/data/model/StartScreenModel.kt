package com.application.app.modules.startscreen.`data`.model

import com.application.app.R
import com.application.app.appcomponents.di.MyApp
import kotlin.String

data class StartScreenModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtExceptionalUrb: String? = MyApp.getInstance().resources.getString(R.string.lbl_forceful2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtShopforexcept: String? = MyApp.getInstance().resources.getString(R.string.msg)

)
