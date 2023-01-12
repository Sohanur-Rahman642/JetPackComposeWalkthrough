package com.example.jetpackcomposewalkthrough.navigation

import com.example.jetpackcomposewalkthrough.R

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Home : NavigationItem("home", R.drawable.homebottomnav, "Home")
    object Category : NavigationItem("category", R.drawable.categorybottomnav, "Category")
    object Details : NavigationItem("details", R.drawable.details, "Details")
    object Cart : NavigationItem("cart", R.drawable.cartbottomnav, "Cart")
    object Profile : NavigationItem("profile", R.drawable.profilebottomnav, "Profile")
}
