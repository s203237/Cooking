package com.example.cooking.data.remote

import com.example.cooking.model.ListType

data class HomepageCollection(
    val id: String = "default",
    val size: Int = 1,
    val listType: ListType = ListType.HORIZONTAL
)


