package com.example.jetpackcomposewalkthrough.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

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
    MaterialTheme(
        colors = if (lightTheme) LightColorPalette else DarkColorPalette,
        typography = typography,
        shapes = shapes,
        content = content
    )
}