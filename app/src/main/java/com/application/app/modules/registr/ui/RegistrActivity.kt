package com.application.app.modules.registr.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.application.app.R
import com.application.app.appcomponents.base.BaseActivity
import com.application.app.databinding.ActivityRegistrBinding
import com.application.app.modules.registr.`data`.viewmodel.RegistrVM
import kotlin.String
import kotlin.Unit

class RegistrActivity : BaseActivity<ActivityRegistrBinding>(R.layout.activity_registr) {
  private val viewModel: RegistrVM by viewModels<RegistrVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.registrVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageSearch.setOnClickListener {
      finish()
    }
  }

  companion object {
    const val TAG: String = "REGISTR_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, RegistrActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
