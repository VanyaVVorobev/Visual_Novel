package com.example.visualnovel

import android.content.Context
import org.json.JSONArray
import org.json.JSONTokener

class ActivityGameLogic(context: Context) {
    val myJson = context.resources.assets.open("myjson.json").bufferedReader().use { it.readText() }
    val jsonArray = JSONTokener(myJson).nextValue() as JSONArray

    fun getCurrentImage(current: Int): String {
        val jsonObject = jsonArray.getJSONObject(current)
        return jsonObject.getString("image")
    }

    fun  getCurrentText(current: Int): String {
        val jsonObject = jsonArray.getJSONObject(current)
        return jsonObject.getString("text")
    }

    fun getCountButton(current: Int):Int {
        return jsonArray.getJSONObject(current).getJSONArray("buttons").length()
    }

    fun getSecondButtonText(current: Int):String {
        return jsonArray.getJSONObject(current).getJSONArray("buttons").getString(1)
    }
    fun getThirdButtonText(current: Int):String {
        return jsonArray.getJSONObject(current).getJSONArray("buttons").getString(2)
    }
    fun getFirstButtonText(current: Int):String {
        return jsonArray.getJSONObject(current).getJSONArray("buttons").getString(1)
    }

    fun getNextIdScreen(current: Int, clickedButtonNumber: Int): Int {
        val jsonObject = jsonArray.getJSONObject(current)
        if(clickedButtonNumber == 1) {
            return jsonObject.getJSONArray("firstButton").getInt(2)
        }
        if(clickedButtonNumber == 2) {
            return jsonObject.getJSONArray("secondButton").getInt(2)
        }
        if(clickedButtonNumber == 3) {
            return jsonObject.getJSONArray("thirdButton").getInt(2)
        }
        return 0
    }


}