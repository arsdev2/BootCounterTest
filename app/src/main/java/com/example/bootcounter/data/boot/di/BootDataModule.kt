package com.example.bootcounter.data.boot.di

import androidx.room.Room
import com.example.bootcounter.data.boot.dao.BootEventDao
import com.example.bootcounter.data.boot.db.BootDataDB
import com.example.bootcounter.data.boot.repository.BootEventLocalRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val bootDataModule = module {

    factory {
        BootEventLocalRepository(get())
    }

    single {
        get<BootDataDB>().bootEventDao()
    }

    single {
        Room.databaseBuilder(
            androidContext(),
            BootDataDB::class.java, "boot-event-db"
        ).build()
    }


}