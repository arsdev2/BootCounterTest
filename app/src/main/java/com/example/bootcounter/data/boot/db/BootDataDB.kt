package com.example.bootcounter.data.boot.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.bootcounter.data.boot.dao.BootEventDao
import com.example.bootcounter.data.boot.model.BootEvent

@Database(entities = [BootEvent::class], version = 1)
abstract class BootDataDB : RoomDatabase(){

    abstract fun bootEventDao(): BootEventDao

}