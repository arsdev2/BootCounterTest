package com.example.bootcounter.presentation.boot.receiver


import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.example.bootcounter.R
import com.example.bootcounter.domain.boot.interactor.GetBootInfoDataForNotification
import com.example.bootcounter.presentation.boot.activity.BootInfoActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


class NotificationReceiver : BroadcastReceiver(), KoinComponent {

    companion object {
        private const val NOTIFICATION_ID = 101
    }

    private val getBootInfoDataForNotification: GetBootInfoDataForNotification by inject()

    override fun onReceive(context: Context, intent: Intent) {
        CoroutineScope(Dispatchers.IO).launch {
            val bootInfoDataForNotification = getBootInfoDataForNotification()
            showNotification(context, bootInfoDataForNotification)
        }
    }

    private fun showNotification(context: Context, contentText: String) {
        val mBuilder = NotificationCompat.Builder(context)

        mBuilder.setSmallIcon(R.mipmap.ic_launcher) // notification icon
            .setContentTitle("Boot data")
            .setContentText(contentText)
            .setAutoCancel(true) // clear notification after click


        val resultIntent = Intent(context, BootInfoActivity::class.java)
        var flag = PendingIntent.FLAG_UPDATE_CURRENT
        if(Build.VERSION.SDK_INT >= 31) {
            flag = flag or PendingIntent.FLAG_MUTABLE
        }
        val resultPendingIntent = PendingIntent.getActivity(
            context,
            NOTIFICATION_ID,
            resultIntent,
            flag
        )

        mBuilder.setContentIntent(resultPendingIntent)
        val mNotificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        mNotificationManager.notify(NOTIFICATION_ID, mBuilder.build())
    }


}