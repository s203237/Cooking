package com.example.cooking.UI.AccountCreationPage
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountCreationPage(
    onNavigateToHomeScreen: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFB8C75E)),
        contentAlignment = Alignment.TopCenter
    ) {
        Column (
            modifier = Modifier
                .fillMaxWidth(0.75f)
        ) {

            Spacer(modifier = Modifier.height(70.dp))

            Text(
                text = "Let's create an account so that you can save your favourite recipes, plan your meals and much more!",
                fontSize = 16.sp,
                lineHeight = 24.sp,
                modifier = Modifier
                    .padding(
                        start = 8.dp,
                        end = 8.dp
                    )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "name:",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 8.dp)
            )
            TextField(
                value = "Please enter your name!",
                onValueChange = {},
                shape = RoundedCornerShape(60),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color(0xFFF2ECE3),
                    textColor = Color.Black
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "e-mail:",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 8.dp)
            )
            TextField(
                value = "Please enter your e-mail!",
                onValueChange = {},
                shape = RoundedCornerShape(60),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color(0xFFF2ECE3),
                    textColor = Color.Black
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
            )

            Spacer(modifier = Modifier.height(22.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Button(
                    onClick = onNavigateToHomeScreen,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFF2ECE3),
                        contentColor = Color.Red
                    )
                ) {
                    Text(
                        text = "submit",
                        fontSize = 16.sp
                    )
                }
            }
            Box(){
                Image(
                    painter = painterResource(id = R.drawable.apple),
                    contentDescription ="apple vector graphic",
                    modifier = Modifier
                        .size(180.dp)
                        .offset(110.dp, 75.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.turnip),
                    contentDescription ="turnip vector graphic",
                    modifier = Modifier
                        .size(230.dp)
                        .offset((-50).dp, 10.dp)
                )
            }

        }
    }
}

@Preview
@Composable
fun PreviewAccountCreation() { AccountCreationPage(onNavigateToHomeScreen = {})
}