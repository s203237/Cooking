package com.example.cooking.UI.AccountCreationPage
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountCreationPage() {
    Box(

        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFB8C75E))
    ) {

        Image(
            painter = painterResource(id = R.drawable.apple),
            contentDescription = "apple icon",
            modifier = Modifier
                .size(180.dp)
                .offset(180.dp, 620.dp)

        )
        Image(
            painter = painterResource(id = R.drawable.turnip),
            contentDescription = "turnip icon",
            modifier = Modifier
                .size(250.dp)
                .offset(15.dp, 550.dp)
                .rotate(5f)
        )
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(45.dp)
        ) {

            Spacer(modifier = Modifier.height(60.dp))

            Text(
                text = "Let's create an account so that you can save your favourite recipes, plan your meals and much more!",
                textAlign = TextAlign.Left,
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal
            )
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                text = "name:",
                textAlign = TextAlign.Left,
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )
            OutlinedTextField(
                value = "Please enter your name!",
                onValueChange = {},
                shape = RoundedCornerShape(40),
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxWidth(),
            )
            Text(
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                text = "e-mail:",
                textAlign = TextAlign.Left,
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )
            OutlinedTextField(
                value = "Please enter your e-mail!",
                onValueChange = {},
                shape = RoundedCornerShape(40),
                modifier = Modifier
                    .fillMaxWidth()

            )
            Spacer(modifier = Modifier.height(40.dp))
            Button(
                onClick = {},
                // Spacer(modifier = Modifier.height(50.dp))
                modifier = Modifier//.padding(horizontal = 15.dp, vertical = 60.dp)
                    .align(Alignment.End),
                colors = ButtonDefaults.buttonColors(

                    containerColor = Color.White,
                    contentColor = Color.Red,
                ),
                shape = RoundedCornerShape(40),

                ) {
                Text(
                    text = "submit",

                    )


            }
        }

    }
}

@Preview
@Composable
fun PreviewAccountCreation() { AccountCreationPage()
}