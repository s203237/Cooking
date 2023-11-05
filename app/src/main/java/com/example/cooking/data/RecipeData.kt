package com.example.cooking.data

import com.example.cooking.R
import com.example.cooking.model.Recipe

class RecipeData {
    fun loadRecipes(): List<Recipe> {
        return listOf(
            Recipe(
                title = "Pear And Rainbow",
                imageUrl = R.drawable.pear,
                imageDescription = "3d rendering of a pear with a rainbow over it.",
                author = "Melissa Woo",
                prepTime = 20,
                cookingTime = 65,
                servingSize = 4,
                difficulty = "Medium",
                rating = 4.6f,
                recipeDescription = "This is a beautiful description of a thing I am making and it's going to be marvelous. Who knew how wonderful the thing could be. Well would you look at that, we are making a thing.",
                ingredients = listOf("Pear", "Rainbow", "Green paint"),
                steps = listOf("Do the thing.", "Do the other thing.", "Do the final thing.")
            ),
            Recipe(
                title = "Peach",
                imageUrl = R.drawable.peach,
                imageDescription = "3d rendering of a close-up of a peach with googly eyes",
                author = "Melissa Woo",
                prepTime = 10,
                cookingTime = 610,
                servingSize = 10,
                difficulty = "Easy",
                rating = 4.4f,
                recipeDescription = "This is a beautiful description of a thing I am making and it's going to be marvelous.",
                ingredients = listOf("Peach", "Googly eyes", "Salmon paint"),
                steps = listOf("Do the thing.", "Do the other thing.", "Do the final thing.")
            ),
            Recipe(
                title = "Spicy Sichuan Boiled Tofu",
                imageUrl = R.drawable.tofu,
                imageDescription = "Picture of shuizhu sichuan boiled tofu dish",
                author = "Sarah (Woks of Life)",
                prepTime = 40,
                cookingTime = 30,
                servingSize = 4,
                difficulty = "Easy",
                rating = 4.4f,
                recipeDescription = "This Sichuan boiled tofu, or shuǐzhǔ dòufu gān (水煮豆腐干) is an adapted version of Sichuan boiled beef that's vegetarian, vegan, and very tasty!",
                ingredients = listOf("10-11 ounces tofu", "4 tbsp vegetable oil", "1 cup soybean sprouts", "7 ounces enoki mushrooms", "1 slice ginger", "2 tsp Sichuan peppercorns", "2 scallions", "2 tbsp spicy bean paste", "1 tbsp tomate pasta", "1 1/2 cups water", "2 tsp sugar", "2 tsp light soy sauce", "1 tbsp garlic", "1/4 tsp dried Sichuan chili flakes", "1/4 tsp Sichuan peppercorn powder", "1 tbsp cilantro"),
                steps = listOf("Bring a medium pot of water to a boil. Add the tofu slices and blanch them for 30 seconds. Drain and set aside.",
                    "Heat 1 tablespoon of oil in your wok over high heat. Stir-fry the soybean sprouts for about 2-3 minutes. Add the enoki mushrooms, spreading the mushrooms out in a single layer, and leaving them for about 20 seconds. Then stir-fry until the mushrooms have wilted, 1 minute. Turn off the heat, pick a large heatproof serving bowl with some depth, and spread the bean sprouts and enoki mushrooms around the bottom of the bowl.",
                    "Add another tablespoon of oil to the wok over medium-low heat, along with the ginger slice and Sichuan peppercorns. Cook for 3 minutes, until fragrant, then remove the peppercorns and ginger, leaving the oil behind in the wok.",
                    "To the oil, add the white parts of the scallions, the spicy bean paste, and tomato paste. Fry for 1 minute, until the oil is red, then stir in the blanched tofu. Stir-fry for 30 seconds.",
                    "Then add the water, sugar, and light soy sauce. Bring to a simmer. Then add the cornstarch slurry. When it’s thickened, add this mixture on top of the mushrooms and bean sprouts.",
                    "Top with the minced garlic, chili flakes, and Sichuan peppercorn powder on top. In a small saucepan, heat the remaining 2 tablespoons of oil until it shimmers. Pour hot oil into the garlic, chili, and peppercorn powder; the ingredients should sizzle immediately. Then sprinkle over the green parts of the scallions and the cilantro. Serve immediately.")
            )


        )
    }
}