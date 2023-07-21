package com.application.app.modules.menu.`data`.model

import com.application.app.R
import com.application.app.appcomponents.di.MyApp
import kotlin.String

data class MenuModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtFORCEFUL: String? = MyApp.getInstance().resources.getString(R.string.lbl_forceful)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtNine: String? = MyApp.getInstance().resources.getString(R.string.msg7)

)
