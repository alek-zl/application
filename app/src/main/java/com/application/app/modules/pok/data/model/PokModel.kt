package com.application.app.modules.pok.`data`.model

import com.application.app.R
import com.application.app.appcomponents.di.MyApp
import kotlin.String

data class PokModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtTwo: String? = MyApp.getInstance().resources.getString(R.string.lbl8)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtFour: String? = MyApp.getInstance().resources.getString(R.string.lbl10)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtThreeHundredSeventyFive: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_375)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtFive: String? = MyApp.getInstance().resources.getString(R.string.lbl11)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSix: String? = MyApp.getInstance().resources.getString(R.string.lbl12)

)
