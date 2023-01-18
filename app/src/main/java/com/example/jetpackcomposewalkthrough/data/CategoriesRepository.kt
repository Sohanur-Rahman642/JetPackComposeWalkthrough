package com.example.jetpackcomposewalkthrough.data

import com.example.jetpackcomposewalkthrough.model.Category


object CategoriesRepository {

    fun getCategoriesData(): List<Category> {
        return listOf(
            Category(
                id = 1,
                type = "Popular",
                name = "Popular",
                image = "https://raw.githubusercontent.com/hitanshu-dhawan/McCompose/main/app/src/main/res/drawable-nodpi/" + "category_burgers.png"
            ),
            Category(
                id = 2,
                type = "Snacks",
                name = "Snacks",
                image = "https://raw.githubusercontent.com/hitanshu-dhawan/McCompose/main/app/src/main/res/drawable-nodpi/" + "category_fries.png"
            ),
            Category(
                id = 3,
                type = "Chicken",
                name = "Chicken",
                image = "https://raw.githubusercontent.com/hitanshu-dhawan/McCompose/main/app/src/main/res/drawable-nodpi/" + "category_beverages.png"
            ),
            Category(
                id = 4,
                type = "Sandwich",
                name = "Sandwich",
                image = "https://raw.githubusercontent.com/hitanshu-dhawan/McCompose/main/app/src/main/res/drawable-nodpi/" + "category_combo_meals.png"
            ),
            Category(
                id = 5,
                type = "Pasta",
                name = "Pasta",
                image = "https://raw.githubusercontent.com/hitanshu-dhawan/McCompose/main/app/src/main/res/drawable-nodpi/" + "category_happy_meals.png"
            ),
            Category(
                id = 6,
                type = "Pizza",
                name = "Pizza",
                image = "https://raw.githubusercontent.com/hitanshu-dhawan/McCompose/main/app/src/main/res/drawable-nodpi/" + "category_desserts.png"
            )
        )
    }

}