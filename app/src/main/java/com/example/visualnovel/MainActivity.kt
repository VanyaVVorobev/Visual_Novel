package com.example.visualnovel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.visualnovel.databinding.ActivityMainBinding

const val CURRENT_GAME_ACTIVITY_KEY = "com.example.visualnovel.current"
const val USERNAME_KEY = "com.example.visualnovel.username"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myButton = binding.mainMenuButton
        myButton.setOnClickListener {
            val intent = Intent(this@MainActivity, GreetingActivity::class.java)
            startActivity(intent)
        }
    }
}