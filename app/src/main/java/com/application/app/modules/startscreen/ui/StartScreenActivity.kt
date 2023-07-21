package com.application.app.modules.startscreen.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.application.app.R
import com.application.app.appcomponents.base.BaseActivity
import com.application.app.databinding.ActivityStartScreenBinding
import com.application.app.modules.registr.ui.RegistrActivity
import com.application.app.modules.startscreen.`data`.viewmodel.StartScreenVM
import kotlin.String
import kotlin.Unit

class StartScreenActivity : BaseActivity<ActivityStartScreenBinding>(R.layout.activity_start_screen)
    {
  private val viewModel: StartScreenVM by viewModels<StartScreenVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.startScreenVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btn.setOnClickListener {
      val destIntent = RegistrActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "START_SCREEN_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, StartScreenActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
