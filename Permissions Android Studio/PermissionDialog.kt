package com.example.myapplication1

import android.Manifest
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun PermissionDialog(  // Note that the permission dialogue function usually has an alert dialogue in it.
    permissionTextProvider:PermissionTextProvider, // This is the interface which we had created below
    //permissionTextProvider: PermissionTextProvider, // This is from our interface that we had created
    isPermanentlyDeclined: Boolean,
    onDismiss: () -> Unit,
    onOkClick : () -> Unit,
    onGoToAppSettingsClick: () -> Unit, // When the user declines the app settings twice
    modifier : Modifier = Modifier
) {
    AlertDialog( // Note that the parameters here are inbuilt and automatic we just have fill them in
        onDismissRequest = onDismiss,
        confirmButton = {
                  Column(
                      modifier = Modifier.fillMaxWidth()
                  ){
                      Divider()
                      Text(
                          text = if(isPermanentlyDeclined){
                              "Grant permission"
                          } else{
                              "OK"
                          },
                          fontWeight = FontWeight.Bold,
                          textAlign = TextAlign.Center,
                          modifier = Modifier
                              .fillMaxWidth()
                              .clickable {
                                  if (isPermanentlyDeclined) {
                                      onGoToAppSettingsClick()
                                  } else {
                                      onOkClick()
                                  }
                              }
                              .padding(16.dp)



                      )

                  }


        },
        title ={
               Text(text = "Permission required")
        },
        text ={
            Text(
                text = permissionTextProvider.getDescription(
                    isPermanentlyDeclined = isPermanentlyDeclined
                )
            )
        },
        modifier = modifier
    )

}

// Here we are creating an interface for the our permission
// This is useful when we are considering multiple permissions
interface PermissionTextProvider{
    fun getDescription(isPermanentlyDeclined: Boolean) : String
}

class CameraPermissionTextProvider: PermissionTextProvider{
    override fun getDescription(isPermanentlyDeclined: Boolean): String{
        return if(isPermanentlyDeclined){
            "It seems you permanently declined camera permission. " +
                    "You can got to the app settings to grant it."
        }
        else{
            "This app needs access to your camera so that your friends "+
                    "can see you in a call"
        }
    }
}
class RecordAudioPermissionTextProvider: PermissionTextProvider{
    override fun getDescription(isPermanentlyDeclined: Boolean): String{
        return if(isPermanentlyDeclined){
            "It seems you permanently declined microphone permission. " +
                    "You can got to the app settings to grant it."
        }
        else{
            "This app needs access to your microphone so that your friends "+
                    "can hear you in a call"
        }
    }
}
class PhoneCallPermissionTextProvider: PermissionTextProvider{
    override fun getDescription(isPermanentlyDeclined: Boolean): String{
        return if(isPermanentlyDeclined){
            "It seems you permanently declined phone calling permission. " +
                    "You can got to the app settings to grant it."
        }
        else{
            "This app needs phone calling permission so that you can talk "+
                    "to your friends."
        }
    }
}