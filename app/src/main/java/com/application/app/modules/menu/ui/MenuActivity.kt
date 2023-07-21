package com.application.app.modules.menu.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.application.app.R
import com.application.app.appcomponents.base.BaseActivity
import com.application.app.databinding.ActivityMenuBinding
import com.application.app.modules.menu.`data`.model.MenuRowModel
import com.application.app.modules.menu.data.viewmodel.MenuAdapter
import com.application.app.modules.menu.`data`.viewmodel.MenuVM

import com.application.app.modules.settings.ui.SettingsActivity
import kotlin.Int
import kotlin.String
import kotlin.Unit

class MenuActivity : BaseActivity<ActivityMenuBinding>(R.layout.activity_menu) {
  private val viewModel: MenuVM by viewModels<MenuVM>()

  private val REQUEST_CODE_P0KUPKA_ACTIVITY: Int = 150


  private val REQUEST_CODE_SETTINGS_ACTIVITY: Int = 781


  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val menuAdapter = MenuAdapter(viewModel.menuList.value?:mutableListOf())
    binding.recyclerMenu.adapter = menuAdapter
    menuAdapter.setOnItemClickListener(
    object : MenuAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : MenuRowModel) {
        onClickRecyclerMenu(view, position, item)
      }
    }
    )
    viewModel.menuList.observe(this) {
      menuAdapter.updateData(it)
    }
    binding.menuVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  fun onClickRecyclerMenu(
    view: View,
    position: Int,
    item: MenuRowModel
  ): Unit {
    when(view.id) {
      R.id.linearRowcomputer -> {
        onClickRecyclerMenuLinearRowcomputer(view, position, item)
      }
    }
  }

  fun onClickRecyclerMenuLinearRowcomputer(
    view: View,
    position: Int,
    item: MenuRowModel
  ): Unit {
    /** TODO As per your logic, Add constant type for item click.*/

  }

  companion object {
    const val TAG: String = "MENU_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, MenuActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
