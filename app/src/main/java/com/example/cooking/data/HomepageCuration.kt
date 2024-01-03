package com.example.cooking.data

import com.example.cooking.model.ListType

class HomepageCuration {
    private val collectionNames = listOf(
        "party",
        "vegetarian-sandwich-recipes",
        "pasta",
        "vegetarian-dinner",
        "traybake-recipes"
    )

    private val collectionListTypes = listOf (
        //ListType.CARD,
        ListType.VERTICAL,
        ListType.HORIZONTAL,
        ListType.HORIZONTAL,
        //ListType.CARD,
        ListType.VERTICAL,
        ListType.HORIZONTAL

        )
    fun getCollectionsCount(): Int {
        return collectionNames.size;
    }
    fun loadCollectionNames(): List<String> {
        return collectionNames
    }

    fun loadListTypes(): List<ListType> {
        return collectionListTypes
    }
}