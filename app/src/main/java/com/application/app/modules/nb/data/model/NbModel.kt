package com.application.app.modules.nb.`data`.model

import com.application.app.R
import com.application.app.appcomponents.di.MyApp
import kotlin.String

data class NbModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtWelcomeaboard: String? = MyApp.getInstance().resources.getString(R.string.lbl4)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLetsgetyour: String? = MyApp.getInstance().resources.getString(R.string.msg5)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var etFieldOneValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etFieldValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etFieldTwoValue: String? = null
)
