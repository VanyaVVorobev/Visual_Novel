package com.example.visualnovel.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.visualnovel.databinding.ActivityGameBinding
import com.example.visualnovel.model.ActivityGameLogic


class GameActivity: AppCompatActivity() {
    private lateinit var binding: ActivityGameBinding
    private lateinit var gameLogic: ActivityGameLogic
    private var current = ID_FIRST_GAME_SCREEN
    private var buttons: MutableList<Button> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val context = this
        gameLogic = ActivityGameLogic(context)

        buttons.add(binding.secondButton)
        buttons[0].setOnClickListener { onClickButton(2) }
        buttons.add(binding.thirdButton)
        buttons[1].setOnClickListener { onClickButton(3) }
        buttons.add(binding.firstButton)
        buttons[2].setOnClickListener { onClickButton(1) }

        updateScreen()
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
            var buff = binding.textView.text.toString()
            val regex = Regex("<.*>")
            val matchResult = regex.find(buff)
            if(matchResult != null) {
                buff = buff.replaceRange(matchResult.range.first,
                    matchResult.range.last+1, intent.getStringExtra(USERNAME_KEY).toString())
            }
            binding.textView.text = buff
        }
        else {
            binding.textView.text=gameLogic.getCurrentText(current)
        }
    }

    private fun updateButtons() {
        val countButtons = gameLogic.getCountButton(current)
        for(i in 1..buttons.size) {
            if (countButtons >= i) {
                buttons[i - 1].text = gameLogic.getButtonText(current, i)
            } else {
                buttons[i - 1].visibility = View.INVISIBLE
            }
        }
    }

    private fun updateCurrent(clickedButtonNumber: Int) = gameLogic.getNextIdScreen(current, clickedButtonNumber)
}