package com.didemeren.coffeeshop.ui.customer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.didemeren.coffeeshop.R
import com.didemeren.coffeeshop.databinding.FragmentCustomerBinding

class CustomerFragment : Fragment() {

    private lateinit var binding: FragmentCustomerBinding
    private lateinit var viewModel: CustomerViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_customer,container,false)
        viewModel = ViewModelProvider(this).get(CustomerViewModel::class.java)
        binding.customerViewModel = viewModel

        val adapter = CustomerOrderAdapter()
        binding.custOrderList.adapter = adapter

        viewModel.orderList.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })

        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }
}