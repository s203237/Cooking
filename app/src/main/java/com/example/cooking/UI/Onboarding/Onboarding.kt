package com.example.cooking.UI.Onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OnBoardingPage(onNavigateToAccountCreation: () -> Unit) {
        Column(
            horizontalAlignment = Alignment.End,
            modifier = Modifier
                .background(color = Color(0xFFB8C75E))
                .fillMaxSize()
        ){
            Text(
               modifier = Modifier.height(70.dp) ,
                text = "vegelicious",
                textAlign = TextAlign.Right,
                fontSize = 45.sp,
                fontWeight = FontWeight.Bold


            )
            Text(
                modifier = Modifier.height(80.dp),
                text = " good for you and \n good for plant",
                textAlign = TextAlign.Right,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold

            )

            Button(
                onClick = onNavigateToAccountCreation,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Red
                )
            ) {
                Text(text = "get started")
            }
        }
}


@Preview
@Composable
fun PreviewOnBoardingPage(){
    OnBoardingPage(onNavigateToAccountCreation = {})
}


