package com.example.cooking.UI.AccountCreationPage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cooking.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountCreationPage(){
Column(
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.Start,
    modifier = Modifier
        .background(color = Color.LightGray)
        .fillMaxWidth()
        .padding(50.dp)
    //modifier = Modifier.paint(painterResource(id = R.drawable.pear)).fillMaxWidth(),


){
    Text(
        //modifier = Modifier.padding(40.dp,60.dp,20.dp,5.dp),
        text = "Let's create an account so that \n you can save your favourite recipes,\n plan your meals and much more!",
        textAlign = TextAlign.Left,
        fontSize = 17.sp,
        fontWeight = FontWeight.Normal
    )
    Text(
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                text ="name:",
                textAlign = TextAlign.Left,
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )
    OutlinedTextField(value = "Please enter your name!", onValueChange ={},shape = RoundedCornerShape(40) )
    Text(
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                text ="e-mail:",
                textAlign = TextAlign.Left,
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )
    OutlinedTextField(value = "Please enter your e-mail!", onValueChange ={},shape = RoundedCornerShape(40) )

    Button(
        onClick = {},
       // Spacer(modifier = Modifier.height(50.dp))
        modifier = Modifier.padding(horizontal = 10.dp, vertical = 50.dp).align(Alignment.End),
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

//@Preview
//@Composable
//fun PreviewAccountCreation() { AccountCreationPage()
}

