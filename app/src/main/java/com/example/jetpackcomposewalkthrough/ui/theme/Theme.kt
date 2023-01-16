package com.example.jetpackcomposewalkthrough.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
    primary = Red700,
    secondary = Amber700,
    background = Color.Black,
    surface = Gray900
)

private val LightColorPalette = lightColors(
    primary = Red500,
    secondary = Amber500,
    background = LightWhite,
    surface = Gray100

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun JetPackComposeWalkthroughTheme(
    lightTheme: Boolean = true,
    content: @Composable () -> Unit
) {
    val systemUiController = rememberSystemUiController()
    systemUiController.isStatusBarVisible = false

    val useDarkIcons = !lightTheme

    val configuration = LocalConfiguration.current

    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp

    println("dimension: $screenWidth * $screenHeight")


    DisposableEffect(systemUiController, useDarkIcons) {
        // Update all of the system bar colors to be transparent, and use
        // dark icons if we're in light theme
        systemUiController.setSystemBarsColor(
            color = FigGradientThree,
            darkIcons = true
        )

        // setStatusBarColor() and setNavigationBarColor() also exist

        onDispose {}
    }

    MaterialTheme(
        colors = if (lightTheme) LightColorPalette else DarkColorPalette,
        typography = typography,
        shapes = shapes,
        content = content
    )
}