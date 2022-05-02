package com.example.visualnovel.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.visualnovel.databinding.ActivityMainBinding

const val USERNAME_KEY = "com.example.visualnovel.username"
const val ID_FIRST_GAME_SCREEN = 0
const val ID_LAST_GAME_SCREEN = 11
const val JSON_FILE_NAME = "myjson.json"

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