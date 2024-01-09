package com.example.cooking.data.remote

data class FetchParameters(
    val id: String,
    val size: Int = 10,
    val tag: String = "vegetarian"
)
