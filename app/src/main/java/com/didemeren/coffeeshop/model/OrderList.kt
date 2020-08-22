package com.didemeren.coffeeshop.model

class OrderList private constructor() {
    companion object {
        lateinit var INSTANCE: OrderList
        init {
            OrderList()
        }
    }
    var orders: ArrayList<Order>

    init {
        INSTANCE = this
        orders =  ArrayList()
    }


    data class Order(var status: Int = 0, var drink: String = "")
}