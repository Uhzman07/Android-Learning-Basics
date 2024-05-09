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
import androidx.fragment.app.Fragment
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

        // First thing we are going to do is to add the dependency
        // implementation 'com.google.android.material:material:1.2.0-alpha04'
        // We create our menu folder by going to the res folder then new then "android resource directory"
        // Then we have to right click the folder to create the menu resource file
        // Then we need to create icons (drawable -> new -> image assets

        // Note that goggle has some in built things like the bottoms so we can just type "material" to check all the available things
        // That they all belong to the materials design library
        // Note that here we are adding our externally created menu bar to our bottom navigation view
        // We might have a little issue as the background is dark but we can always correct it by going to "themes.xml"
        // Then we change the parent component to "Theme.MaterialComponents.Light.DarkActionBar"
        // This allows the background to be light
        // Then we create the 3 fragment files in our layout folder
        // We also have to have to create a kotlin class for each fragment file\
        // Note that each fragment xml file should have a kotlin class which it is linked to using the constructor of that class that is for example, "R.layout.fragment_first"

        // Now we need to create an instance of each of the fragment classes
        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()
        val thirdFragment = ThirdFragment()

        setCurrentFragment(firstFragment) // This is to set the current fragment

        binding.bottomNavigationView.setOnNavigationItemSelectedListener { // this is just like the "setOnClickListener" but for the bottom navigation
            when(it.itemId){ // This is like a switch statement
                R.id.miHome -> setCurrentFragment(firstFragment)
                R.id.miMessages -> setCurrentFragment(secondFragment)
                R.id.miProfile -> setCurrentFragment(thirdFragment)
            }
            // Note that since this a lambda function, it must return true
            // So we can just write "true" to clear the error code
            true
        }
        // To create like a counter for the items just like the one that shows the number of new messages that we have
        // This is called a badge and it appears at the right top corner of the item that is the icon that is in the navigation bar
        binding.bottomNavigationView.getOrCreateBadge(R.id.miMessages).apply{
            number = 10 // this is an example but normally we will use it based on the number of messages but here, we will have to set it manually just for an example
            isVisible = true // This actually makes it visible
        }



    }
    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply{
            replace(R.id.flFragment,fragment)
            commit()
        }


}
