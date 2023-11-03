package com.example.cooking.data.remote

class MockRecipeDataSource: RecipeDataSource {
    override suspend fun fetchRecipes() = listOf(
        "{\"name\":\"One-pot paneer curry pie\",\"imageSrc\":\"https://images.immediate.co.uk/production/volatile/sites/30/2020/08/one-pot-paneer-curry-pie-c1bcd2f.jpg\",\"recipeAuthor\":\"estherclark\",\"timeToCook\":{\"Timing Hint\":\"plus cooling\",\"Cook\":\"1 hr and 30 mins\",\"Prep\":\"25 mins\"},\"difficulty\":\"More effort\",\"labels\":[\"Freezable (filling only)\",\"Vegetarian\"],\"portions\":\"Serves 6\",\"description\":\"What's more comforting than a curry in pie form? This one-pot paneer pie is filled with a makhani-style filling and topped with a crisp puff pastry lid\",\"nutrition\":{\"kcal\":\"871\",\"sugars\":\"17g\",\"salt\":\"0.7g\",\"carbs\":\"47g\",\"protein\":\"31g\",\"fat\":\"60g\",\"saturates\":\"31g\",\"fibre\":\"7g\"},\"ingredients\":[\"2 tbsp vegetable oil\",\"440g paneer, cut into 2cm cubes\",\"4 tbsp ghee or butter\",\"2 large onions, finely sliced\",\"2 large garlic cloves, crushed\",\"thumb-sized piece of ginger, finely grated\",\"½ tsp hot chilli powder\",\"2 tsp ground cumin\",\"2 tsp fenugreek seeds\",\"1½ tbsp garam masala\",\"2 x 400g cans chopped tomatoes\",\"1 tbsp caster sugar\",\"300g potato, peeled and cut into 2cm cubes\",\"150g spinach\",\"150g frozen peas\",\"100ml double cream\",\"2 tbsp cashew nut butter\",\"plain flour, for dusting\",\"320g sheet  all-butter puff pastry\",\"2 large eggs, 1 whole, 1 yolk only, lightly beaten together (freeze the leftover egg white for another recipe)\",\"2 tsp nigella seeds\",\"pilau rice or green veg, to serve\"],\"steps\":{\"1\":\"Heat the oil over a medium heat in a shallow flameproof casserole dish roughly 30cm wide. Add the paneer and fry for 5 mins, turning with tongs until each side is golden. Remove from the pan and set aside on a plate lined with kitchen paper.\",\"2\":\"Heat the ghee or butter in the same dish over a medium-low heat, then add the onions and a big pinch of salt. Fry for 15 mins, or until softened and caramelised. Stir in the garlic and ginger, cook for 1 min, then tip in the spices and fry for a further 2 mins. Scrape the spiced onions into a food processor or blender along with the tomatoes and blitz until smooth. Pour back into the pan with 1½ cans of water, then stir through the sugar and potatoes. Bring to the boil, lower to a simmer, then cover and cook, stirring occasionally, for 20-25 mins or until the potato is just tender.\",\"3\":\"Add the spinach and peas, and cook for 5 mins. Stir in the cream and cashew butter, then return the paneer to the pan and season to taste. Remove from the heat and set aside to cool completely.\",\"4\":\"Heat the oven to 220C/200C fan/gas 8. On a lightly floured surface, roll the pastry out to just bigger than your casserole dish. Cut a thin strip off each side and fix these around the edge of the casserole. Roll the pastry sheet over the top and press the edges with a fork to seal, and tuck in any overhang. Brush with the egg, sprinkle with the nigella seeds and bake for 30-35 mins or until deep golden brown. Leave to rest for 15 mins before serving with pilau rice or green veg.\"}}",

        "{\"name\":\"Autumn vegetable salad with saffron dressing\",\"imageSrc\":\"https://images.immediate.co.uk/production/volatile/sites/30/2020/08/autumn-vegetable-salad-with-saffron-dressing-ff72d14.jpg\",\"recipeAuthor\":\"tomkerridge\",\"timeToCook\":{\"Cook\":\"15 mins\",\"Prep\":\"35 mins\"},\"difficulty\":\"Easy\",\"labels\":[\"Dairy-free\",\"Egg-free\",\"Gluten-free\",\"Healthy\",\"Vegan\",\"Vegetarian\"],\"portions\":\"Serves 6 as a side\",\"description\":\"Enjoy this stunning autumn salad as a side dish at a dinner party. It features carrots, courgette, broccoli, tomatoes and olives in a lovely saffron dressing\",\"nutrition\":{\"kcal\":\"167\",\"sugars\":\"8g\",\"salt\":\"0.2g\",\"carbs\":\"9g\",\"protein\":\"3g\",\"fat\":\"12g\",\"saturates\":\"1g\",\"fibre\":\"5g\"},\"ingredients\":[\"12 rainbow carrots, tops left on, washed and peeled\",\"1 medium courgette, sliced\",\"8 stalks long-stem broccoli, any thick stalks halved lengthways\",\"1 tbsp rapeseed oil\",\"100g mixed cherry tomatoes, halved\",\"4 spring onions, thinly sliced at an angle\",\"3 plum tomatoes, scored, blanched, peeled, deseeded and cut into small pieces\",\"handful black olives, stoned and sliced\",\"½ cucumber, cut lengthways, seeds removed and sliced at the angle\",\"3 tbsp roughly chopped basil\"],\"steps\":{\"1\":\"Heat a griddle pan over a medium-high heat. Tip the carrots, courgettes and broccoli into a large mixing bowl, lightly season and toss together with the rapeseed oil. Once the griddle is hot, add the vegetables in batches and leave to slightly char for around 3-4 mins, then transfer back to the bowl. When all the veg is charred, add the remaining salad ingredients, toss together and set aside.\",\"2\":\"To make the saffron dressing, whisk the vinegar, mustard, saffron and sugar together in a bowl with a pinch of salt until the sugar has dissolved. Whisk in the oil gradually, then stir in the shallots. Dress the salad and serve.\"}}",

        "{\"name\":\"Miso & butternut soup\",\"imageSrc\":\"https://images.immediate.co.uk/production/volatile/sites/30/2021/09/Miso-and-butternut-soup-efe9277.jpg\",\"recipeAuthor\":\"sarabuenfeld\",\"timeToCook\":{\"Cook\":\"35 mins\",\"Prep\":\"10 mins\"},\"difficulty\":\"Easy\",\"labels\":[\"Healthy\",\"Vegetarian\"],\"portions\":\"Serves 2\",\"description\":\"Make lunch more exciting with this silky and deeply savoury miso and butternut soup. Delivering all of your five-a-day, it's also bursting with goodness\",\"nutrition\":{\"kcal\":\"287\",\"sugars\":\"15g\",\"salt\":\"0.9g\",\"carbs\":\"34g\",\"protein\":\"10g\",\"fat\":\"10g\",\"saturates\":\"1g\",\"fibre\":\"12g\"},\"ingredients\":[\"2 tsp rapeseed oil\",\"1 large onion, chopped\",\"400g butternut squash, skin-on, cut into chunks\",\"2 garlic cloves, chopped\",\"210g can butter beans, drained\",\"2 tsp vegetable bouillon\",\"80g shredded kale, finely chopped\",\"2 tsp sesame oil\",\"2 tsp toasted sesame seeds\",\"2 tsp finely grated ginger\",\"1 tbsp brown rice miso\"],\"steps\":{\"1\":\"Heat the oil in a large pan and fry the onion for 5 mins to soften. Add the squash and garlic, and stir for a minute. Add the beans and bouillon along with a litre of water, then cover and simmer for 20 mins until the squash is tender.\",\"2\":\"Meanwhile, steam the kale for 10 mins, then toss together with the sesame oil, seeds and ginger.\",\"3\":\"Add the miso to the soup, then blitz until smooth using a hand blender. Pour into bowls and top with the sesame kale mix to serve.\"}}",
    "{\n" +
            "  \"name\": \"Spiced lentil & spinach pies\",\n" +
            "  \"imageSrc\": \"https://images.immediate.co.uk/production/volatile/sites/30/2020/08/spiced-lentil-spinach-pies-a1ae301.jpg\",\n" +
            "  \"recipeAuthor\": \"tomkerridge\",\n" +
            "  \"timeToCook\": {\n" +
            "    \"Timing Hint\": \"plus cooling \",\n" +
            "    \"Cook\": \"1 hr\",\n" +
            "    \"Prep\": \"25 mins\"\n" +
            "  },\n" +
            "  \"difficulty\": \"Easy\",\n" +
            "  \"labels\": [\n" +
            "    \"Vegetarian\"\n" +
            "  ],\n" +
            "  \"portions\": \"Makes enough filling for 6 individual pies \",\n" +
            "  \"description\": \"Try these vegetarian pies with a spiced pastry glaze and surprise chutney middle. The lentils not only soak up all the flavors, they’re filling and good for you, too\",\n" +
            "  \"nutrition\": {\n" +
            "    \"kcal\": \"1055\",\n" +
            "    \"sugars\": \"11g\",\n" +
            "    \"salt\": \"2.2g\",\n" +
            "    \"carbs\": \"117g\",\n" +
            "    \"protein\": \"27g\",\n" +
            "    \"fat\": \"51g\",\n" +
            "    \"saturates\": \"24g\",\n" +
            "    \"fibre\": \"9g\"\n" +
            "  },\n" +
            "  \"ingredients\": [\n" +
            "    \"1 tbsp sunflower oil\",\n" +
            "    \"1 large onion, finely chopped\",\n" +
            "    \"5 garlic cloves, grated\",\n" +
            "    \"thumb-sized piece of ginger, peeled and finely grated\",\n" +
            "    \"1 tsp cumin\",\n" +
            "    \"1½ tsp turmeric\",\n" +
            "    \"½ cinnamon stick\",\n" +
            "    \"pinch of chilli flakes\",\n" +
            "    \"250g red split lentils\",\n" +
            "    \"600ml vegetable stock\",\n" +
            "    \"30g butter\",\n" +
            "    \"300g spinach\",\n" +
            "    \"1 lemon, zested and juiced\",\n" +
            "    \"2 tbsp chopped coriander\",\n" +
            "    \"6 tbsp chutney\",\n" +
            "    \"1 quantity all-butter  pie pastry (see 'Goes well with' below), or use a shop-bought vegetarian alternative \"\n" +
            "  ],\n" +
            "  \"steps\": {\n" +
            "    \"1\": \"Heat the oil in a wide-based pan. Add the onion and cook over a low heat for 10 mins, stirring, until softened. Mix in the garlic, ginger and spices and cook for 1 min more. Tip in the lentils, pour over the vegetable stock, season and bring to the boil. Reduce the heat, then cover and cook for 20 mins until the lentils are tender.\",\n" +
            "    \"2\": \"Meanwhile, heat half the butter in a large pan, add the spinach and cook until wilted. Season, then drain. Stir the spinach through the lentils with the lemon zest and juice and coriander, then leave to cool.\",\n" +
            "    \"3\": \"Mix together all the ingredients for the egg wash. Assemble the pies as directed in the pastry recipe, adding a spoonful of chutney to the middle of each. Glaze with the spiced egg wash before baking.\"\n" +
            "  }\n" +
            "}\n"
    )
}