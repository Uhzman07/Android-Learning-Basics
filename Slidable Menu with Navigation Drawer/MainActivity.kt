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

    // This is for our toggle also note that the toggle is used to swipe in and out that is to open and close the drawer layout
    lateinit var toggle:ActionBarDrawerToggle


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //val view = binding.root
        setContentView(binding.root)


        // Slidable menu with navigation drawer
        // If we are going to do this, we must use a drawer layout instead of a constraint layout
        // To create the header file for our navigation view
        // Go to the layout folder then right click - new - layout resource file
        // To create a new menu file for our navigation view,
        // Right click the res folder - new - android resource file - then name it to create the menu folder (menu as resource type) and then an xml file inside it

        // TOGGLE (That is we are adding a toggle to the drawer layout)
        toggle = ActionBarDrawerToggle(this,binding.drawerLayout,R.string.open, R.string.close) // This is for like blind people so that the they hear the sound when opened or closed
        // Then we go to our string.xml file to add the strings with names "open" and "close"

        // To connect the drawer layout with our toggle
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState() // This is used to launch the toggle

        supportActionBar?.setDisplayHomeAsUpEnabled(true) // This means that the toggle button moves to a back arrow so when clicked again, it quits
        // This above turns the menu icon to a "Go back icon"

        binding.navView.setNavigationItemSelectedListener {
            when(it.itemId){ // Note that R.id... are referring to the menu items
                R.id.miItem1 -> Toast.makeText(applicationContext,"Clicked Item 1",Toast.LENGTH_SHORT).show()
                R.id.miItem2 -> Toast.makeText(applicationContext,"Clicked Item 1",Toast.LENGTH_SHORT).show()
                R.id.miItem2 -> Toast.makeText(applicationContext,"Clicked Item 1",Toast.LENGTH_SHORT).show()
            }
            true // This is compulsory for a lambda function stating that we handled the click
        }


    }
    // The functions for the menu items this is usually used when the menu bar is available
    // This function is compulsory whenever we have a menu bar
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){ // This gives the toggle some sort of permission to click toggle items
            return true

        }
        return super.onOptionsItemSelected(item) // This returns the item that had been selected
    }

}
