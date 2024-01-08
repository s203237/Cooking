package com.example.cooking.UI.Profile

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

@Composable
fun HelpPage() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color(0xFFB8C75E))
    ){
        Image(
            painter = painterResource(id = R.drawable.apple),
            contentDescription = "apple icon",
            modifier = Modifier
                .size(230.dp)
                .offset(250.dp, 150.dp)
                .rotate(-45f)
        )
        Image(
            painter = painterResource(id = R.drawable.lyn),
            contentDescription = "lyn icon",
            modifier = Modifier
                .size(175.dp)
                .offset(-(50).dp, -(50).dp)
        )
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(35.dp)
            )
        {
            Text(
                modifier = Modifier.height(30.dp),
                text = "FAQ",
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier.height(30.dp),
                text = "Can I delete a recipe?",
                fontSize = 25.sp,
                fontWeight = FontWeight.Normal
            )
            Text(
                text = "Yes. Under Favorite you can remove any unwanted recipe by clicking on the heart icon." +
                        "Be aware that deleted recipes cannot be restored.",
                fontSize = 18.sp,
                fontWeight = FontWeight.Light
            )
            Text(
                modifier = Modifier.height(30.dp),
                text = "What kind of recipes can I find on Vegelicious?",
                fontSize = 25.sp,
                fontWeight = FontWeight.Normal
            )
            Text(
                text = "Vegelicious is an app that focuses on Vegetarian recipes" +
                        "Use our search function to open up a world of delicious recipes",
                fontSize = 18.sp,
                fontWeight = FontWeight.Light
            )
            Text(
                modifier = Modifier.height(40.dp),
                text = "What if I have allergies?",
                fontSize = 25.sp,
                fontWeight = FontWeight.Normal
            )
            Text(
                text = "We recommend that you always consult the ingredient list, before starting cooking." +
                        "The ingredient lists will show all components in the recipe.",
                fontSize = 18.sp,
                fontWeight = FontWeight.Light
            )

            Text(
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(0.dp, 10.dp, 0.dp, 0.dp),
                text = "How to get started",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Vegelicious is a visual search engine, where you can find ideas and inspiration for vegetarian recipes." +
                        " Sign up with a username and email." +
                        "Now all you have to do is explore delicious recipes and save your favorite ones." +
                        "View your saved recipes under Favorite",
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal
            )
            Text(
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(0.dp, 10.dp, 0.dp, 0.dp),
                text = "Contant Us",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Have something you'd like to let us know?" +
                        "Whether you have a comment on a recipe or an idea, we love to hear from you:" +
                        "RandomEmail@vegelicious.com",
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal
            )
        }
    }
}
@Preview
@Composable
fun PreviewHelpPage(){
    HelpPage()
}






