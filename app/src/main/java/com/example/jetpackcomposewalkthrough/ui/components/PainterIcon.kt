package com.example.jetpackcomposewalkthrough.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun PainterIcon(
    painter: Painter,
    modifier: Modifier = Modifier,
    tint: Color? = Color.Black
) {
    androidx.compose.material.Icon(
        painter = painter,
        contentDescription = null,
        modifier = modifier,
        tint = tint!!
    )
}