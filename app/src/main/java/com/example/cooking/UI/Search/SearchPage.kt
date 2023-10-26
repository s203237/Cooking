package com.example.cooking.UI.Search
import android.app.Activity
import android.os.Build
import android.widget.ImageButton
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cooking.R
import com.example.cooking.UI.Homepage.Homepage
import com.example.cooking.UI.SharedComponents.NavigationInComposeTheme


@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun SearchPage() {
    Column(
        modifier = Modifier
            .background(color = Color(0xffF2ECE3))
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(30.dp)
    ) {
Row(){
    IconButton(onClick = { /*BackHomePage()*/ }) {
        Icon(painter = painterResource(id = R.drawable.arrow_back),
            contentDescription ="back to homepage"
        )
    }
    Spacer(modifier = Modifier.width(30.dp))
        Text(
            modifier = Modifier.height(55.dp),
            text = "vegelicious",
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold
            
        )}

        OutlinedTextField(
            value = "What would you like to cook?",
            onValueChange = {},
            shape = RoundedCornerShape(40)
        )
        Column() {
            FlowRow( maxItemsInEachRow = 2) {
                Box( modifier =Modifier.weight(1f)){
                    CreateButton(color = Color(0xffB8C75E), text = "Dinner")}
                Box( modifier =Modifier.weight(1f)){
                    CreateButton(color = Color(0xffFF614B), text = "   Dessert  ")
                }
                Box( modifier =Modifier.weight(1f)){
                CreateButton(color = Color(0xff93BBCF), text = "Sides")}
                Box( modifier =Modifier.weight(1f)){
                CreateButton(color = Color(0xffF3B144), text = "Breakfast")}
                Box( modifier =Modifier.weight(1f)){
                CreateButton(color = Color(0xffF3B144), text = "Healthy")}
                Box( modifier =Modifier.weight(1f)){
                CreateButton(color = Color(0xffB8C75E), text = "Easy")}
                Box( modifier =Modifier.weight(1f)){
                CreateButton(color = Color(0xffFF614B), text = "Salad")}
                Box( modifier =Modifier.weight(1f)){
                CreateButton(color = Color(0xff93BBCF), text = "Pasta")}
            }


        }
        Text(
            modifier = Modifier
                .align(Alignment.Start)
                .padding(10.dp, 10.dp),
            text = "Cooking Time",
            fontSize = 25.sp,
            fontWeight = FontWeight.Normal
        )
        Column {
            FlowRow(modifier = Modifier.fillMaxWidth(), maxItemsInEachRow = 2) {
                Box( modifier =Modifier.weight(1f)){
                CreateButton(color = Color(0xff93BBCF), text = "Under 30 Min")}
                Box( modifier =Modifier.weight(1f)){
                CreateButton(color = Color(0xffFF614B), text = "Under 45 Min")}
                Box( modifier =Modifier.weight(1f)){
                CreateButton(color = Color(0xffB8C75E), text = "Under 1 hour")}
                Box( modifier =Modifier.weight(1f)){
                CreateButton(color = Color(0xffF3B144), text = "1 + hours")}

            }
        }
    }
}
@Composable
fun BackHomePage()  {
    NavigationInComposeTheme {
        Surface {
            Homepage()
        }
    }
}
@Composable
fun CreateButton(color:Color, text: String){
    Button(
        onClick = {},
       modifier = Modifier
           .fillMaxWidth()
           .padding(horizontal = 10.dp, vertical = 10.dp)
           ,

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