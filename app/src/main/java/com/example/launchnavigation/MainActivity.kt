package com.example.launchnavigation

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.launchnavigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // set navigation button click handlers
        with(binding) {
            btnNavigate1.setOnClickListener {
                launchGoogleMapsNavigationTo(etAddress1.text.toString())
            }
            btnNavigate2.setOnClickListener {
                launchGoogleMapsNavigationTo(etAddress2.text.toString())
            }
            btnNavigate3.setOnClickListener {
                launchGoogleMapsNavigationTo(etAddress3.text.toString())
            }
            btnNavigate4.setOnClickListener {
                launchGoogleMapsNavigationTo(etAddress4.text.toString())
            }
            btnNavigate5.setOnClickListener {
                launchGoogleMapsNavigationTo(etAddress5.text.toString())
            }
        }
    }

    /**
     * https://developers.google.com/maps/documentation/urls/android-intents
     */
    private fun launchGoogleMapsNavigationTo(location: String) {
        // Create a Uri from an intent string. Use the result to create an Intent.
        val gmmIntentUri = Uri.parse("google.navigation:q=$location&mode=d")

        // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)

        // Make the Intent explicit by setting the Google Maps package
        mapIntent.setPackage("com.google.android.apps.maps")

        // Attempt to start an activity that can handle the Intent
        startActivity(mapIntent)
    }
}
