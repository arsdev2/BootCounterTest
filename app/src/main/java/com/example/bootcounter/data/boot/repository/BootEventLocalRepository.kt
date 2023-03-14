package com.example.bootcounter.data.boot.repository

import com.example.bootcounter.data.boot.dao.BootEventDao
import com.example.bootcounter.data.boot.model.BootEvent
import kotlinx.coroutines.flow.Flow

class BootEventLocalRepository(
    private val bootEventDao: BootEventDao
) {

    suspend fun saveBootEvent() {
        val bootEvent = BootEvent(0, System.currentTimeMillis())
        bootEventDao.addBootEvent(bootEvent)
    }

    suspend fun getAllBootEventsOnce() : List<BootEvent> {
        return bootEventDao.getBootEventListOnce()
    }

    fun getAllBootEvents() : Flow<List<BootEvent>> {
        return bootEventDao.getBootEventList()
    }

}