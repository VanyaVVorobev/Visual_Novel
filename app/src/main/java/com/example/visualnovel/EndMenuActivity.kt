package com.example.visualnovel

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class EndMenuActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_last_menu)
        val myButton = findViewById<Button>(R.id.endMenu_Button)
        myButton.setOnClickListener { finish() }
    }
}