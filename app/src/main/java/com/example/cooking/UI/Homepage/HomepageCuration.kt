package com.example.cooking.UI.Homepage

import com.example.cooking.model.ListType

class HomepageCuration {
    private val collectionNames = listOf(
        "soup",
        "pasta",
        "salad",
        "under_30_minutes",
        "dessert",
        "sandwich"
    )

    private val collectionListTypes = listOf (
        ListType.VERTICAL,
        ListType.HORIZONTAL,
        ListType.HORIZONTAL,
        ListType.CARD,
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