package com.example.visualnovel

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.visualnovel.databinding.ActivityGameBinding



class GameActivity: AppCompatActivity() {
    private lateinit var binding: ActivityGameBinding
    private lateinit var gameLogic: ActivityGameLogic
    private var  current = ID_FIRST_GAME_SCREEN

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val context = this
        gameLogic = ActivityGameLogic(context)

        updateScreen()
        binding.firstButton.setOnClickListener { onClickButton(1) }
        binding.secondButton.setOnClickListener { onClickButton(2) }
        binding.thirdButton.setOnClickListener { onClickButton(3) }
    }

    private fun onClickButton(clickedButtonNumber: Int) {
        current = updateCurrent(clickedButtonNumber)
        if(current == ID_LAST_GAME_SCREEN) {
            intent = Intent(this, EndMenuActivity::class.java)
            startActivity(intent)
            finish()
        }
        else
        {
            updateScreen()
        }
    }

    private fun updateScreen(){
        updateImage()
        updateButtons()
        updateText()
    }

    private fun updateImage() {
        binding.backgroundImage.setImageResource(
            resources.getIdentifier(gameLogic.getCurrentImage(current), "drawable",packageName))
    }

    private fun updateText() {
        if(current == ID_FIRST_GAME_SCREEN) {
            val buff = "Отлично, ${intent.getStringExtra(USERNAME_KEY)}! Чем займемся?"
            binding.textView.text =buff
        }
        else {
            binding.textView.text=gameLogic.getCurrentText(current)
        }
    }

    private fun updateButtons() {
        val countButton = gameLogic.getCountButton(current)
        binding.secondButton.text=gameLogic.getButtonText(current, 1)

        if(countButton>1){
            binding.thirdButton.text=gameLogic.getButtonText(current, 2)
        }
        else {
            binding.thirdButton.visibility = View.INVISIBLE
            binding.firstButton.visibility = View.INVISIBLE
        }

        if(countButton>2) {
            binding.firstButton.text=gameLogic.getButtonText(current, 3)
        }
        else {
            binding.firstButton.visibility = View.INVISIBLE
        }
    }

    private fun updateCurrent(clickedButtonNumber: Int) = gameLogic.getNextIdScreen(current, clickedButtonNumber)
}