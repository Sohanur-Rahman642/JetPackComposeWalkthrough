package com.example.jetpackcomposewalkthrough.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import com.example.jetpackcomposewalkthrough.ui.cart.CartScreen
import com.example.jetpackcomposewalkthrough.ui.category.CategoryScreen
import com.example.jetpackcomposewalkthrough.ui.details.DetailsScreen
import com.example.jetpackcomposewalkthrough.ui.home.HomeScreen
import com.example.jetpackcomposewalkthrough.ui.profile.ProfileScreen

@Composable
fun NavigationConfiguration(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationItem.Home.route ) {
        composable(NavigationItem.Home.route) {
            HomeScreen(
//                onCategoryClick = { navController.navigate(NavigationItem.Category.route) },
                onItemClick = {itemId ->
                    navController.navigate("details/$itemId")
                }
            )
        }

        composable("category") {
            CategoryScreen(

            )
        }

        composable("details/{itemId}",
            arguments = listOf(navArgument("itemId") { type = NavType.LongType })
            ){ backStackEntry->
            DetailsScreen(
                itemId = backStackEntry.arguments!!.getLong("itemId"),
                onBackClick = { navController.navigateUp() }
            )
        }

        composable("cart") {
            CartScreen(

            )
        }

        composable("profile") {
            ProfileScreen(

            )
        }
    }
}

