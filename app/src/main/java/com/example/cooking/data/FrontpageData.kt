package com.example.cooking.data

import com.example.cooking.R
import com.example.cooking.model.Frontpage.RecipeModel

class FrontpageData {
    fun loadAffirmations(): List<RecipeModel> {
        return listOf<RecipeModel>(
            RecipeModel(R.string.affirmation1, R.drawable.image1),
            RecipeModel(R.string.affirmation2, R.drawable.image2),
            RecipeModel(R.string.affirmation3, R.drawable.image3),
            RecipeModel(R.string.affirmation4, R.drawable.image4),
            RecipeModel(R.string.affirmation5, R.drawable.image5),
            RecipeModel(R.string.affirmation6, R.drawable.image6),
            RecipeModel(R.string.affirmation7, R.drawable.image7),
            RecipeModel(R.string.affirmation8, R.drawable.image8),
            RecipeModel(R.string.affirmation9, R.drawable.image9),
            RecipeModel(R.string.affirmation10, R.drawable.image10)
        )
    }
}