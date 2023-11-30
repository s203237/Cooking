package com.example.cooking

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cooking.UI.Homepage.HomePageViewModel
import com.example.cooking.model.RecipeCard
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.junit.Test
import androidx.lifecycle.viewModelScope
import org.junit.Assert.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals

class MOCKAPITest {

    suspend fun getDataAPI(): List<RecipeCard>{
        val recipeCards = DependencyProvider.recipeCardRepo.fetchData("High-protein-vegan-meals")
        return recipeCards
    }

    @Test
    fun MockAPI_Results() = runTest{

        val recipeCards = getDataAPI()

        assertEquals("veggie-protein-chilli", recipeCards.get(0).recipeId)
        assertEquals("Veggie protein chilli", recipeCards.get(0).title)
        assertEquals("https://images.immediate.co.uk/production/volatile/sites/30/2020/08/protein-veggie-chilli-6395abf.jpg", recipeCards.get(0).imageUrl)
    }
}
/*
{
    "recipeId": "veggie-protein-chilli",
    "recipeName": "Veggie protein chilli",
    "description": "A protein packed vegan chilli, perfect after a run or gym workout. This easy supper is simple to make and freezable if you want to batch cook",
    "imageSrc": "https://images.immediate.co.uk/production/volatile/sites/30/2020/08/protein-veggie-chilli-6395abf.jpg",
    "parentId": "High-protein-vegan-meals"
  }
 */