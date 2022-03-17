package com.example.visualnovel

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.visualnovel.databinding.ActivityGreetingBinding

class GreetingActivity: AppCompatActivity() {
    private lateinit var binding: ActivityGreetingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGreetingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myButton = binding.button
        myButton.setOnClickListener {
            intent.putExtra(CURRENT_GAME_ACTIVITY_KEY, 0)
            intent.putExtra(USERNAME_KEY, binding.getUsername.text.toString())
            intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
        }
    }
}