package com.didemeren.coffeeshop.ui.shop

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.didemeren.coffeeshop.model.OrderList

class ShopViewModel : ViewModel() {

    private val _title = MutableLiveData<String>().apply {
        value = "Welcome Barista!"
    }
    val title: LiveData<String> = _title


    private val _orderList = MutableLiveData<ArrayList<OrderList.Order>>().apply {
        value = OrderList.INSTANCE.orders
    }
    val orderList: LiveData<ArrayList<OrderList.Order>> = _orderList

    fun onReadyOrder(position: Int) {
        OrderList.INSTANCE.orders[position].status = 1
        _orderList.value = OrderList.INSTANCE.orders
    }

    val listener = object : RecyclerViewClickListener {
        override fun onClick(position: Int) {
            onReadyOrder(position)
        }
    }
}