package com.example.cooking.test

import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.rememberNavController
import com.example.cooking.UI.Homepage.scrollableList
import com.example.cooking.model.RecipeCard
import org.junit.Rule
import org.junit.Test

class TestRecipePage {
    @get:Rule
    val composeTestRule = createComposeRule()

    // use createAndroidComposeRule<YourActivity>() if you need access to
    // an activity

    @Test
    fun getRecipeDetailsTest() {
        // Given I am on the home page
        var id = 0
        composeTestRule.setContent {
            val navController= rememberNavController()
            scrollableList(
                modifier = Modifier,
                RecipeCard(0,"test","test"),
                emptyList(),
                onNavigateToRecipe = { recipeId ->
                id = recipeId
            })

        }
        composeTestRule.onNodeWithText("test").assertIsDisplayed()
        composeTestRule.onNodeWithTag("itemImage").performClick()
        assert(id == 0)

    }
}