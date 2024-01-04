package com.example.cooking.UI.Homepage

//import com.example.cooking.Data.Recipe
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cooking.UI.SharedComponents.BackToTop
import com.example.cooking.UI.SharedComponents.CardFormats
import com.example.cooking.UI.SharedComponents.FavButton
import com.example.cooking.UI.SharedComponents.ImageWithFavIcon
import com.example.cooking.UI.SharedComponents.RecipeImage
import com.example.cooking.UI.SharedComponents.UppercaseHeadingMedium
import com.example.cooking.model.ListType
import com.example.cooking.model.RecipeCard
import com.example.cooking.model.RecipeCollection
import kotlin.math.min

@Composable
fun scrollableList(
    modifier: Modifier,
    dailyRecipe: RecipeCard,
    listOfCollections: List<RecipeCollection>,
    onNavigateToRecipe: (Int) -> Unit
) {

    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    val showButton by remember {
        derivedStateOf {
            listState.firstVisibleItemIndex > 0
        }
    }

    Surface {
        LazyColumn(
            modifier = Modifier.testTag("homepagescreen"),
            state = listState
        ) {
            items(listOfCollections) { collection ->
                when (collection.type) {
                    ListType.CARD -> RecipeCard()
                    ListType.HORIZONTAL -> RecipeCardRow(collection = collection, onNavigateToRecipe = onNavigateToRecipe)
                    ListType.VERTICAL -> RecipeCardList(
                        collection = collection,
                        listSize = 3,
                        onNavigateToRecipe = onNavigateToRecipe
                    )
                }
            }
            /*
            //listOfCollections.forEach { Log.v("Homepage UI", it.collectionName) }
            item {
                UppercaseHeadingMedium(heading = "daily pick")
                Spacer(Modifier.height(16.dp))
                RecipeRowItem(
                    modifier = Modifier.fillMaxWidth(),
                    recipe = dailyRecipe,
                    onNavigateToRecipe = onNavigateToRecipe
                )

            }

            items(listOfCollections) { collection ->
                RecipeCardRow(collection = collection, onNavigateToRecipe = onNavigateToRecipe)

            }


            item{
                RecipeCardRow(collection = RecipeCollection()/*listOfCollections[0]*/, onNavigateToRecipe = onNavigateToRecipe)
            }

            item {
                RecipeCardList(
                    collection = RecipeCollection()/*listOfCollections[1]*/,
                    listSize = 3,
                    onNavigateToRecipe = onNavigateToRecipe
                )
            }

            item{
                RecipeCardRow(collection = RecipeCollection()/*listOfCollections[2]*/, onNavigateToRecipe = onNavigateToRecipe)
            }

            item{
                RecipeCardRow(collection = RecipeCollection()/*listOfCollections[3]*/, onNavigateToRecipe = onNavigateToRecipe)
            }

            item {
                RecipeRowItem(
                    modifier = Modifier.fillMaxWidth(),
                    recipe = dailyRecipe,
                    onNavigateToRecipe = onNavigateToRecipe
                )

            }

            item{
                RecipeCardRow(collection = RecipeCollection()/*listOfCollections[4]*/, onNavigateToRecipe = onNavigateToRecipe)
            }

*/

        }

        AnimatedVisibility(visible = showButton, enter = fadeIn(), exit = fadeOut()) {
            BackToTop(listState, coroutineScope) { }
        }

    }
}

///////////////////////////////////////
// HOMEPAGE COMPONENTS
///////////////////////////////////////
@Composable
fun RecipeRowItem(modifier: Modifier, recipe: RecipeCard, onNavigateToRecipe: (Int) -> Unit, subtitle: String = "") {

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Card(
            modifier = modifier
        ){
            ImageWithFavIcon(
                recipeId = recipe.id,
                imageUrl = recipe.thumbnail_url,
                onNavigateToRecipe = onNavigateToRecipe,
                onFavoriteButtonClicked = {},
                cardFormat = CardFormats.SQUARE
            )
        }
        val recipeTitle = recipe.name
        println("this is the recipe title: $recipeTitle")
        Text(
            text = recipe.name,
            fontSize = 16.sp,
            modifier = Modifier
                .width(200.dp)
                .padding(
                    top = 8.dp,
                    bottom = 16.dp
                ),
            //maxLines = 1,
            //overflow = TextOverflow.Ellipsis
        )
        if(subtitle != ""){
            Text(
                text = subtitle,
                fontSize = 14.sp,
                modifier = Modifier
                    .padding(10.dp)
                    .width(200.dp),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
fun RecipeCardRow(collection: RecipeCollection, onNavigateToRecipe: (Int) -> Unit) {
    Spacer(Modifier.height(16.dp))
    UppercaseHeadingMedium(heading = collection.collectionName)
    Spacer(Modifier.height(16.dp))

    LazyRow {
        items(collection.results) { recipe ->
            //RecipeCard(recipe = recipe)
            RecipeRowItem(modifier = Modifier
                .height(200.dp)
                .width(200.dp), recipe = recipe, onNavigateToRecipe = onNavigateToRecipe
            )
            Spacer(Modifier.width(10.dp))
        }
    }
}


@Composable
fun RecipeCardList(
    collection: RecipeCollection,
    listSize: Int,
    onNavigateToRecipe: (Int) -> Unit
) {
    val recipeCards = collection.results
    Column {
        Spacer(Modifier.height(16.dp))
        UppercaseHeadingMedium(heading = collection.collectionName)
        Spacer(Modifier.height(16.dp))

        for(i in 0 until min(listSize, recipeCards.size)) {
            RecipeCardListItem(recipeCard = recipeCards[i], onNavigateToRecipe = onNavigateToRecipe)
        }
    }
}
@Composable
fun RecipeCardListItem(recipeCard: RecipeCard, onNavigateToRecipe: (Int) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            //.padding(16.dp)
            .clickable {
                onNavigateToRecipe(recipeCard.id)
            },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(0.70f),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            RecipeImage(
                recipeId = recipeCard.id,
                imageUrl = recipeCard.thumbnail_url,
                onNavigateToRecipe = onNavigateToRecipe,
                cardFormat = CardFormats.SQUARE,
                sizeFraction = 0.35f
            )
            Spacer(Modifier.width(16.dp))
            Text(
                text = recipeCard.name,
                color = MaterialTheme.colorScheme.onBackground,
                /*modifier = Modifier
                    .fillMaxWidth(0.3f)*/
            )

        }
        FavButton(0.35f)
    }
    Spacer(Modifier.height(16.dp))
}


///////////////////////////////////////
// PREVIEWS
///////////////////////////////////////
//@Preview
//@Composable
//fun PreviewscrollableList(){
//
//    val dailyRecipeCard = RecipeCard()
//    val collections = RecipeData().loadRecipeCollections()
//
//    scrollableList(
//        Modifier,
//        dailyRecipe = dailyRecipeCard,
//        listOfCollections = collections,
//        onNavigateToRecipe = {}
//    )
//
//
//}
//
//
//@Preview
//@Composable
//fun PreviewRecipeCardList() {
//    val collections = RecipeData().loadRecipeCollections()
//    RecipeCardList(collection = collections[0], listSize = 3) {}
//}
//
//@Preview
//@Composable
//fun PreviewRecipeCardListItem() {
//    val recipeCard = RecipeCard(
//        recipeId = "miso-butternut-soup",
//        title = "Miso Butternut Soup",
//        imageUrl = "https://images.immediate.co.uk/production/volatile/sites/30/2021/09/Miso-and-butternut-soup-efe9277.jpg?quality=90&webp=true&resize=600,545"
//    )
//    RecipeCardListItem(recipeCard = recipeCard, onNavigateToRecipe = {})
//}

