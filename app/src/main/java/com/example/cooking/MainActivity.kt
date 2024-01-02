package com.example.cooking

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.cooking.UI.NavBar.navigation.AppNavigation
import com.example.cooking.UI.theme.CookingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DependencyProvider.initialize(this)
        setContent {

            CookingTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation()
                    //DisplayRecipeScreen(recipeId = "party-vol-au-vents")
                    //ListAllRecipesScreen(collectionName = "party", onNavigateToRecipe = {})
                }
            }
        }
    }
}


