package com.example.cooking.UI.Homepage

import com.example.cooking.data.remote.HomepageCollection
import com.example.cooking.model.ListType


class HomepageCuration {

    private val collectionData = listOf(
        HomepageCollection(id = "soup", size = 3, listType = ListType.VERTICAL),
        HomepageCollection(id = "pasta", size = 10, listType = ListType.HORIZONTAL),
        HomepageCollection(id = "salad", size = 10, listType = ListType.HORIZONTAL),
        HomepageCollection(id = "dessert", size = 1, listType = ListType.CARD),
        HomepageCollection(id = "breakfast", size = 5, listType = ListType.VERTICAL),
        HomepageCollection(id = "sandwich", size = 10, listType = ListType.HORIZONTAL),
    )

    fun loadCollectionData (): List<HomepageCollection> {
        return collectionData
    }
    private val collectionNames = listOf(
        "soup",
        "pasta",
        "salad",
        "breakfast",
        "dessert",
        "sandwich"
    )

    fun getCollectionsCount(): Int {
        return collectionNames.size;
    }
}