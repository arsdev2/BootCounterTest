package com.example.bootcounter.domain.boot.di

import com.example.bootcounter.domain.boot.interactor.GetBootInfoDataForNotification
import com.example.bootcounter.domain.boot.interactor.GetBootInfoForView
import com.example.bootcounter.domain.boot.interactor.SaveBootEvent
import com.example.bootcounter.domain.boot.mapper.BootEventToBootInfoNotificationStringMapper
import org.koin.dsl.module

val bootDomainModule = module {

    factory {
        SaveBootEvent(get())
    }

    factory {
        GetBootInfoForView(get())
    }

    factory {
        GetBootInfoDataForNotification(get(), get())
    }

    factory {
        BootEventToBootInfoNotificationStringMapper()
    }


}