package com.example.visualnovel

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.visualnovel.databinding.ActivityGameBinding

const val ID_FIRST_GAME_SCREEN = 0

class GameActivity: AppCompatActivity() {
    private lateinit var binding: ActivityGameBinding
    private val gameLogic = ActivityGameLogic(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        updateScreen(0)
        binding.firstButton.setOnClickListener { updateScreen(1) }
        binding.secondButton.setOnClickListener { updateScreen(2) }
        binding.thirdButton.setOnClickListener { updateScreen(3) }
    }

    private fun updateScreen(clickedButtonNumber: Int){
        val current = intent.extras!!.getInt(CURRENT_GAME_ACTIVITY_KEY)

        binding.backgroundImage.setImageResource(
            resources.getIdentifier(gameLogic.getCurrentImage(current), "drawable",packageName))

        if(current == ID_FIRST_GAME_SCREEN) {
            val buff = "Отлично, ${intent.extras!!.getString(USERNAME_KEY)}! Чем займемся?"
            binding.textView.text =buff

        }
        else {
            binding.textView.setText(resources.getIdentifier(
                                gameLogic.getCurrentText(current), "values", packageName))
        }

        val countButton = gameLogic.getCountButton(current)
        binding.secondButton.setText(resources.getIdentifier(
                        gameLogic.getSecondButtonText(current), "values", packageName))
        if(countButton>1){
            binding.thirdButton.setText(resources.getIdentifier(
                gameLogic.getThirdButtonText(current), "values", packageName))
        }
        else {
            binding.thirdButton.visibility = View.INVISIBLE
            binding.firstButton.visibility = View.INVISIBLE
        }
        if(countButton>2) {
            binding.firstButton.setText(resources.getIdentifier(
                gameLogic.getFirstButtonText(current), "values", packageName))
        }
        else {
            binding.firstButton.visibility = View.INVISIBLE
        }


        if(clickedButtonNumber != 0) {
            intent.putExtra(CURRENT_GAME_ACTIVITY_KEY, gameLogic.getNextIdScreen(
                                                                   current, clickedButtonNumber))
        }
    }
}