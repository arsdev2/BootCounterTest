package com.example.bootcounter.presentation.boot.receiver

import android.R
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import com.example.bootcounter.domain.boot.interactor.GetBootInfoDataForNotification
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


class NotificationReceiver : BroadcastReceiver(), KoinComponent {

    companion object {
        private val NOTIFICATION_ID = 101L
    }

    private val getBootInfoDataForNotification: GetBootInfoDataForNotification by inject()

    override fun onReceive(context: Context, intent: Intent) {

        CoroutineScope.launch {

        }

        val mgr = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val mBuilder = NotificationCompat.Builder(context)

        mBuilder.setSmallIcon(R.mipmap.sym_def_app_icon) // notification icon
            .setContentTitle("Boot data")
            .setContentText("You have new horoscope")
            .setAutoCancel(true) // clear notification after click


        val resultIntent = Intent(context, MainActivity::class.java)
        val resultPendingIntent = PendingIntent.getActivity(
            context,
            mNotificationId,
            resultIntent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        mBuilder.setContentIntent(resultPendingIntent)
        val mNotificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        mNotificationManager.notify(mNotificationId, mBuilder.build())
    }


}