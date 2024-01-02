package com.example.cooking.test

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import com.example.cooking.UI.Homepage.HomepageScreen
import org.junit.Rule
import org.junit.Test

class TestHomePage {
    @get:Rule
    val composeTestRule = createComposeRule()
    // use createAndroidComposeRule<YourActivity>() if you need access to
    // an activity

    @Test
    fun getRecipeDetailsTest() {
        // Given I am on the home page
        composeTestRule.setContent {
            HomepageScreen(onNavigateToRecipe={})
        }
        composeTestRule.waitUntil(120000, {
            composeTestRule.onAllNodesWithTag("homepagescreen").fetchSemanticsNodes().size == 1
        })

    }
}