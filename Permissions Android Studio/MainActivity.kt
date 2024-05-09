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

    private val permissionsToRequest = arrayOf(
        Manifest.permission.RECORD_AUDIO,
        Manifest.permission.CALL_PHONE
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //val view = binding.root
        setContentView(binding.root)
        //setContentView(view)

        /*
        val list = listOf(5,3,6,7,9,1)
        sortList(list)
        Log.d("MainActivity","Hello this is our first log message") // Note that this tag is used in the log cat as a way of filtering by pressing "Ctrl+Space" then tag
        println(list)

         */
        //val binding =
        //val btnApply = findViewById<Button>(R.id.btnApply) // Button here is the type while the name in the bracket is the on that is referring to the id of the button, R is for res
        // We could use just the name only to access the id of the button

        /*
        binding.btnApply.setOnClickListener{
            val firstName = binding.etFirstName.text.toString()
            val lastName = binding.etLastName.text.toString()
            val birthDate = binding.etBirthDate.text.toString()
            val country = binding.etCountry.text.toString()

            Log.d("MainActivity","$firstName $lastName born on $birthDate, from $country just applied to the formular")



        }

         */
        /*
        var count = 0
        binding.btnCount.setOnClickListener{
            count++
            binding.tvCount.text = "Lets count together $count"
        }
         */
        // text view, button, edit text for addition
        /*
        binding.btnAdd.setOnClickListener{
            val firstNumber = binding.etFirstNumber.text.toString().toInt() // note that we have to first convert ot to a string then to an integer
            val secondNumber = binding.etSecondNumber.text.toString().toInt()
            val result = firstNumber + secondNumber
            binding.tvResult.text = result.toString() // We have to convert back to a string so as to use in a text view
        }

         */
        /*
        // To add an image using the buttons
        binding.btnAddImage.setOnClickListener {
            binding.ivImage.setImageResource(R.drawable.halal) // this is the location of the image in the app folder
        }

         */
        /*

        // This is the code for the radio button

        binding.btnOrder.setOnClickListener {
            val checkedMeatRadioButtonId= binding.rgMeat.checkedRadioButtonId // This is to get the id of the one out of the radio button that has been selected
            val meat = findViewById<RadioButton>(checkedMeatRadioButtonId) // We need to derive the id of the one that has been checked
            val cheese = binding.cbCheese.isChecked // Since this can only be true or false
            val onions = binding.cbOnions.isChecked
            val salad = binding.cbSalads.isChecked

            val orderString = "You ordered a burger with: \n" +
                    "${meat.text}"+ // Now we can get the text of the particular radio button that had been selected
                    (if(cheese) "\nCheese" else "") + // This is a conditional statement since kotlin does not really require the braces
                    (if(onions) "\nOnions" else "") +
                    (if(salad) "\nSalads" else "")

            binding.tvOrder.text = orderString


        }

         */
        // Show toast, this is for the normal toast that is just some series of words
        /*
        binding.btnShowToast.setOnClickListener {
            Toast.makeText(this, "The app works fine",Toast.LENGTH_LONG).show()
        }

         */
        /*

        // Inflate your custom toast xml file
        customToastView = layoutInflater.inflate(R.layout.custom_toast, findViewById<View>(R.id.clToast) as ViewGroup?)
        // Show toast that comes with an icon and a text view along with a custom layout
        binding.btnShowToast.setOnClickListener {
            val toast = Toast(this)
            toast.duration = Toast.LENGTH_LONG
            toast.view = customToastView
            toast.show()
        }

         */
        // This is for an intent which is used to open an activity and another
        /*
        binding.buttonOpenActivity.setOnClickListener {
            Intent(this,SecondActivity::class.java).also{
                startActivity(it) // The it here is referring to the second activity

            } // This is an intent to start the second activity
        }

         */

        /*
        // Intent for transferring data from one activity to another
        binding.btnApply.setOnClickListener{
            // Extras
            val name = binding.etName.text.toString()
            val age = binding.etAge.text.toString().toInt()
            val country = binding.etCountry.text.toString()
            val person = Person(name, age, country)
            Intent(this, SecondActivity::class.java).also{
                /*
                it.putExtra("EXTRA_NAME",name)
                it.putExtra("EXTRA_AGE",age)
                it.putExtra("EXTRA_COUNTRY",country)

                 */
                //  Here is the one that involves the class and objects
                it.putExtra("EXTRA_PERSON",person)
                startActivity(it)
            }


        }
         */

         /*
        // PERMISSIONS  Note that I can't use this as it is deprecated
        binding.btnRequestPermission.setOnClickListener {
            requestPermissions() // We are calling our function here
        }

         */
        setContent{
            MyApplication1Theme{ // this is from the manifest.xml file and this is from the android theme that had been stated there
                val viewModel  = viewModel<MainViewModel>() // This is from the class Main View Model
                val dialogQueue = viewModel.visiblePermissionDialogQueue // This is the representation of the visiblePermissionDialogueQueue from MainViewModel

                val cameraPermissionResultLauncher = rememberLauncherForActivityResult(
                    contract = ActivityResultContracts.RequestPermission(),
                    onResult = {
                            isGranted -> // Note that isGranted here is the boolean value that we derive
                        viewModel.onPermissionResult( // this is linked to the Main View Model class
                            permission =  Manifest.permission.CAMERA,
                            isGranted = isGranted

                        )

                    }

                )

                val multiplePermissionResultLauncher = rememberLauncherForActivityResult(
                    contract = ActivityResultContracts.RequestMultiplePermissions(),
                    onResult = {perms-> // Perms here is used to contain multiple permissions results
                        permissionsToRequest.forEach {permission-> // Note that this is a better way of writing it since we already have the array
                        //perms.keys.forEach{ permission-> // The keys here is to differentiate each different permission since we have multiple permissions
                            viewModel.onPermissionResult( // Now we are trying to save the multiple permissions by calling this MainViewModel function one by one
                                permission =  permission, // This is the permission for each
                                isGranted = perms[permission] == true // This is the boolean value for each

                            )


                        }


                    }

                )


                // We want to build our columns, this is what we see, that is what appears on the screen
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally


                ) {
                    Button(onClick = {
                        cameraPermissionResultLauncher.launch(
                            Manifest.permission.CAMERA
                        )
                    }) {
                        Text(text="Request one permission")
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(onClick = {
                        multiplePermissionResultLauncher.launch(
                            permissionsToRequest// Note that since it contains not just one permission, so we had used an array of several permissions at the top

                        )
                    }) {
                        Text(text = "Request multiple permission")
                    }
                }
                dialogQueue // This is what contains all the permissions that we are traversing through
                    .reversed() // this is used since they are added backwards so that we can get them as required
                    .forEach{permission->
                        PermissionDialog(
                            permissionTextProvider = when (permission){
                                Manifest.permission.CAMERA ->{
                                    CameraPermissionTextProvider()
                                }
                                Manifest.permission.RECORD_AUDIO->{
                                    RecordAudioPermissionTextProvider()
                                }
                                Manifest.permission.CALL_PHONE ->{
                                    PhoneCallPermissionTextProvider()
                                }
                                else -> return@forEach
                            },
                            isPermanentlyDeclined = !shouldShowRequestPermissionRationale(
                                permission
                            ),
                            onDismiss = viewModel::dismissDialog,
                            onOkClick = {
                                viewModel.dismissDialog()
                                multiplePermissionResultLauncher.launch(
                                    arrayOf(permission)
                                )

                                        },
                            onGoToAppSettingsClick = ::openAppSettings // Note that we are calling a function that we had created here
                        )
                    }

            }

        }



    }
    /*
    // PERMISSIONS This is deprecated so I cannot use it anymore
    private fun hasWriteExternalStoragePermission() =
        ActivityCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED // This is expected to return a boolean value true or false
    private fun hasLocationForegroundPermission() =
        ActivityCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
    private fun hasLocationBackgroundPermission() =
        ActivityCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED

    private fun requestPermissions(){
        var permissionsToRequest = mutableListOf<String>() // This is the list that we are planning to store all the permissions that had not been accepted by the user
        // This is to check the permissions the user had not accepted
        if(!hasWriteExternalStoragePermission()){
            permissionsToRequest.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }
        if(!hasLocationForegroundPermission()){
            permissionsToRequest.add(Manifest.permission.ACCESS_COARSE_LOCATION)
        }
        if(!hasLocationBackgroundPermission()){
            permissionsToRequest.add(Manifest.permission.ACCESS_BACKGROUND_LOCATION)
        }
        if(permissionsToRequest.isNotEmpty()){
            ActivityCompat.requestPermissions(this,permissionsToRequest.toTypedArray(), 0) // Note that we are setting the request code to zero when the array list is not empty
        }


    }

    // This entire function comes out when we give android studio a hint
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>, // This will serve as our array of list
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == 0 && grantResults.isNotEmpty()){
            for(i in grantResults.indices){ // Note that this is the same as grantResults.size - 1
                if(grantResults[i] == PackageManager.PERMISSION_GRANTED){
                    Log.d("PermissionRequest", "${permissions[i]} granted")
                }

            }
        }
    }

     */


    /*
    private fun sortList(list: List<Int>){
        for(i in 0..list.size-1){
            for(j in 0..list.size-2){
                if(list[j] > list[j+1]){
                    Collections.swap(list,j,j+1) // This is an in built method in kotlin
                }
            }
        }
    }

     */
}
fun Activity.openAppSettings(){
    Intent(
        Settings.ACTION_APPLICATION_DETAILS_SETTINGS, // This is settings from android.provider
        Uri.fromParts("package",packageName,null)
    ).also(::startActivity)

}