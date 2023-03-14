package com.example.bootcounter.domain.boot.interactor

import com.example.bootcounter.data.boot.model.BootEvent
import com.example.bootcounter.data.boot.repository.BootEventLocalRepository
import kotlinx.coroutines.flow.Flow

class GetBootInfoForView(
    private val bootEventLocalRepository: BootEventLocalRepository,
) {

    operator fun invoke() : Flow<List<BootEvent>> {
        return bootEventLocalRepository.getAllBootEvents()
    }

}