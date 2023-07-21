package com.application.app.modules.splashscreen.`data`.model

import com.application.app.R
import com.application.app.appcomponents.di.MyApp
import kotlin.String

data class SplashScreenModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtFORCEFUL: String? = MyApp.getInstance().resources.getString(R.string.lbl_forceful)

)
