package com.application.app.modules.code.`data`.model

import com.application.app.R
import com.application.app.appcomponents.di.MyApp
import kotlin.String

data class CodeModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtWelcomeaboard: String? = MyApp.getInstance().resources.getString(R.string.lbl3)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLetsgetyour: String? = MyApp.getInstance().resources.getString(R.string.msg4)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var etOtpviewValue: String? = null
)
