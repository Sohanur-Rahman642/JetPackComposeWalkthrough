package com.example.jetpackcomposewalkthrough.data

import com.example.jetpackcomposewalkthrough.R
import com.example.jetpackcomposewalkthrough.model.Menu
import com.example.jetpackcomposewalkthrough.model.MenuItem

object MenuRepository {

    fun getMenuData(): Menu {
        return Menu(
            categories = CategoriesRepository.getCategoriesData(),
            menuItems = listOf(
                MenuItem(
                    id = 1001,
                    name = "Burger",
                   // description = "Mouthwatering perfection starts with two 100% pure beef patties and Big Mac sauce sandwiched between a sesame seed bun. It’s topped off with pickles, crisp shredded lettuce, finely chopped onion and American cheese.",
                    image = "drawable://" + R.drawable.trending1,
                    price = MenuRepository.getRandomPrice(),
                    categoryId = 1,
                    categoryName = "Popular",
                    rating = 4.19f,
                    totalRaters = 12,
                    deliveryDuration = "20 min",
                    discountRate = 10,
                    isFavourite = false,
                ),
                MenuItem(
                    id = 1002,
                    name = "Tehari",
                    //description = "Each Quarter Pounder with Cheese burger features a ¼ lb. of 100% fresh beef that’s hot, deliciously juicy and cooked when you order. It’s seasoned with just a pinch of salt and pepper, sizzled on a flat iron grill, then topped with slivered onions, tangy pickles and two slices of melty cheese on a sesame seed bun.",
                    image = "drawable://" + R.drawable.trending2,
                    price = MenuRepository.getRandomPrice(),
                    categoryId = 1,
                    categoryName = "Popular",
                    rating = 4.19f,
                    totalRaters = 12,
                    deliveryDuration = "20 min",
                    discountRate = 10,
                    isFavourite = false,
                ),
                MenuItem(
                    id = 1003,
                    name = "Samosa",
                    //description = "Each Double Quarter Pounder with Cheese features two quarter pound 100% fresh beef burger patties that are hot, deliciously juicy and cooked when you order. McDonald’s beef patties are seasoned with just a pinch of salt and pepper, sizzled on a flat iron grill, then topped with slivered onions, tangy pickles and two slices of melty cheese on a sesame seed bun.",
                    image = "drawable://" + R.drawable.trending1,
                    price = MenuRepository.getRandomPrice(),
                    categoryId = 1,
                    categoryName = "Snacks",
                    rating = 4.19f,
                    totalRaters = 12,
                    deliveryDuration = "20 min",
                    discountRate = 10,
                    isFavourite = false,
                ),
                MenuItem(
                    id = 1004,
                    name = "Grill Chicken legs",
                    //description = "The Quarter Pounder with Cheese Deluxe is a fresh take on a Quarter Pounder classic burger. Crisp leaf lettuce and three Roma tomato slices top a ¼ lb. of 100% McDonald’s fresh beef that’s hot, deliciously juicy and cooked when you order. Seasoned with just a pinch of salt and pepper and sizzled on our flat iron grill. Layered with two slices of melty American cheese, creamy mayo, slivered onions and tangy pickles on a soft, fluffy sesame seed hamburger bun.",
                    image = "drawable://" + R.drawable.trending2,
                    price = MenuRepository.getRandomPrice(),
                    categoryId = 1,
                    categoryName = "Chicken",
                    rating = 4.19f,
                    totalRaters = 12,
                    deliveryDuration = "20 min",
                    discountRate = 10,
                    isFavourite = false,
                ),
                MenuItem(
                    id = 1005,
                    name = "Sandwich",
                    //description = "A classic double burger from McDonald’s, the McDouble stacks two 100% pure beef patties seasoned with just a pinch of salt and pepper. It’s topped with tangy pickles, chopped onions, ketchup, mustard and a slice of melty American cheese.",
                    image = "drawable://" + R.drawable.trending1,
                    price = MenuRepository.getRandomPrice(),
                    categoryId = 1,
                    categoryName = "Sandwich",
                    rating = 4.19f,
                    totalRaters = 12,
                    deliveryDuration = "20 min",
                    discountRate = 10,
                    isFavourite = false,
                ),
                MenuItem(
                    id = 1006,
                    name = "Tehari",
                    //description = "Each Quarter Pounder with Cheese Bacon burger features thick-cut applewood smoked bacon atop a ¼ lb. of 100% fresh McDonald’s beef that’s cooked when you order. It’s a hot, deliciously juicy bacon cheeseburger, seasoned with just a pinch of salt and pepper and sizzled on our flat iron grill. Layered with two slices of melty American cheese, slivered onions and tangy pickles on a soft, fluffy sesame seed hamburger bun.",
                    image = "drawable://" + R.drawable.trending2,
                    price = MenuRepository.getRandomPrice(),
                    categoryId = 1,
                    categoryName = "Popular",
                    rating = 4.19f,
                    totalRaters = 12,
                    deliveryDuration = "20 min",
                    discountRate = 10,
                    isFavourite = false,
                ),
                MenuItem(
                    id = 1007,
                    name = "Tehari",
                    image = "drawable://" + R.drawable.trending2,
                    price = MenuRepository.getRandomPrice(),
                    categoryId = 1,
                    categoryName = "Pasta",
                    rating = 4.19f,
                    totalRaters = 12,
                    deliveryDuration = "20 min",
                    discountRate = 10,
                    isFavourite = false,
                ),
                MenuItem(
                    id = 1007,
                    name = "Pizza",
                    //description = "Each Quarter Pounder with Cheese Bacon burger features thick-cut applewood smoked bacon atop a ¼ lb. of 100% fresh McDonald’s beef that’s cooked when you order. It’s a hot, deliciously juicy bacon cheeseburger, seasoned with just a pinch of salt and pepper and sizzled on our flat iron grill. Layered with two slices of melty American cheese, slivered onions and tangy pickles on a soft, fluffy sesame seed hamburger bun.",
                    image = "drawable://" + R.drawable.trending2,
                    price = MenuRepository.getRandomPrice(),
                    categoryId = 1,
                    categoryName = "Pizza",
                    rating = 4.19f,
                    totalRaters = 12,
                    deliveryDuration = "20 min",
                    discountRate = 10,
                    isFavourite = false,
                ),
            ),

        )
    }

    fun getRandomPrice(): Int = (100..500).random()

}