package com.example.jetpackcomposewalkthrough.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material.Icon
import androidx.compose.ui.graphics.Color

@Composable
fun Icon(
    imageVector: ImageVector,
    modifier: Modifier = Modifier,
    tint: Color? = Color.Black
) {
    Icon(
        imageVector = imageVector,
        contentDescription = null,
        modifier = modifier,
        tint = tint!!
    )
}