package com.example.cooking.UI.Onboarding


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
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
        Column(
            horizontalAlignment = Alignment.End,
            modifier = Modifier
                .paint(painterResource(id = R.drawable.onboardingpage))
                .fillMaxWidth()
               // .fillMaxHeight()
                .padding(55.dp))
        {
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
                onClick = {},
                modifier = Modifier
                    //.height(40.dp)
                    .padding(0.dp,30.dp,0.dp,0.dp
                    ),
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


@Preview
@Composable
fun PreviewOnBoardingPage(){
    OnBoardingPage()
}


