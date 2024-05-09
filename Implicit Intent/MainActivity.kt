package com.example.myapplication1

import android.Manifest
import android.Manifest.permission
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.media.audiofx.BassBoost
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.View
import android.view.ViewGroup
//import com.example.myapplication1.databinding.ResultProfileBinding

import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication1.databinding.ActivityMainBinding
import com.example.myapplication1.ui.theme.MyApplication1Theme
//import kotlinx.android.synthetic.main.activity_main.btnApply
//import kotlinx.android.synthetic.main.activity_main.btnApply
//import kotlinx.android.synthetic.main.activity_main.etBirthDate
//import kotlinx.android.synthetic.main.activity_main.etCountry
//import kotlinx.android.synthetic.main.activity_main.etFirstName
//import kotlinx.android.synthetic.main.activity_main.etLastName
import java.util.Collections
@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var customToastView: View? = null // This is the start of creating a custom toast view


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //val view = binding.root
        setContentView(binding.root)
        //setContentView(view)
        binding.btnTakePhoto.setOnClickListener { // We are trying to make the android system to suggest all possible apps to choose from
            // Implicit intent
            Intent(Intent.ACTION_GET_CONTENT).also{
                it.type= "image/*" // This is to tell the android system the type of content that we are looking for, here it is all types of images
                // Note that we could also have other specifications such as
                // it.type = "image/png" or "image/jpeg" // This will either look for a png file only or only jpeg file
                // Now we that we are expecting a result
                startActivityForResult(it,0) // The request code here is used to differentiate several activities that we had started for results

            }

        }
    }

    // To get the data
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) { // Note that we just have to type onActivityResult to get all these
        super.onActivityResult(requestCode, resultCode, data) // This is also generated automatically
        if(resultCode == RESULT_OK && requestCode == 0){ // This means if the fetch was successful and the result code is used to get the exact activity
            val uri = data?.data // Note that we have the "?" cus its nullable and the the data before the dot reps the intent then the data after reps the data to be fetched
            binding.ivPhoto.setImageURI(uri) // We have to set the URI
        }
    }
}
