package com.example.myapplication1

import android.app.Service
import android.content.Intent
import android.nfc.Tag
import android.os.IBinder
import android.util.Log

// Note that the difference between the normal service and Intent service is that the normal service does support multi threading
class MyService : Service() {

    val TAG = "MyService"

    init { // This is used to represent the "startService()" method
        Log.d(TAG, "Service is running")
    }

    override fun onBind(intent: Intent?): IBinder? = null
    // Note that onBind "IBinder?" is a method that is required if we have multiple clients trying to connect to the same service

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // This command is used to deliver the intent we started the service with
        // We can also used to pass data and communicate from our service

        val dataString = intent?.getStringExtra("EXTRA_DATA")
        dataString?.let { // This is used to check if the variable is not null and then to add to iy
            Log.d(TAG, dataString)
        }
        //return super.onStartCommand(intent, flags, startId)

        // Different types of returns
        // return START_NOT_STICKY -- This will destroy the service and won't recreate it again even if it is replaced by another.
        // return  START_STICKY -- If the service is created by the system, it will recreate it when possible
        // return START_REDELIVER_INTENT

        Thread {
            while (true) {

            }
        }.start()

        return START_STICKY


    }

    override fun onDestroy() { // This is used to represent the "stopService()" method
        super.onDestroy()
        Log.d(TAG, "Service is being killed...")
    }

}