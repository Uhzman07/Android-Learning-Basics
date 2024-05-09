package com.example.myapplication1

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build

// A notification channel is something in which we send a notification to

// Note that we have to link this class to the AndroidManifest.xml

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        // Note that we are trying to create this channel for sdk version Oreo and above
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) { //
            val channel =NotificationChannel(
                "channel_id", // This is the id
                "Channel_name",
                NotificationManager.IMPORTANCE_HIGH // This is to speculate whether it comes with a sound or something
            )
            channel.description = "This is the message" // This is used to give the user some sort of information

            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager // Casted as Notification Manager

            // Then we use the notification manager to create our notification channel
            notificationManager.createNotificationChannel(channel)

        }
    }
}