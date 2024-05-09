package com.example.myapplication1

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat

class CounterNotificationService(
    private val context: Context// We are adding context in its constructor because we need the context for different purposes
) {

    // Then to create the notification we always the notification manager
    private val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    fun showNotification(counter:Int){
        val activityIntent = Intent(context, MainActivity::class.java) // This is set as the initial intent and will be the one that will be changing always

        // Below is the the intent that keeps on changing
        // Note that we have to create an activity also since it will be changing everytime
        val activityPendingIntent = PendingIntent.getActivity(
            context,
            1,
            activityIntent,
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) PendingIntent.FLAG_IMMUTABLE else 0
            // Note that flag immutable means that whatever we get from that intent cannot directly manipulate the existing intent


        )
        val incrementIntent = PendingIntent.getBroadcast(
            context,
            2,
            Intent(context,CounterNotificationReceiver::class.java)
            // if we want to attach somethings to the the Intent we can simply add
            /*
                .apply{
                    putExtra("my_extra",5)
                }
             */
            ,
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) PendingIntent.FLAG_IMMUTABLE else 0


        )
        val notification = NotificationCompat.Builder(context, COUNTER_CHANNEL_ID) // The two "!!" after context is just to make sure that they are not null
                // Note that for the small icon, we go to the res, drawable, vector asset
            .setSmallIcon(R.drawable.baseline_baby_changing_station_24)
            .setContentTitle("Increment Counter")
            .setContentText("The count is $counter")
                // This setStyle is use with different purposes for example, some could be used with music players and all of that
                /*
            .setStyle(
                Notification.BigTextStyle()
            )
                 */
            .setContentIntent(activityPendingIntent)
                /*
                Here are some functions that we could also try
            .setSound()
            .setLights()
            .setNumber() // Like a counter

                 */
            .addAction(
                R.drawable.baseline_plus_one_24,
                "Increment",
                // To get the counter we need a broadcast receiver thereby we have to create the broadcast receiver
                // So we can just create an external class for it
            incrementIntent

            )
            .build()
        notificationManager.notify(
            1,
            notification
        )

    }

    companion object{ // This is used to define constants that we can access from all of our projects
        const val COUNTER_CHANNEL_ID = "counter_channel" // Now we can access this variable any where we want


    }
}