package com.example.cooking.UI.Search


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun  DisplayTextBoxes(
    onClickButton: (String) -> Unit ) {
    val categoriesList = CategoriesList()
    val colorList = ColorList()
    Column (
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        for (i in categoriesList.indices step 2) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                for (j in i until if (i + 2 <= categoriesList.size) i + 2 else categoriesList.size) {
                    if (j < colorList.size) {
                        val color = colorList[j] /*Color(android.graphics.Color.parseColor(colorList[j]))*/
                        CreateButton(color, categoriesList[j].displayName,onClickButton)
                    }
                }
            }
        }

    }
}
@Composable
fun CreateButton(color:Color, text: String,onClickButton: (String) -> Unit){
    Button(
        onClick = {onClickButton(text)},
        modifier = Modifier
            //.fillMaxWidth()
            .width(200.dp)
            .height(80.dp)
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
            fontSize = 18.sp,
            textAlign = TextAlign.Center

        )
    }
}




