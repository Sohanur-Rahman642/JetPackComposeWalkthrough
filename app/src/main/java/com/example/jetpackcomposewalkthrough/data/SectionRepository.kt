package com.example.jetpackcomposewalkthrough.data

import com.example.jetpackcomposewalkthrough.R
import com.example.jetpackcomposewalkthrough.model.Menu
import com.example.jetpackcomposewalkthrough.model.MenuItem
import com.example.jetpackcomposewalkthrough.model.MenuSections

object SectionRepository {

    fun getMenuSections(): List<MenuSections> {
        return listOf(
            MenuSections(
                title = "Popular",
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
                        id = 1003,
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
                        id = 1004,
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
                )
            ),
            MenuSections(
                title = "Snacks",
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
                        id = 1003,
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
                        id = 1004,
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
                )
            ),
            MenuSections(
                title = "Chicken",
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
                        id = 1003,
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
                        id = 1004,
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
                )
            ),
            MenuSections(
                title = "Sandwich",
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
                        id = 1003,
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
                        id = 1004,
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
                )
            ),
            MenuSections(
                title = "Pasta",
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
                        id = 1003,
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
                        id = 1004,
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
                )
            ),
            MenuSections(
                title = "Pizza",
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
                        id = 1003,
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
                        id = 1004,
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
                )
            ),
        )
    }
}