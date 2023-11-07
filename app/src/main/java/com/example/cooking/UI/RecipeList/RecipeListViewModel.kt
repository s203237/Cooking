package com.example.cooking.UI.RecipeList

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cooking.DependencyProvider
import com.example.cooking.UI.Homepage.RecipeCard
import com.example.cooking.model.RecipeCard
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RecipeListViewModel: ViewModel() {

    private val _recipeCards = MutableStateFlow<List<RecipeCard>>(emptyList())
    val recipeCards = _recipeCards.asStateFlow()
    private val _collectionName = MutableStateFlow("")

    fun updateCollectionName(newCollectionName: String) {
        _collectionName.value = newCollectionName
        val printOutValue = _collectionName.value
        Log.v("CollectionName Trace", "In updateCollectionName: $printOutValue")

    }
    init {
        viewModelScope.launch(Dispatchers.IO) {
            _collectionName.collect{newCollectionName ->
                Log.v("CollectionName Trace", "CollectionName in viewModel.launch: $newCollectionName")
                val recipeCards = DependencyProvider.recipeCardDataSource.fetchData(_collectionName.value)
                _recipeCards.value = recipeCards
            }

        }
    }




}
