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

        // TAB LAYOUT
        // This is an improvement on the swipable views and the it is used to add more reference to the views
        // We add the dependency to the build.gradle file
        // Then we go to the layout folder then right click -> new -> LayoutResourceFile so as to create the desired layout
        // Then we need to create our adapter class for swiping just like the one for the recycler view

        val images = listOf(
            R.drawable.halal,
            R.drawable.pic1,
            R.drawable.pic2,
            R.drawable.pic3,
            R.drawable.pic4,
            R.drawable.pic5,
            R.drawable.pic6


        )

        val adapter = ViewPagerAdapter(images) // We need to create an adapter for our viewPager
        // Then we set the view pager adapter to our newly created adapter
        binding.viewPager.adapter = adapter

        /*
        // To make it vertical just like tik tok and all that is the swiping
        binding.viewPager.orientation = ViewPager2.ORIENTATION_VERTICAL
         */
        /*
        // To make it swipe automatically
        binding.viewPager.beginFakeDrag()
        binding.viewPager.fakeDragBy(-10f) // This automatically swipes down once the app is opened
        binding.viewPager.endFakeDrag()
         */

        /*
        // To connect the tab layout with our view pager
        binding.tabLayout.setupWithViewPager() // This is not so effective because it will only swipe to the corresponding view pager
         */
        // A better way to connect the tab layout and the view pager
        TabLayoutMediator(binding.tabLayout,binding.viewPager){ tab, position ->
            tab.text = "Tab ${position + 1}"

        }.attach() // This method is very important for it to display


        // For the functions that control activities with the clicking of the the tabs
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            // Then we use ctrl + i for the other functions
            override fun onTabSelected(tab: TabLayout.Tab?) { // When a tab is selected
                Toast.makeText(this@MainActivity,"Selected ${tab?.text}",Toast.LENGTH_SHORT).show()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) { // When a tab is unselected
                Toast.makeText(this@MainActivity,"Unselected ${tab?.text}",Toast.LENGTH_SHORT).show()
            }

            override fun onTabReselected(tab: TabLayout.Tab?) { // When a tab is reselected
                Toast.makeText(this@MainActivity,"Reselected ${tab?.text}",Toast.LENGTH_SHORT).show() // Note that we can't just type "this" since it is an anonymous class
                // Also note that the question mark here is used to perform a null check that is to check if the thing is not null
            }
        })


    }

}
