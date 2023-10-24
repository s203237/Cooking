package com.example.cooking.UI.Search
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchPage() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(color = Color(0xffF2ECE3))
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(40.dp)
    ) {
        Text(
            modifier = Modifier.height(55.dp),
            text = "vegelicious",
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold
        )

        OutlinedTextField(
            value = "What would you like to cook?",
            onValueChange = {},
            shape = RoundedCornerShape(40)
        )
        Column() {
            Row() {
                CreateButton(color = Color(0xffB8C75E), text = "Dinner")
                CreateButton(color = Color(0xffFF614B), text = "Dessert")
            }
            Row() {
                CreateButton(color = Color(0xff93BBCF), text = "Sides")
                CreateButton(color = Color(0xffF3B144), text = "Breakfast")
            }
            Row() {
                CreateButton(color = Color(0xffF3B144), text = "Healthy")
                CreateButton(color = Color(0xffB8C75E), text = "Easy")
            }
            Row() {
                CreateButton(color = Color(0xffFF614B), text = "Salad")
                CreateButton(color = Color(0xff93BBCF), text = "Pasta")
            }
        }
        Text(
            modifier = Modifier
                .align(Alignment.Start).padding(10.dp, 10.dp),
            text = "Cooking Time",
            fontSize = 25.sp,
            fontWeight = FontWeight.Normal
        )
        Column {
            Row() {
                CreateButton(color = Color(0xff93BBCF), text = "Under 30 Min")
                CreateButton(color = Color(0xffFF614B), text = "Under 45 Min")
            }

            Row() {
                CreateButton(color = Color(0xffB8C75E), text = "Under 1 hour")
                CreateButton(color = Color(0xffF3B144), text = "1 + hours")

            }
        }
    }
}
@Composable
fun CreateButton(color:Color, text: String){
    Button(
        onClick = {},
       modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 10.dp),

        colors = ButtonDefaults.buttonColors(
            containerColor = color,
            contentColor = Color.Black,
        ),
        shape = RoundedCornerShape(40),

        ) {
        Text(
            text = text,

            )

    }

}

@Preview
@Composable
fun PreviewSearchPage(){
    SearchPage()
}