package com.example.visualnovel.model

import android.content.Context
import android.util.Log
import com.example.visualnovel.view.JSON_FILE_NAME
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class ActivityGameLogic(context: Context) {
    private val dataGame: List<DataGame>

    init {
        val myJsonStr = context.resources.assets.open(
            JSON_FILE_NAME).bufferedReader().use { it.readText() }
        dataGame= Json.decodeFromString(myJsonStr)
    }

    fun getCurrentImage(current: Int) = dataGame[current].image
    fun  getCurrentText(current: Int) = dataGame[current].text
    fun getCountButton(current: Int) = dataGame[current].countButtons
    fun getButtonText(current: Int, buttonsNumber: Int) = dataGame[current].buttons[buttonsNumber - 1].text


    fun getNextIdScreen(current: Int, clickedButtonNumber: Int): Int {
        if(clickedButtonNumber == 1) {
            return dataGame[current].buttons[2].nextScreen
        }
        if(clickedButtonNumber == 2) {
            return dataGame[current].buttons[0].nextScreen
        }
        return dataGame[current].buttons[1].nextScreen
    }
}