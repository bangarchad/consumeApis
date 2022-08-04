package com.example.consumeapi.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.consumeapi.R
import com.example.consumeapi.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        binding = FragmentHomeBinding.inflate(inflater)
        binding.setLifecycleOwner(this)
        binding.viewModel= viewModel

        val viewAdapter = ItemAdapter()
        binding.rv.adapter = viewAdapter

        viewModel.items.observe(this, Observer { list ->
            viewAdapter.submitList(list)
        })

        return  binding.root
    }
}