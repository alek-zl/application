package com.application.app.modules.code.ui

import androidx.activity.viewModels
import com.application.app.R
import com.application.app.appcomponents.base.BaseActivity
import com.application.app.databinding.ActivityCodeBinding
import com.application.app.modules.code.`data`.viewmodel.CodeVM
import kotlin.String
import kotlin.Unit

class CodeActivity : BaseActivity<ActivityCodeBinding>(R.layout.activity_code) {
  private val viewModel: CodeVM by viewModels<CodeVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.codeVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageSearch.setOnClickListener {
      finish()
    }
  }

  companion object {
    const val TAG: String = "CODE_ACTIVITY"

  }
}
