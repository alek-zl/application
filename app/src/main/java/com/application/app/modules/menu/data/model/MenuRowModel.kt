package com.application.app.modules.menu.`data`.model

import com.application.app.appcomponents.di.MyApp
import kotlin.String
import com.application.app.R

data class MenuRowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtSeven: String? = MyApp.getInstance().resources.getString(R.string.lbl13)

)
