package com.example.cooking.test


import androidx.compose.ui.input.key.KeyEvent
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performKeyPress
import androidx.compose.ui.test.performTextInput
import com.example.cooking.UI.Search.SearchBar
import org.junit.Rule
import org.junit.Test

class TestSearchActivity {
    @get:Rule
    val composeTestRule = createComposeRule()
    // use createAndroidComposeRule<YourActivity>() if you need access to
    // an activity

   /* @Test
    fun searchTest() {
        // Given I am on the search page
        composeTestRule.setContent {
            SearchBar(onSearch = {})
        }
        //When I fill search box with tofu
        composeTestRule.onNodeWithTag("searchtext").performTextInput("tofu")
        //And I click enter
        composeTestRule.onNodeWithTag("searchtext").performKeyPress(
            KeyEvent(
                android.view.KeyEvent(
                    android.view.KeyEvent.ACTION_DOWN,
                    android.view.KeyEvent.KEYCODE_ENTER
                )
            )
        )
        //Then I should see a list of tofu recipes
        composeTestRule.waitUntil(120000, {
            composeTestRule.onAllNodesWithText("Crispy tofu").fetchSemanticsNodes().size == 1
        })
        composeTestRule.onNodeWithText("Crispy tofu").assertIsDisplayed()



    }*/
}