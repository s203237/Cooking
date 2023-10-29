package com.example.cooking

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.cooking.UI.AboutUsPage.AboutUsPage
import com.example.cooking.UI.AccountCreationPage.AccountCreationPage
import com.example.cooking.UI.Homepage.Homepage
import com.example.cooking.UI.Homepage.scrollableList
import com.example.cooking.UI.Onboarding.OnBoardingPage
import com.example.cooking.UI.RecipeList.RecipeList
import com.example.cooking.UI.NavBar.navigation.AppNavigation


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            // AccountCreationPage()
            //OnBoardingPage()
            //RecipeList()
            //scrollableList()

 
            AppNavigation()


        }
    }
}



