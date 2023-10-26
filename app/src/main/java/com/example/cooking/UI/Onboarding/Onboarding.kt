package com.example.cooking.UI.Onboarding


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.draw.paint
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
fun OnBoardingPage() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFB8C75E))
    ) {

        Image(
            painter = painterResource(id = R.drawable.apple),
            contentDescription = "apple icon",
            modifier = Modifier
                .size(220.dp)
                .offset(240.dp, 150.dp)
                .rotate(-43f)
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
            contentDescription = "",
            modifier = Modifier
                .size(1000.dp)
                .offset(-15.dp, 200.dp)
        )
        Column(
            horizontalAlignment = Alignment.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding(50.dp)
        )
        {
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                modifier = Modifier.height(70.dp),
                text = "vegelicious",
                textAlign = TextAlign.Right,
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold


            )
            Text(
                modifier = Modifier.height(80.dp),
                text = " good for you and \n good for plant",
                textAlign = TextAlign.Right,
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal

            )
            Spacer(modifier = Modifier.height(50.dp))
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(

                    containerColor = Color.White,
                    contentColor = Color.Red,
                ),
                shape = RoundedCornerShape(35.dp),

                ) {
                Text(
                    text = "get started",
                )


            }
        }

    }
}

    @Preview
    @Composable
    fun PreviewOnBoardingPage() {
        OnBoardingPage()
    }



