package com.example.cooking.UI.RecipePage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cooking.R
import com.example.cooking.UI.SharedComponents.CustomHeading1
import com.example.cooking.UI.SharedComponents.CustomHeading2
import com.example.cooking.UI.SharedComponents.CustomTitle
import com.example.cooking.data.RecipeData
import com.example.cooking.model.Component
import com.example.cooking.model.Recipe
import kotlin.math.roundToInt

@Composable
fun InfoTab(recipe: Recipe) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Box {
            Image(
                painter = painterResource(id = R.drawable.tab_right),
                contentDescription = "Right tab to view recipe information",
                modifier = Modifier
                    .fillMaxWidth(),
                alignment = Alignment.CenterEnd,
            )
            Image(
                painter = painterResource(id = R.drawable.tab_left),
                contentDescription = "Left tab to view recipe information",
                alignment = Alignment.CenterStart,
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color(0xFFF2ECE3))
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 16.dp
                )
        ) {
            DisplayRecipeInfo(recipe = recipe)
            CustomTitle(title = recipe.name, textAlign = TextAlign.Center)

            val headingText = if(recipe.credits.isNotEmpty()){
                recipe.credits[0].name
            }else{
                "Default Name"
            }
            CustomHeading2(heading = headingText, textAlign = TextAlign.Center)
            CustomHeading1(heading = "description")
            Text(
                text = recipe.description,
                fontSize = 16.sp,
                textAlign = TextAlign.Justify
            )

            CustomHeading1(heading = "ingredients")

            val ingrList = if(recipe.sections.isNotEmpty()){
                recipe.sections[0].components
            }else{
                emptyList()
            }
            BulletList(list = ingrList)
        }
    }
}
@Composable
private fun DisplayRecipeInfo(recipe: Recipe) {
    Column(
        modifier = Modifier
            .padding(
                top = 16.dp,
                start = 16.dp,
                end = 16.dp
            )
    ) {
       // val prepTime =  formatTime(recipe.timeToCook.prepTime)
       // val cookingTime = formatTime(recipe.timeToCook.cookTime)

        InfoRowWithIcons(
            icon1 = painterResource(id = R.drawable.outline_timer_24),
            infoType1 = "PREP", infoVal1 = recipe.prep_time_minutes.toString(),
            icon2 = painterResource(id = R.drawable.outline_local_fire_department_24),
            infoType2 = "COOK", infoVal2 = recipe.cook_time_minutes.toString()
        )

        val diff = recipe.difficulty
        val serv = recipe.num_servings.toString()
        InfoRowWithIcons(
            icon1 = painterResource(id = R.drawable.outline_thermostat_24),
            infoType1 = "DIFFICULTY", infoVal1 = diff,
            icon2 = painterResource(id = R.drawable.outline_groups_24),
            infoType2 = "SERVING SIZE", infoVal2 = serv
        )

        DisplayRating(recipe.user_ratings.score);
    }
}
@Composable
private fun InfoRowWithIcons(icon1: Painter, infoType1: String, infoVal1: String, icon2: Painter? = null, infoType2: String? = null, infoVal2: String? = null) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ){
        Icon(
            icon1,
            contentDescription = "$infoType1 icon",
        )
        Text(
            text =  "$infoType1: $infoVal1",
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .padding(start = 16.dp)
        )

        if(icon2 != null && infoType2 != null && infoVal2 != null) {
            Icon(
                icon2,
                contentDescription = "$infoType2 icon",
            )
            Text(
                text = "$infoType2: $infoVal2",
                modifier = Modifier.padding(start = 16.dp)
            )
        }
    }
}

private fun formatTime(minutes: Int): String {
    val formattedTime: String = if(minutes < 2) {
        "$minutes min"
    } else if (minutes < 60) {
        "$minutes mins"
    } else {
        val hrs = minutes / 60
        val min = minutes % 60
        val formattedMin = if (min < 10) "0$min" else min.toString()
        "$hrs hr $formattedMin min"
    }
    return formattedTime
}
@Composable
private fun DisplayRating(rating: Float) {
    println("Rating: " + rating)
    val starCount = 5
    val filledStar: Painter = painterResource(id = R.drawable.baseline_star_24)
    val halfStar: Painter = painterResource(id = R.drawable.baseline_star_half_24)
    val borderStar: Painter = painterResource(id = R.drawable.baseline_star_border_24)

    //Scale rating(0to1) to fit five stars with halfstars
    val scaledScore = (rating*starCount*2).roundToInt()/2f
    val fullStars = scaledScore.toInt()
    val halfStars = if(scaledScore - fullStars >= 0.5) 1 else 0
    val emptyStars = starCount - fullStars - halfStars

    Row( modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        //Display full stars
        for(i in 1..fullStars){
            Icon(
                painter = filledStar,
                contentDescription = "rating star"
            )
        }
        //Display half stars
        if(halfStars > 0){
            Icon(
                painter = halfStar,
                contentDescription = "rating star"
            )
        }
        //Display empty stars
        for(i in 1..emptyStars){
            Icon(
                painter = borderStar,
                contentDescription = "rating star"
            )
        }
    }
}

@Composable
private fun BulletList(list: List<Component>) {
    list.forEach { item ->
        Text(text =  "• ${item.raw_text}",
            fontSize = 16.sp,
        )
    }
}

@Preview
@Composable
fun PreviewInfoTab() {
    val recipeList = RecipeData().loadRecipes()
    InfoTab(recipe = recipeList[2])
}