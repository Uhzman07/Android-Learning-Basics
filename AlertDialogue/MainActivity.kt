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

        val addContactDialog = AlertDialog.Builder(this)
            .setTitle("Add contact")
            .setMessage("Do you want to add Mr.Poop to your contacts list?")
            .setIcon(R.drawable.ic_add_contact)
            .setPositiveButton("Yes"){ _ ,_ -> // Note that we have "_,_" because we are trying to fill in the arguments which do not matter really
                Toast.makeText(this,"You added Usman to your contact list",Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No"){_,_ ->
                Toast.makeText(this,"You didn't add Usman to your contact list",Toast.LENGTH_SHORT).show()
            }.create() // This is compulsory

        binding.btnDialog1.setOnClickListener {
            addContactDialog.show()
        }

        val options = arrayOf("First Item", "Second Item", "Third Item")
        val singleChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose one of these options")
            .setSingleChoiceItems(options,0) { dialogInterface, i -> // Note that the i here will serve as the counter
                Toast.makeText(this,"You clicked on ${options[i]}",Toast.LENGTH_SHORT).show()

            }
            .setPositiveButton("Accept"){_,_ ->
                Toast.makeText(this,"You accepted the SingleChoiceDialog",Toast.LENGTH_SHORT).show()

            }
            .setNegativeButton("Decline"){_,_ ->
                Toast.makeText(this,"You declined the SingleChoiceDialog",Toast.LENGTH_SHORT).show()

            }.create() // compulsory

        binding.btnDialog2.setOnClickListener {
            singleChoiceDialog.show()
        }

        val multiChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose one of these options")
            .setMultiChoiceItems(options, booleanArrayOf(false,false,false)) {_,i,isChecked -> // The first "_" reps the dialogInterface, i reps the counter, "isChecked" reps the boolean value returned
                // booleanArrayOf() here is used to tell the ones that will be checked initially
                if(isChecked){
                    Toast.makeText(this,"You checked ${options[i]}",Toast.LENGTH_SHORT).show()

                }
                else{
                    Toast.makeText(this,"You unchecked ${options[i]}",Toast.LENGTH_SHORT).show()
                }

            }
            .setPositiveButton("Accept"){_,_ ->
                Toast.makeText(this,"You accepted the MultiChoiceDialog",Toast.LENGTH_SHORT).show()

            }
            .setNegativeButton("Decline"){_,_ ->
                Toast.makeText(this,"You declined the MultiChoiceDialog",Toast.LENGTH_SHORT).show()

            }.create() // compulsory
        binding.btnDialog3.setOnClickListener {
            multiChoiceDialog.show()
        }






    }


}
