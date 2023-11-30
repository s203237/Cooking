package com.example.cooking.test

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.example.cooking.UI.Homepage.scrollableList
import org.junit.Rule
import org.junit.Test

class TestRecipeDetails {
    @get:Rule
    val composeTestRule = createComposeRule()
    // use createAndroidComposeRule<YourActivity>() if you need access to
    // an activity

    @Test
    fun getRecipeDetailsTest() {
        // Given I am on the home page
        composeTestRule.setContent {
            scrollableList( )
        }
        //I see the recipe card for miso and butternut soup
        //And I tap on the image
        composeTestRule.onNodeWithTag("homepagescreen").performClick()

        //Then I should see the info page for miso and butternut soup
        composeTestRule.onNodeWithTag("recipepage").assertIsDisplayed()

        Thread.sleep(1200000L);

    }
}