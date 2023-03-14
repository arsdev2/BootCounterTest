package com.example.bootcounter.domain.boot.interactor

import com.example.bootcounter.data.boot.repository.BootEventLocalRepository
import com.example.bootcounter.domain.boot.mapper.BootEventToBootInfoNotificationStringMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetBootInfoDataForNotification(
    private val bootEventLocalRepository: BootEventLocalRepository,
    private val bootEventToBootInfoNotificationStringMapper: BootEventToBootInfoNotificationStringMapper
) {

    suspend operator fun invoke() : String {
        return bootEventToBootInfoNotificationStringMapper.map(bootEventLocalRepository.getAllBootEventsOnce())
    }

}