package com.example.myapplication1

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent


// Note that we must always add our receiver in the manifest file
class CounterNotificationReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {
        val service = CounterNotificationService(context)
        service.showNotification(++Counter.value)
    }
}