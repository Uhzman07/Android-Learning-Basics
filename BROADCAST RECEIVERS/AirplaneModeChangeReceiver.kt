package com.example.myapplication1

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AirplaneModeChangeReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val isAirplaneModeEnabled = intent?.getBooleanExtra("state", false) ?: return // This is used to assure that a nullable value is not returned
        if(isAirplaneModeEnabled){
            Toast.makeText(context,"Airplane Mode enabled",Toast.LENGTH_LONG).show()
        }else {
            Toast.makeText(context,"Airplane Mode enabled",Toast.LENGTH_LONG).show()
        }
    }
}