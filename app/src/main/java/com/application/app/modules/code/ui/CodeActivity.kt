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

    binding.buttonCheck.setOnClickListener {
      val code = getCodeFromEditTexts()

      if (code == "verificationCode" && viewModel.codeModel.isUserInBD) {
        fillData()
      } else if (code == "verificationCode" && !viewModel.codeModel.isUserInBD) {
        // Переходим к NbActivity
        startActivity(Intent(this, NbActivity::class.java))
        finish()
      } else {
        clearEditTexts()
      }
    }
  }z

  private fun getCodeFromEditTexts(): String {
    val editTextNumberOne = binding.editTextNumberOne.text.toString()
    val editTextNumberTwo = binding.editTextNumberTwo.text.toString()
    val editTextNumberThree = binding.editTextNumberThree.text.toString()
    val editTextNumberFour = binding.editTextNumberFour.text.toString()

    return "$editTextNumberOne$editTextNumberTwo$editTextNumberThree$editTextNumberFour"
  }

  private fun clearEditTexts() {
    binding.editTextNumberOne.text.clear()
    binding.editTextNumberTwo.text.clear()
    binding.editTextNumberThree.text.clear()
    binding.editTextNumberFour.text.clear()
  }

  private fun fillData() {
    viewModel.loadDataFromServer()
  }

  companion object {
    const val TAG: String = "CODE_ACTIVITY"

  }
}

