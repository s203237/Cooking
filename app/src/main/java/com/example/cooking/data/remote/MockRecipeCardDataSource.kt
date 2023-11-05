package com.example.cooking.data.remote

class MockRecipeCardDataSource: RecipeDataSource {
    override suspend fun fetchData(): List<String> = listOf(
        "{\"recipeId\":\"One-pot paneer curry pie\",\"name\":\"One! pot paneer curry pie\",\"imageSrc\":\"https://images.immediate.co.uk/production/volatile/sites/30/2020/08/one-pot-paneer-curry-pie-c1bcd2f.jpg\"}",
        "{\"recipeId\":\"Autumnal vegetable salad with saffron dressing\",\"name\":\"Autumn vegetable salad with saffron dressing\",\"imageSrc\":\"https://images.immediate.co.uk/production/volatile/sites/30/2020/08/autumn-vegetable-salad-with-saffron-dressing-ff72d14.jpg\"}",
        "{\"recipeId\":\"Miso & butternut soup\",\"name\":\"Miso & butternut soup\",\"imageSrc\":\"https://images.immediate.co.uk/production/volatile/sites/30/2021/09/Miso-and-butternut-soup-efe9277.jpg\"}"

    )
}