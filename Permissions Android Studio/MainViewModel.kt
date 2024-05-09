package com.example.myapplication1

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    val visiblePermissionDialogQueue = mutableStateListOf<String>() // This is a type of list of our jetpack compose

    fun dismissDialog(){
        visiblePermissionDialogQueue.removeLast() // We are trying to remove the last permission
    }
    fun onPermissionResult(
        permission:String,
        isGranted:Boolean
    ){
        if(!isGranted && !visiblePermissionDialogQueue.contains(permission)){ // We want to check if the permission had not been granted and if it has not been in the dialogue queue where we are storing the permissions
            visiblePermissionDialogQueue.add(0,permission)
        }

    }

}