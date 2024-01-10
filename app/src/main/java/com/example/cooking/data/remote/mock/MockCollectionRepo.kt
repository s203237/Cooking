package com.example.cooking.data.remote.mock

import com.example.cooking.data.remote.ApiService
import com.example.cooking.data.remote.CardDto
import com.example.cooking.data.remote.CollectionDto
import com.example.cooking.data.remote.FetchParameters
import com.example.cooking.data.remote.RecipeDataRepo
import com.example.cooking.data.remote.TagDto

class MockCollectionRepo(apiService: ApiService): RecipeDataRepo<CollectionDto> {
    private val listCardDto = loadTestCardsWithTags()
    override suspend fun fetchData(param: FetchParameters): CollectionDto {
        return CollectionDto(listCardDto)
    }

    private fun loadTestCardsWithTags(): List<CardDto> {

        val card1Tags = listOf(
            TagDto(name = "dairy_free", displayName = "Dairy Free", type = "Dietary"),
            TagDto(name = "gluten_free", displayName = "Gluten Free", type = "Dietary"),
            TagDto(name = "easy", displayName = "Easy", type = "Difficulty")
        )

        val card2Tags = listOf(
            TagDto(name = "asian", displayName = "Asian", type = "Cuisine"),
            TagDto(name = "5_ingredients_or_less", displayName = "5 ingredients or less", type = "Difficulty")
        )

        val card3Tags = listOf(
            TagDto(name = "dairy_free", displayName = "Dairy Free", type = "Dietary"),
            TagDto(name = "middle_eastern", displayName = "Middle Eastern", type = "Cuisine"),
            TagDto(name = "5_ingredients_or_less", displayName = "5 ingredients or less", type = "Difficulty")
        )

        return listOf(
            CardDto(
                title = "dairy-free gluten-free easy",
                tags = card1Tags,
                imageUrl = "https://img.buzzfeed.com/video-api-prod/assets/eafca7a493d244788666b29cc4f0b017/BFV5191_CarrotCakeOatmeal-Thumb1080.jpg?resize=600:*&output-format=auto&output-quality=auto"
            ),
            CardDto(
                title = "asian 5 ingredients or less",
                tags = card2Tags,
                imageUrl = "https://img.buzzfeed.com/thumbnailer-prod-us-east-1/video-api/assets/448826.jpg?resize=600:*&output-format=auto&output-quality=auto"
            ),
            CardDto(
                title = "dairy-free middle eastern 5 ingredients or less",
                tags = card3Tags,
                imageUrl = "https://img.buzzfeed.com/video-api-prod/assets/6ec1a985f82149b78146cda38ec2f9bc/BFV6636_One-PanMoroccanChicken_THUMB_A.jpg?resize=600:*&output-format=auto&output-quality=auto"
            )
        )
    }

}

