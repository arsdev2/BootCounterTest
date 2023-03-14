package com.example.bootcounter.presentation.boot.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.bootcounter.domain.boot.interactor.SaveBootEvent
import com.example.bootcounter.domain.coroutines.factory.CoroutineScopeFactory
import kotlinx.coroutines.*
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class BootCounterBroadcastReceiver : BroadcastReceiver(), KoinComponent {

    private val saveBootEvent: SaveBootEvent by inject()
    private val scopeFactory: CoroutineScopeFactory by inject()

    override fun onReceive(context: Context, intent: Intent) {
        parseIfItIsBootEvent(intent)
    }

    private fun parseIfItIsBootEvent(intent: Intent) {
        val action = intent.action ?: return
        if (action == Intent.ACTION_BOOT_COMPLETED) {
            parseBootEvent()
        }
    }

    private fun parseBootEvent() {
        scopeFactory.create().launch {
            try {
                saveBootEvent()
            } finally {
                cancel()
            }
        }
    }

}