package com.example.cooking.data.remote

data class FetchParameters(
    val id: String,
    val size: Int = 1,
    val tag: String = "vegetarian"
)
