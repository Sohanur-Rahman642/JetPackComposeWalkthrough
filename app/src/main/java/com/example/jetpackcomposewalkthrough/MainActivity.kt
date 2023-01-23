package com.example.jetpackcomposewalkthrough

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.jetpackcomposewalkthrough.ui.TestScreen
import com.example.jetpackcomposewalkthrough.ui.main.MainScreen
import com.example.jetpackcomposewalkthrough.ui.theme.JetPackComposeWalkthroughTheme
import com.google.accompanist.pager.ExperimentalPagerApi

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeWalkthroughTheme {
                // A surface container using the 'background' color from the theme
                MainScreen()
                //TestScreen()
            }
        }
    }
}
