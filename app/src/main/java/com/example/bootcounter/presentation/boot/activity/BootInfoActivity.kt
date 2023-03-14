package com.example.bootcounter.presentation.boot.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.bootcounter.R
import com.example.bootcounter.databinding.BootInfoActivityBinding
import com.example.bootcounter.presentation.boot.adapter.BootInfoListAdapter
import com.example.bootcounter.presentation.boot.viewmodel.BootInfoActivityViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class BootInfoActivity : AppCompatActivity() {

    private val bootInfoLActivityViewModel: BootInfoActivityViewModel by viewModel()
    private val bootInfoListAdapter: BootInfoListAdapter by inject()
    private lateinit var binding: BootInfoActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBinding()
        setupViews()
        setupObservers()
        bootInfoLActivityViewModel.init()
    }

    private fun setupViews() {
        binding.bootInfoList.adapter = bootInfoListAdapter
    }

    private fun setupObservers() {
        bootInfoLActivityViewModel.bootInfoData.observe(this) {
            bootInfoListAdapter.updateData(it)
        }
    }

    private fun initBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.boot_info_activity)
        binding.lifecycleOwner = this
        binding.viewModel = bootInfoLActivityViewModel
        binding.executePendingBindings()
    }
}