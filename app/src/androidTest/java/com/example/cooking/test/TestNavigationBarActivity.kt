package com.example.cooking.test

import android.view.KeyEvent
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performKeyPress
import androidx.compose.ui.test.performTextInput
import com.example.cooking.UI.Search.SearchBar
import org.junit.Rule
import org.junit.Test

class TestNavigationBarActivity {
    @get:Rule
    val composeTestRule = createComposeRule()
    // use createAndroidComposeRule<YourActivity>() if you need access to
    // an activity

    @Test
    fun myTest() {
        // Given I am on the homepage
        composeTestRule.setContent {
            SearchBar(onNavigateToRecipe = {})

        }
        //When I fill search box with tofu
        composeTestRule.onNodeWithTag("searchtext").performTextInput("tofu")
        //And I click enter
        composeTestRule.onNodeWithTag("searchtext").performKeyPress(
            androidx.compose.ui.input.key.KeyEvent(
                KeyEvent(
                    KeyEvent.ACTION_DOWN,
                    KeyEvent.KEYCODE_ENTER
                )
            )
        )
        //Then I should see a list of tofu recipes
        composeTestRule.onNodeWithText("Recipe List").assertIsDisplayed()

        Thread.sleep(1200000L);

    }
}