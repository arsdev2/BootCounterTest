package com.example.bootcounter

import android.app.AlarmManager
import android.app.Application
import android.app.Notification
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.SystemClock
import com.example.bootcounter.data.boot.di.bootDataModule
import com.example.bootcounter.domain.boot.di.bootDomainModule
import com.example.bootcounter.domain.coroutines.di.appCoroutinesModule
import com.example.bootcounter.presentation.boot.di.bootPresentationModule
import com.example.bootcounter.presentation.boot.receiver.NotificationReceiver
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module


class BootCounterApplication : Application() {

    companion object {
        const val ALARM_ID = 10
    }

    override fun onCreate() {
        super.onCreate()
        initKoin()
        startNotificationTimer()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@BootCounterApplication)
            modules(
                listOf(
                    bootPresentationModule,
                    appCoroutinesModule,
                    bootDomainModule,
                    bootDataModule
                )
            )
        }
    }

    private fun startNotificationTimer() {
        val intentAlarm = Intent(this, NotificationReceiver::class.java)
        println("calling Alarm receiver ")
        val alarmManager = this.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        var flag = PendingIntent.FLAG_UPDATE_CURRENT
        if(Build.VERSION.SDK_INT > 31) {
            flag = flag or PendingIntent.FLAG_IMMUTABLE
        }
        val pi = PendingIntent.getBroadcast(
            this,
            ALARM_ID,
            intentAlarm,
            flag
        )
        alarmManager.setInexactRepeating(
            AlarmManager.RTC, SystemClock.elapsedRealtime(), (15 * 60 * 1000).toLong(), pi
        )
    }
}