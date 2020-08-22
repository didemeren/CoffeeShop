package com.didemeren.coffeeshop.ui.shop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.didemeren.coffeeshop.R
import com.didemeren.coffeeshop.databinding.FragmentShopBinding


class ShopFragment : Fragment() {

    private lateinit var binding: FragmentShopBinding
    private lateinit var viewModel: ShopViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_shop,container,false)
        viewModel = ViewModelProvider(this).get(ShopViewModel::class.java)
        binding.shopViewModel = viewModel

        val adapter = ShopOrderAdapter(viewModel.listener)
        binding.shopOrderList.adapter = adapter
        viewModel.orderList.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })

        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }
}