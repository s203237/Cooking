package com.example.cooking.data

class HomepageCuration {
    private val collectionNames = listOf(
        "party",
        "vegetarian-sandwich-recipes",
        "pasta",
        "vegetarian-dinner",
        "traybake-recipes"
    )
    fun getCollectionsCount(): Int {
        return collectionNames.size;
    }
    fun loadCollectionNames(): List<String> {
        return collectionNames
    }
}