package com.example.bootcounter.domain.boot.interactor

import com.example.bootcounter.data.boot.repository.BootEventLocalRepository

class SaveBootEvent(
    private val bootEventLocalRepository: BootEventLocalRepository
) {

    suspend operator fun invoke() {
        bootEventLocalRepository.saveBootEvent()
    }

}