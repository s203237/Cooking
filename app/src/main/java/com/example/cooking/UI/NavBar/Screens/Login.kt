package com.example.cooking.UI.NavBar.Screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.example.cooking.UI.Homepage.Homepage

@Composable
fun LoginScreen() {
    Box(modifier = Modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center ){
        Text(
            text = "Login Screen",
            fontFamily = FontFamily.Serif,
            fontSize = 22.sp
        )

    }
}