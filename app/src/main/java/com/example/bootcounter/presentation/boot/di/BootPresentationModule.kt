package com.example.bootcounter.presentation.boot.di

import com.example.bootcounter.presentation.boot.viewmodel.BootInfoActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val bootPresentationModule = module {

    viewModel {
        BootInfoActivityViewModel(get())
    }

}