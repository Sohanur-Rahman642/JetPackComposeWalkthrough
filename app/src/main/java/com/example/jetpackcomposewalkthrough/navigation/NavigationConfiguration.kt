package com.example.jetpackcomposewalkthrough.navigation

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
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
fun NavigationConfiguration(navController: NavHostController, lazyListState: LazyListState, preFirstVisibleItemIndex: MutableState<Int>) {
    NavHost(navController = navController, startDestination = NavigationItem.Home.route ) {
        composable(NavigationItem.Home.route) {
            HomeScreen(
//                onCategoryClick = { navController.navigate(NavigationItem.Category.route) },
                onItemClick = {itemId ->
                    preFirstVisibleItemIndex.value = 0
                    navController.navigate("details/$itemId")
                },
                lazyListState
            )
        }

        composable("category") {
            CategoryScreen(

            )
        }

        composable("details/{itemId}",
            arguments = listOf(navArgument("itemId") { type = NavType.LongType })
            ){ backStackEntry->
            backStackEntry.arguments?.let {
                DetailsScreen(
                    itemId = it.getLong("itemId"),
                    onBackClick = { navController.navigateUp() },
                    lazyListState
                )
            }
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

