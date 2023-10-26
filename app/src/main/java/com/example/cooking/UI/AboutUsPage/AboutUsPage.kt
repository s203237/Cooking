package com.example.cooking.UI.AboutUsPage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cooking.R
import com.example.cooking.R.drawable.apple

@Composable
fun AboutUsPage() {
    Box (

        modifier= Modifier
            .fillMaxSize()
            .background(color = Color(0xFFB8C75E))
    ){

        Image(
            painter = painterResource(id = apple),
            contentDescription ="apple icon",
            modifier = Modifier
                .size(230.dp)
                .offset(250.dp,150.dp)
                .rotate(-45f)
            )
        Image(
            painter = painterResource(id = R.drawable.lyn),
            contentDescription ="lyn icon",
            modifier = Modifier
                .size(175.dp)
                .offset(-(50).dp,-(50).dp)
        )
        Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(35.dp)
    )
    {
        Text(
            modifier = Modifier.height(60.dp),
            text = "vegelicious",
            fontSize = 45.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = Modifier.height(40.dp),
            text = "About us",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Welcome to Vegelicious, your " +
                    "ultimate destination for exploring the wonderful world" +
                    " of plant-based cuisine! At Vegelicious, we're on a mission" +
                    " to make a healthy and sustainable lifestyle as easy " +
                    "and delicious as possible.",
            fontSize = 21.sp,
            fontWeight = FontWeight.Normal
        )
        Text(
            modifier = Modifier
                .align(Alignment.Start)
                .padding(0.dp, 20.dp, 0.dp, 0.dp),
            text = "Our Story",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Vegelicious was born out of a shared passion for nutritious," +
                    " planet-friendly food. We believe that eating more vegetables " +
                    "and embracing a vegetarian lifestyle is not only good for your health" +
                    " but also for the environment. Our journey began in a small kitchen " +
                    "with a vision to create an app that inspires and empowers people " +
                    "to make mindful food choices.",
            fontSize = 21.sp,
            fontWeight = FontWeight.Normal
        )
        Button(
            onClick = {},
            // Spacer(modifier = Modifier.height(50.dp))
            modifier = Modifier
                .padding(horizontal = 35.dp, vertical = 45.dp)
                .align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(

                containerColor = Color.White,
                contentColor = Color.Red,
            ),
            shape = RoundedCornerShape(40),

            ) {
            Text(
                text = "Our Privacy Policy",

                )

        }
    }
  }
}
@Preview
@Composable
fun PreviewAboutUsPage(){
    AboutUsPage()
}