package com.example.cooking.UI.Search

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.semantics.Role.Companion.Button

@Composable
fun  DisplayTextBoxes(onNavigateToRecipieList: (String) -> Unit) {
    val categoriesList = CategoriesList()
    val colorList = ColorList()

    Column {
        for (i in categoriesList.indices step 2) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                for (j in i until if (i + 2 <= categoriesList.size) i + 2 else categoriesList.size) {
                    if (j < colorList.size) {
                        val color = Color(android.graphics.Color.parseColor(colorList[j]))
                        CreateButton(color, categoriesList[j] , onNavigateToRecipieList)
                    }
                }
            }
        }

    }
}
@Composable
fun CreateButton(color:Color, text: String , onNavigateToRecipieList: (String) -> Unit){
    val collectionname = getCollectionName(text)
    Button(
        onClick = {onNavigateToRecipieList(collectionname)},
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
            fontSize = 18.sp

        )
    }}




