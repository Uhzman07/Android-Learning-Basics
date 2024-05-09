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
import android.view.Menu
import android.view.MenuItem
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
    //private var customToastView: View? = null // This is the start of creating a custom toast view


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //val view = binding.root
        setContentView(binding.root)

        // Tool bar menus
        // res -> new -> android resource directory -> resource type(menu) (This creates the menu folder)
        // Then go to the menu folder then right click -> menu resource file . This creates a named xml file
        // Then since we want to add some image icons to the menu bar, we go to the drawable folder -> right click -> new -> ImageAsset -> Clip Art -> Search (must be holo dark)






    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean { // This is a defined function to create the menu bar initially
        menuInflater.inflate(R.menu.app_bar_menu,menu) // This is to inflate the app_bar_menu xml file file from the menu folder
        return true // This is compulsory
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean { // This is used when selecting
        //return super.onOptionsItemSelected(item)
        when(item.itemId){ // we are considering the id this is like a switch statement
            R.id.miAddContact -> Toast.makeText(this,"You clicked on Add Contact",Toast.LENGTH_SHORT).show()
            R.id.miFavorites-> Toast.makeText(this,"You clicked on Favourites",Toast.LENGTH_SHORT).show()
            R.id.miSettings -> Toast.makeText(this,"You clicked on Settings",Toast.LENGTH_SHORT).show()
            R.id.miClose -> finish() // Since we want to close that menu bar
            R.id.miFeedback -> Toast.makeText(this,"You clicked on Feedback",Toast.LENGTH_SHORT).show()

        }
        return true // Always return true
    }

    // Note that due to deprecation, all these might not work then all we have to do is to go to res -> values -> themes.xml -> change the parent value to "Theme.AppCompat.Light.DarkActionBar" so that it is displayed.




}
