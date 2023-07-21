package com.application.app.modules.pok.ui

import android.view.View
import androidx.activity.viewModels
import com.application.app.R
import com.application.app.appcomponents.base.BaseActivity
import com.application.app.databinding.ActivityPokBinding
import com.application.app.modules.pok.`data`.model.ListoneRowModel
import com.application.app.modules.pok.`data`.viewmodel.PokVM
import kotlin.Int
import kotlin.String
import kotlin.Unit

class PokActivity : BaseActivity<ActivityPokBinding>(R.layout.activity_pok) {
  private val viewModel: PokVM by viewModels<PokVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val listoneAdapter = ListoneAdapter(viewModel.listoneList.value?:mutableListOf())
    binding.recyclerListone.adapter = listoneAdapter
    listoneAdapter.setOnItemClickListener(
    object : ListoneAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : ListoneRowModel) {
        onClickRecyclerListone(view, position, item)
      }
    }
    )
    viewModel.listoneList.observe(this) {
      listoneAdapter.updateData(it)
    }
    binding.pokVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  fun onClickRecyclerListone(
    view: View,
    position: Int,
    item: ListoneRowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "POK_ACTIVITY"

  }
}
