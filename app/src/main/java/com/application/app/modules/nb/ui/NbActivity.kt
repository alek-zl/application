package com.application.app.modules.nb.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.application.app.R
import com.application.app.appcomponents.base.BaseActivity
import com.application.app.databinding.ActivityNbBinding
import com.application.app.modules.menu.ui.MenuActivity
import com.application.app.modules.nb.`data`.model.SpinnerArrowdownModel
import com.application.app.modules.nb.`data`.viewmodel.NbVM
import com.application.app.network.nb.model.NbApiModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupButtons()
    }

    override fun setUpClicks(): Unit {
        binding.imageSearch.setOnClickListener {
            finish()
        }
    }

    private fun setupButtons() {
        binding.btn.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                val gender: String =
                    if(binding.genderSpinner1.id == 0) //TODO:
                        "Male"
                    else "Female"
                val dateOfBirth = viewModel.getDateOfBirth(
                    day = binding.datePicker.dayOfMonth,
                    month = binding.datePicker.dayOfMonth,
                    year = binding.datePicker.year
                )

                val userInfo = NbApiModel(
                    phone = "Some number", //TODO: Improve, get information from prev page
                    dateOfBirth = dateOfBirth,
                    gender = gender,
                    name = binding.etField.text.toString()
                )
                val responseAnswer = viewModel.regUser(userInfo)
                if(responseAnswer.answer == 200) {
                    val intent = Intent(applicationContext, MenuActivity::class.java)
                    startActivity(intent)
                }
                else {
                    binding.etField.setText("")
                    binding.errorMessage.isVisible = true
                }
            }
        }
    }

    companion object {
        const val TAG: String = "NB_ACTIVITY"

    }
}
