package com.example.myapplication1

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build

// A notification channel is something in which we send a notification to

// Note that we have to link this class to the AndroidManifest.xml

class MyApp : Application() { // Note that because this class is inheriting from Application, we have to add it to the manifest file
    override fun onCreate() {
        super.onCreate()

        createNotificationChannel()

    }

    private fun createNotificationChannel() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel(
                CounterNotificationService.COUNTER_CHANNEL_ID, // This is the ID
                "Counter",
                NotificationManager.IMPORTANCE_DEFAULT

            )
            channel.description = "Used for the increment counter notification"
            // Note that this description is what the user will actually see when he goes to the settings

            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}