package com.example.cooking.data

class HomepageCuration {
    private val collectionNames = listOf<String>(
        "high-protein-vegan-recipes",
        "vegan-winter-recipes",
        "vegan-lentil-recipes",
        "vegan-slow-cooker-recipes",
        "vegetarian-pasta-recipes"
    )
    fun getCollectionsCount(): Int {
        return collectionNames.size;
    }
    fun loadCollectionNames(): List<String> {
        return collectionNames
    }
}