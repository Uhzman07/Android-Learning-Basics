package com.example.myapplication1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication1.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding :ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*
        // To now get the extras that we had saved // CTRL + Q to get the hints here
        val name = intent.getStringExtra("EXTRA_NAME")
        val age = intent.getIntExtra("EXTRA_AGE",0) // Since integers are more sensitive, we can set a default value just in case the extra value is not found
        val country = intent.getStringExtra("EXTRA_COUNTRY")
        val personString = "$name is $age years old and lives in $country"
        binding.tvPerson.text = personString
         */
        /*
        val person = intent.getSerializableExtra("EXTRA_PERSON") as Person // This is to tell Kotlin the class that we are trying to get the data from
        binding.tvPerson.text = person.toString()

         */



    }
}