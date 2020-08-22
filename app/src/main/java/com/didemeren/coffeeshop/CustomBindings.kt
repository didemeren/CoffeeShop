package com.didemeren.coffeeshop

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

class CustomBindings{
    companion object {

        @BindingAdapter("setCustomerStatus")
        @JvmStatic
        fun bindCustomerOrderStatus(view: TextView, status: Int) {
            view.text = if(status == 0) "Waiting to be Prepared" else "Ready";
        }

        @BindingAdapter("setShopStatus")
        @JvmStatic
        fun bindShopOrderStatus(view: TextView, status: Int) {
            view.text = if(status == 0) "Click to Prepare" else "Prepared";
        }

    }
}