package com.didemeren.coffeeshop.ui.shop

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.didemeren.coffeeshop.R
import com.didemeren.coffeeshop.databinding.ListItemShopBinding
import com.didemeren.coffeeshop.model.OrderList

class ShopOrderAdapter internal constructor(private val mListener: RecyclerViewClickListener): RecyclerView.Adapter<ShopOrderAdapter.ViewHolder>(){

    private lateinit var items: MutableList<OrderList.Order>

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, mListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(private val binding: ListItemShopBinding) : RecyclerView.ViewHolder(binding.root){

        private lateinit var mListener: RecyclerViewClickListener
        fun bind(item: OrderList.Order, mListener: RecyclerViewClickListener) {
            this.mListener = mListener
            binding.statusText.setOnClickListener{mListener.onClick(adapterPosition)}
            binding.order = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding: ListItemShopBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item_shop, parent,false)
                return ViewHolder(binding)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    private fun getItem(position: Int ): OrderList.Order {
        return items[position]
    }

    fun submitList(items: MutableList<OrderList.Order>) {
        this.items = items
        notifyDataSetChanged()
    }

}