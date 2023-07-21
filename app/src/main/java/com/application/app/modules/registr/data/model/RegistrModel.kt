package com.application.app.modules.registr.`data`.model

import com.application.app.R
import com.application.app.appcomponents.di.MyApp
import kotlin.String

data class RegistrModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtWelcomeaboard: String? = MyApp.getInstance().resources.getString(R.string.msg2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLetsgetyour: String? = MyApp.getInstance().resources.getString(R.string.msg3)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var etFieldValue: String? = null
)
