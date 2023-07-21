package com.application.app.modules.nb.ui

import androidx.activity.viewModels
import com.application.app.R
import com.application.app.appcomponents.base.BaseActivity
import com.application.app.databinding.ActivityNbBinding
import com.application.app.modules.nb.`data`.model.SpinnerArrowdownModel
import com.application.app.modules.nb.`data`.viewmodel.NbVM
import kotlin.String
import kotlin.Unit

class NbActivity : BaseActivity<ActivityNbBinding>(R.layout.activity_nb) {
  private val viewModel: NbVM by viewModels<NbVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    viewModel.spinnerArrowdownList.value = mutableListOf(
    SpinnerArrowdownModel("Item1"),
    SpinnerArrowdownModel("Item2"),
    SpinnerArrowdownModel("Item3"),
    SpinnerArrowdownModel("Item4"),
    SpinnerArrowdownModel("Item5")
    )
    val spinnerArrowdownAdapter =
    SpinnerArrowdownAdapter(this,R.layout.spinner_item,viewModel.spinnerArrowdownList.value?:
    mutableListOf())
    //binding.spinnerArrowdown.adapter = spinnerArrowdownAdapter
    binding.nbVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageSearch.setOnClickListener {
      finish()
    }
  }

  companion object {
    const val TAG: String = "NB_ACTIVITY"

  }
}
