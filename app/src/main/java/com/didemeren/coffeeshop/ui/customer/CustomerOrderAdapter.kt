package com.didemeren.coffeeshop.ui.customer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.didemeren.coffeeshop.R
import com.didemeren.coffeeshop.databinding.ListItemCustomerBinding
import com.didemeren.coffeeshop.model.OrderList

class CustomerOrderAdapter : RecyclerView.Adapter<CustomerOrderAdapter.ViewHolder>() {

    private lateinit var items: MutableList<OrderList.Order>

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(private val binding: ListItemCustomerBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(item: OrderList.Order) {
            binding.order = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding: ListItemCustomerBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item_customer,parent,false)
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