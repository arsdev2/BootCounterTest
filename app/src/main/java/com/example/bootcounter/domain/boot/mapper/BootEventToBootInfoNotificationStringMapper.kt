package com.example.bootcounter.domain.boot.mapper

import com.example.bootcounter.data.boot.model.BootEvent

class BootEventToBootInfoNotificationStringMapper {

    fun map(bootEventList: List<BootEvent>) : String {
        return when(bootEventList.size){
            0 -> "No boots detected"
            1 -> "The boot was detected with the timestamp = ${bootEventList[0].timestamp}"
            else -> getLastBootTimeDelta(bootEventList)
        }
    }

    private fun getLastBootTimeDelta(bootEventList: List<BootEvent>): String {
        if(bootEventList.size < 2) throw RuntimeException("Illegal argument list have not enough elements")
        val lastBootEvent = bootEventList.last()
        val preLastBootEvent = bootEventList[bootEventList.size - 2]
        return "Last boots time delta = ${lastBootEvent.timestamp - preLastBootEvent.timestamp}"
    }

}