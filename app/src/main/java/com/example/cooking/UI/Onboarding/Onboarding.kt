package com.example.cooking.UI.Onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cooking.R

@Composable
fun OnBoardingPage(onNavigateToAccountCreation: () -> Unit) {
    Box(
        modifier = Modifier
        .background(color = Color(0xFFB8C75E))
        .fillMaxSize(),
    ) {
        Image(
            painter = painterResource(id = R.drawable.apple),
            contentDescription = "apple icon",
            modifier = Modifier
                .size(180.dp)
                .offset(260.dp, 190.dp)
                .rotate(-45f)
        )
        Image(
            painter = painterResource(id = R.drawable.lyn),
            contentDescription = "lyn icon",
            modifier = Modifier
                .size(175.dp)
                .offset(-(50).dp, -(50).dp)
        )

        Image(
            painter = painterResource(id = R.drawable.groceryshopper),
            contentDescription = "grocery shopper graphic",
            modifier = Modifier
                .size(775.dp) // why won't this be bigger even though i increase?
                .offset(-(60).dp, 170.dp)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.TopCenter
        ) {
            Column(
                horizontalAlignment = Alignment.End,

                ) {
                Spacer(modifier = Modifier.height(70.dp))

                Text(
                    text = "vegelicious",
                    textAlign = TextAlign.Right,
                    fontSize = 45.sp,
                    fontWeight = FontWeight.Bold
                )

                //Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = " good for you and \n good for the planet",
                    textAlign = TextAlign.Right,
                    lineHeight = 24.sp,
                    fontSize = 16.sp,
                )

                Spacer(modifier = Modifier.height(90.dp))

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
    }
}


@Preview
@Composable
fun PreviewOnBoardingPage(){
    OnBoardingPage(onNavigateToAccountCreation = {})
}


