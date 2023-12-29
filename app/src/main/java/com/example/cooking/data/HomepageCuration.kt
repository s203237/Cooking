package com.example.cooking.data

class HomepageCuration {
    private val collectionNames = listOf<String>(
        "party",
        "party",
        "party",
        "party",
        "party"
    )
    fun getCollectionsCount(): Int {
        return collectionNames.size;
    }
    fun loadCollectionNames(): List<String> {
        return collectionNames
    }
}