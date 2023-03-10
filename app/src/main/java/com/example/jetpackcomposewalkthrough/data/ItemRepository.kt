package com.example.jetpackcomposewalkthrough.data

import com.example.jetpackcomposewalkthrough.model.Category
import com.example.jetpackcomposewalkthrough.model.CircularMenuItem

object ItemRepository {
    fun getCircularItemData(): List<CircularMenuItem> {
        return listOf(
            CircularMenuItem(
                id = 1,
                name = "Burgers",
                image = "TBA"
            ),
            CircularMenuItem(
                id = 2,
                name = "Pizza",
                image = "TBA"
            ),
            CircularMenuItem(
                id = 3,
                name = "Kacchi",
                image = "TBA"
            ),
            CircularMenuItem(
                id = 4,
                name = "Kebab",
                image = "TBA"
            ),
            CircularMenuItem(
                id = 5,
                name = "Chicken",
                image = "TBA"
            ),
            CircularMenuItem(
                id = 6,
                name = "Pasta",
                image = "TBA"
            ),
            CircularMenuItem(
                id = 7,
                name = "Shawarma",
                image = "TBA"
            ),
            CircularMenuItem(
                id = 8,
                name = "Singara",
                image = "TBA"
            ),
            CircularMenuItem(
                id = 9,
                name = "Samucha",
                image = "TBA"
            ),
            CircularMenuItem(
                id = 10,
                name = "Sandwich",
                image = "TBA"
            ),
            CircularMenuItem(
                id = 11,
                name = "Fruit Juice",
                image = "TBA"
            ),
            CircularMenuItem(
                id = 12,
                name = "Chicken Chap",
                image = "TBA"
            ),
        )
    }
}