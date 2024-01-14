package com.example.cooking.UI.Homepage

//import com.example.cooking.Data.Recipe
import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.Color
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


@Composable
fun scrollableList(
    modifier: Modifier,
    dailyRecipe: RecipeCard,
    listOfCollections: List<RecipeCollection>,
    onFavoriteButtonClicked: (RecipeCard) -> Unit,
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
            //modifier = modifier,
            state = listState
        ) {
            item {
                DailyCard(
                    modifier = modifier,
                    dailyRecipe = dailyRecipe,
                    onNavigateToRecipe = onNavigateToRecipe,
                    onFavoriteButtonClicked = onFavoriteButtonClicked
                )
            }

            items(listOfCollections) { collection ->
                when (collection.type) {
                    ListType.CARD -> SingleCard(
                        title = collection.collectionName,
                        recipeCard = collection.results[0],
                        onNavigateToRecipe = onNavigateToRecipe,
                        onFavoriteButtonClicked = onFavoriteButtonClicked,
                        modifier = modifier
                    )
                    ListType.HORIZONTAL -> RecipeCardRow(
                        collection = collection,
                        onNavigateToRecipe = onNavigateToRecipe,
                        onFavoriteButtonClicked = onFavoriteButtonClicked

                    )
                    ListType.VERTICAL -> RecipeCardList(
                        collection = collection,
                        onNavigateToRecipe = onNavigateToRecipe,
                        onFavoriteButtonClicked = onFavoriteButtonClicked,
                        modifier = modifier,

                    )
                }
            }
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
fun DailyCard(
    modifier: Modifier,
    dailyRecipe: RecipeCard,
    onNavigateToRecipe: (Int) -> Unit,
    onFavoriteButtonClicked: (RecipeCard) -> Unit,
) {
    ImageWithFavIcon(
        recipeCard = dailyRecipe,
        onNavigateToRecipe = onNavigateToRecipe,
        onFavoriteButtonClicked = onFavoriteButtonClicked,
        cardFormat = CardFormats.SQUARE,
    )
    Column (modifier = modifier) {
        Spacer(Modifier.height(16.dp))
        UppercaseHeadingMedium(heading = "daily pick")
        Spacer(Modifier.height(8.dp))
        Text(
            text = dailyRecipe.name,
            fontSize = 22.sp,
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(Modifier.height(16.dp))
    }
}
@Composable
fun SingleCard(
    title: String,
    recipeCard: RecipeCard,
    onNavigateToRecipe: (Int) -> Unit,
    onFavoriteButtonClicked: (RecipeCard) -> Unit,
    modifier: Modifier
) {
    Column(modifier = modifier) {
        Spacer(Modifier.height(16.dp))
        UppercaseHeadingMedium(heading = title)
        Spacer(Modifier.height(16.dp))
        RowItem(
            modifier = Modifier.fillMaxWidth(),
            recipeCard = recipeCard,
            onNavigateToRecipe = onNavigateToRecipe,
            onFavoriteButtonClicked = onFavoriteButtonClicked
        )
    }
}

@Composable
fun RecipeCardRow(
    collection: RecipeCollection,
    onNavigateToRecipe: (Int) -> Unit,
    onFavoriteButtonClicked: (RecipeCard) -> Unit
) {
    Column(
        modifier = Modifier
            .background(color = Color(0xFFF2ECE3))
            .padding(start = 16.dp)
    ) {
        Spacer(Modifier.height(16.dp))
        UppercaseHeadingMedium(heading = collection.collectionName)
        Spacer(Modifier.height(16.dp))

        LazyRow {
            items(collection.results) { recipe ->
                //RecipeCard(recipe = recipe)
                RowItem(
                    modifier = Modifier
                        //.height(200.dp)
                        .width(200.dp),
                    recipeCard = recipe,
                    onNavigateToRecipe = onNavigateToRecipe,
                    onFavoriteButtonClicked = onFavoriteButtonClicked
                )

                Log.v("Homepage Row", "recipeId: $recipe.recipeId")
                Spacer(Modifier.width(10.dp))
            }
        }
    }
}
@Composable
fun RowItem(
    modifier: Modifier,
    recipeCard: RecipeCard,
    onNavigateToRecipe: (Int) -> Unit,
    onFavoriteButtonClicked: (RecipeCard) -> Unit,
    subtitle: String = ""
) {
    Column(
        modifier = modifier
        //modifier = Modifier.fillMaxWidth()
    ) {
        Card(
            modifier = Modifier.fillMaxWidth()
            //modifier = modifier
        ){
            ImageWithFavIcon(
                recipeCard = recipeCard,
                onNavigateToRecipe = onNavigateToRecipe,
                onFavoriteButtonClicked = onFavoriteButtonClicked,
                cardFormat = CardFormats.SQUARE
            )
            Log.v("HP RecipeId", recipeCard.id.toString())
        }
        val recipeTitle = recipeCard.name
        println("this is the recipe title: $recipeTitle")
        Text(
            text = recipeCard.name,
            fontSize = 16.sp,
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .padding(
                    start = 4.dp,
                    top = 8.dp,
                    bottom = 16.dp
                ),
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
fun RecipeCardList(
    collection: RecipeCollection,
    onNavigateToRecipe: (Int) -> Unit,
    onFavoriteButtonClicked: (RecipeCard) -> Unit,
    modifier: Modifier
) {
    val recipeCards = collection.results
    Column (modifier = modifier) {
        Spacer(Modifier.height(16.dp))
        UppercaseHeadingMedium(heading = collection.collectionName)
        Spacer(Modifier.height(16.dp))

        for(card in recipeCards) {
            RecipeCardListItem(
                recipeCard = card,
                onNavigateToRecipe = onNavigateToRecipe,
                onFavoriteButtonClicked = onFavoriteButtonClicked
            )
        }
    }
}
@Composable
fun RecipeCardListItem(
    recipeCard: RecipeCard,
    onNavigateToRecipe: (Int) -> Unit,
    onFavoriteButtonClicked: (RecipeCard) -> Unit
) {
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
            )

        }
        FavButton(
            sizeFraction = 0.35f,
            recipeCard = recipeCard,
            isFavorite = recipeCard.isFavorite,
            onFavoriteButtonClicked = { onFavoriteButtonClicked(recipeCard) }
        )

    }
    Spacer(Modifier.height(16.dp))
}


///////////////////////////////////////
// PREVIEWS
///////////////////////////////////////
/*@Preview
@Composable
fun PreviewscrollableList(){

    val dailyRecipeCard = RecipeCard()
    val collections = RecipeData().loadRecipeCollections()

    scrollableList(
        Modifier,
        dailyRecipe = dailyRecipeCard,
        listOfCollections = collections,
        onNavigateToRecipe = {},
        onFavoriteButtonClicked = {}
    )

}
@Preview
@Composable
fun PreviewRecipeCardList() {
    val collections = RecipeData().loadRecipeCollections()
    RecipeCardList(collection = collections[0], listSize = 3, {}, modifier = Modifier.padding (start = 16.dp, end = 16.dp))
}
@Preview
@Composable
fun PreviewRecipeCardListItem() {
    val recipeCard = RecipeCard(
        recipeId = "miso-butternut-soup",
        title = "Miso Butternut Soup",
        imageUrl = "https://images.immediate.co.uk/production/volatile/sites/30/2021/09/Miso-and-butternut-soup-efe9277.jpg?quality=90&webp=true&resize=600,545"
    )
    RecipeCardListItem(recipeCard = recipeCard, onNavigateToRecipe = {})
}

*/