package com.example.jetpackcomposewalkthrough

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposewalkthrough.navigation.NavigationItem
import com.example.jetpackcomposewalkthrough.ui.TestScreen
import com.example.jetpackcomposewalkthrough.ui.cart.CartScreen
import com.example.jetpackcomposewalkthrough.ui.category.CategoryScreen
import com.example.jetpackcomposewalkthrough.ui.details.DetailsScreen
import com.example.jetpackcomposewalkthrough.ui.home.HomeScreen
import com.example.jetpackcomposewalkthrough.ui.main.MainScreen
import com.example.jetpackcomposewalkthrough.ui.profile.ProfileScreen
import com.example.jetpackcomposewalkthrough.ui.theme.JetPackComposeWalkthroughTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeWalkthroughTheme {
                // A surface container using the 'background' color from the theme
                //MainScreen()
                TestScreen(
                   // onItemClick = {}
                )
            }
        }
    }
}
