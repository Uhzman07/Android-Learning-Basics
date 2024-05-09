package com.example.myapplication1

import android.Manifest
import android.Manifest.permission
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.media.audiofx.BassBoost
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
//import com.example.myapplication1.databinding.ResultProfileBinding

import android.widget.Button
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.ActionBarDrawerToggle
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
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication1.databinding.ActivityMainBinding
import com.example.myapplication1.ui.theme.MyApplication1Theme
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
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
    //private var customToastView: View? = null // This is the start of creating a custom toast view




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //val view = binding.root
        setContentView(binding.root)

        // SAVING DATA IN SHARED PREFERENCES
        // Note that even if we close our app, it saves the data and is capable of returning it
        // Note that this should only be used for smaller amount of data
        val sharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE) // We make it private so it cannot be accessed by other applications

        val editor = sharedPref.edit() // This is used to add to the shared preferences that is, it is used to edit it

        binding.btnSave.setOnClickListener {
            val name = binding.etName.text.toString()
            val age = binding.etAge.text.toString().toInt() // Since it is a number
            val isAdult = binding.cbAdult.isChecked

            // To now save our data in the shared preferences
            editor.apply {
                putString("first",name) // Note that "first" in the bracket is the key to recognize the stored variable
                putInt("second",age)
                putBoolean("third",isAdult)

                apply() // This functions tells android that we are finished and that we want to write our data in our shared preferences
                //commit() // This does the same function synchronously but it blocks the UI
                // apply() saves the data asynchronously there by it is a better option and doesn't block the main thread
            }



        }
        // To get the name from our shared preferences
        binding.btnLoad.setOnClickListener {
            val name = sharedPref.getString("first",null) // We have null in case our name does not exist
            val age = sharedPref.getInt("second",0) // 0 is the default value here
            val isAdult = sharedPref.getBoolean("third",false)

            // To set the text back
            binding.etName.setText(name)
            binding.etAge.setText(age.toString()) // We need to convert to a string before setting the text
            binding.cbAdult.isChecked = isAdult


        }





    }

}
