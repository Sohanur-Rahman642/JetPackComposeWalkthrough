package com.example.jetpackcomposewalkthrough.ui.main

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposewalkthrough.navigation.NavigationConfiguration
import com.example.jetpackcomposewalkthrough.ui.components.BottomNavigationBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigationBar( navController ) }
    ) {
        NavigationConfiguration(navController)
    }
}


