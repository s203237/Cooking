package com.example.cooking.data.remote.mock_datasource

import com.example.cooking.data.remote.RecipeDataRepo

class MockImageDataSource: RecipeDataRepo<List<String>> {
    override suspend fun fetchData(path:String): List<String> = listOf(
        "https://images.immediate.co.uk/production/volatile/sites/30/2020/08/spiced-lentil-spinach-pies-a1ae301.jpg",
        "https://images.immediate.co.uk/production/volatile/sites/30/2021/09/Miso-and-butternut-soup-efe9277.jpg",
        "https://images.immediate.co.uk/production/volatile/sites/30/2020/08/autumn-vegetable-salad-with-saffron-dressing-ff72d14.jpg",
        "https://images.immediate.co.uk/production/volatile/sites/30/2020/08/one-pot-paneer-curry-pie-c1bcd2f.jpg",

        )
}