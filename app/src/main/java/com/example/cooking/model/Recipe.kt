package com.example.cooking.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@Serializable
data class Recipe(
    val id: Int = 0,
    val name: String = "Default title",
    val thumbnail_url: String = "",
    val thumbnail_alt_text: String = "Default description",
    val credits: List<Author> = listOf(),
    val prep_time_minutes: Int? = 0, //Both prep time and cook time can be null
    val cook_time_minutes: Int? = 0,
    val difficulty: String = "Default difficulty", //TODO: look at this maybe not working with this API
    val num_servings: Int = 0,
    val user_ratings: Score = Score(), //TODO: score is between 0 and 1
    val description: String = "Default description",
    val sections: List<Section> = listOf(),
    val instructions: List<Instructions> = listOf()
)

@Serializable
data class Score(
    val score: Float = 0F
)

@Serializable
data class Author(
    val name: String = ""
)

@Serializable
data class Section(
    val components: List<Component>
)

@Serializable
data class Component(
    val raw_text: String
)

@Serializable
data class Instructions(
    val display_text: String
)