package com.application.app.modules.menu.data.viewmodel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.application.app.R
import com.application.app.databinding.RowMenuBinding
import com.application.app.modules.menu.`data`.model.MenuRowModel
import kotlin.Int
import kotlin.collections.List

class MenuAdapter(
  var list: List<MenuRowModel>
) : RecyclerView.Adapter<MenuAdapter.RowMenuVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowMenuVH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_menu,parent,false)
    return RowMenuVH(view)
  }

  override fun onBindViewHolder(holder: RowMenuVH, position: Int) {
    val menuRowModel = MenuRowModel()
    // TODO uncomment following line after integration with data source
    // val menuRowModel = list[position]
    holder.binding.menuRowModel = menuRowModel
  }

  override fun getItemCount(): Int = 2
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<MenuRowModel>) {
    list = newData
    notifyDataSetChanged()
  }

  fun setOnItemClickListener(clickListener: OnItemClickListener) {
    this.clickListener = clickListener
  }

  interface OnItemClickListener {
    fun onItemClick(
      view: View,
      position: Int,
      item: MenuRowModel
    ) {
    }
  }

  inner class RowMenuVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowMenuBinding = RowMenuBinding.bind(itemView)
    init {
      binding.linearRowcomputer.setOnClickListener {
        // TODO replace with value from datasource
        clickListener?.onItemClick(it, adapterPosition, MenuRowModel())
      }
    }
  }
}
