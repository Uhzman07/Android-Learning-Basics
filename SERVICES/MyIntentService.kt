@file:Suppress("DEPRECATION")

package com.example.myapplication1

import android.app.IntentService
import android.content.Intent
import android.util.Log

class MyIntentService : IntentService("MyIntentService") { // Note that the number does not really matter in any way

    init{ // Note that init is used to refer to a particular class instead
        instance = this  // This is mostly used when we know that we are going to use this class in another class so that we are directly access it from there
    }

    // Note that the companion object is visible by this class and others
    companion object{
        private lateinit var instance : MyIntentService
        var isRunning = false

        fun stopService(){
            Log.d("MyIntentService","Service is stopping...")
            isRunning = false
            instance.stopSelf() // This is the method that is used to stop the intent service

        }
    }

    // This is the function
    override fun onHandleIntent(intent: Intent?) { // Running
        try {
            isRunning = true
            while(isRunning){
                Log.d("MyIntentService","Service is running...")
                Thread.sleep(1000) // This is to make it sleep for one second
            }
        } catch (e : InterruptedException){
            Thread.currentThread().interrupt() // We just want to interrupt the current thread
        }

    }

}