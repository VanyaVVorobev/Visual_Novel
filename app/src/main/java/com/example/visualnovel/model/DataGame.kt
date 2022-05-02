package com.example.visualnovel.model

import kotlinx.serialization.Serializable

@Serializable
data class DataGame(val image: String, val countButtons: Int, val text: String, val buttons: List<MyButton>)
@Serializable
data class MyButton(val text: String, val nextScreen: Int)
