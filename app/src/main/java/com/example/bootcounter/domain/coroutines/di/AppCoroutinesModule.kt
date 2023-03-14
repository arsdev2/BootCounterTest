package com.example.bootcounter.domain.coroutines.di

import com.example.bootcounter.domain.coroutines.factory.CoroutineScopeFactory
import com.example.bootcounter.presentation.boot.adapter.BootInfoListAdapter
import org.koin.dsl.module

val appCoroutinesModule = module {

    factory {
        CoroutineScopeFactory()
    }

    factory { BootInfoListAdapter() }

}