package com.didemeren.coffeeshop.ui.customer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.didemeren.coffeeshop.model.OrderList
import kotlin.math.floor

class CustomerViewModel : ViewModel() {

    private val _title = MutableLiveData<String>().apply {
        value = "Welcome Customer!"
    }
    val title: LiveData<String> = _title

    private val _luckyCoffee = MutableLiveData<String>().apply {
        value = "Americano"
    }
    val luckyCoffee: LiveData<String> = _luckyCoffee


    private val _orderList = MutableLiveData<ArrayList<OrderList.Order>>().apply {
        value = OrderList.INSTANCE.orders
    }
    val orderList: LiveData<ArrayList<OrderList.Order>> = _orderList

    fun onGiveOrder() {
        val i: Int = floor(Math.random() * 4).toInt()
        OrderList.INSTANCE.orders.add(OrderList.Order(0, _luckyCoffee.value!!))
        _orderList.value = OrderList.INSTANCE.orders
        _luckyCoffee.value = _coffeeList[i]

    }



    private var _coffeeList = mutableListOf(
        "Americao",
        "Espresso",
        "Macchiato",
        "Cappucino"
    )


}