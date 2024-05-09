package com.example.myapplication1

import android.Manifest
import android.Manifest.permission
import android.app.Activity
import android.app.AlertDialog
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
import androidx.recyclerview.widget.LinearLayoutManager
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
    //private var customToastView: View? = null // This is the start of creating a custom toast view


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //val view = binding.root
        setContentView(binding.root)


        // Fragments
        // To create a fragment, it also needs a class and an xml file
        // We go to our package folder then right click then new then fragment then empty fragment
        // Then we name it, Android studio automatically creates the xml file and the kotlin class file
        // In the xml file, we have to change the Frame Layout to constraint layout

        // If we want to add a fragment that had been created externall
        // y inside a fragment in the main xml file, we have to use the name attribute
        // That is the "android:name="com.example.myapplication1.FirstFragment" because android automatically helps to suggest the fragment name
        // So a better way to do it is to make use of a frame layout which locks out an area of the screen to display a single item
        // The frame layout is able to hold fragments, then we can also remove the name attribute

        // Fragment instance
        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()

        // To replace the content of the frame layout with the fragments
        // Here we are initializing what is going to be in the
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment,firstFragment) // The one with the id is the frameLayout's id and then the fragment that is following is the one we want to set in it initially
            commit() // Note that we must always have to use this commit method
        }

        // Setting first fragment with button
        binding.btnFragment1.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment,firstFragment)
                addToBackStack(null) // If we add this then we can navigate to the previous fragment that had been opened
                // We have null as the name here because we do not just want to name it
                // Now, when we press the back button it goes back to the previous fragment instead of closing the entire activity
                // So this will continuously add on one stack to another so when we press back button it opens the previous one until there is nothing left to open then it finally closes the activity
                commit() // Note that we must always have to use this commit method
            }

        }

        // Setting second fragment with button
        binding.btnFragment2.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment,secondFragment)
                addToBackStack(null)
                commit() // Note that we must always have to use this commit method
            }

        }

        // Note that this fragment is not stacked in our activity









    }


}
