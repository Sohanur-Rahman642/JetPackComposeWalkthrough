package com.example.jetpackcomposewalkthrough.ui.main

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposewalkthrough.navigation.NavigationConfiguration
import com.example.jetpackcomposewalkthrough.navigation.NavigationItem
import com.example.jetpackcomposewalkthrough.ui.components.BottomNavigationBar
import com.example.jetpackcomposewalkthrough.ui.components.TopAppBar

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigationBar( navController ) }
    ) {
        NavigationConfiguration(navController)
    }
}


