package com.example.jetpackcomposewalkthrough.ui.components

import android.icu.text.CaseMap.Title
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposewalkthrough.R
import com.example.jetpackcomposewalkthrough.ui.theme.JetPackComposeWalkthroughTheme

@Composable
fun SpotlightCard(
    title: String,
    imageUrl: String,
    onClick: () -> Unit
) {
    val isLightTheme = MaterialTheme.colors.isLight

    androidx.compose.material.Surface(
        modifier = Modifier.width(160.dp),
        shape = MaterialTheme.shapes.medium,
        color = remember { getRandomBackgroundColor(isLightTheme = isLightTheme) },
        contentColor = MaterialTheme.colors.onSurface
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = onClick)
                .padding(vertical = 16.dp)
        ) {
            Text(
               text = title,
               style = MaterialTheme.typography.h6,
               maxLines = 1,
               overflow = TextOverflow.Ellipsis,
               modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1.00f)
            ) {
                Layout(
                    content = {
                        NetworkImage(
                            imageUrl = imageUrl,
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .wrapContentWidth()
                                .fillMaxWidth(),
                            previewPlaceholder =  R.drawable.category_happy_meals
                        )
                    }
                ) { measurables, constraints ->
                    val imagePlaceable = measurables[0].measure(constraints)
                    
                    layout(
                        width = constraints.maxWidth,
                        height = constraints.minHeight
                    ) {
                        imagePlaceable.place(
                            x = (constraints.maxWidth - imagePlaceable.width * 0.75).toInt(),
                            y = 0
                        )
                    }

                }
            }
        }
    }
}


private fun getRandomBackgroundColor(isLightTheme: Boolean): Color {
    val colors = listOf(
        Pair(Color(0xFFFCE4EC), Color(0xFFC2185B)), // Pink
        Pair(Color(0xFFF3E5F5), Color(0xFF7B1FA2)), // Purple
        Pair(Color(0xFFE1F5FE), Color(0xFF0288D1)), // Light Blue
        Pair(Color(0xFFF1F8E9), Color(0xFF689F38)), // Light Green
        Pair(Color(0xFFFFF3E0), Color(0xFFF57C00)), // Orange
    )
    val color = colors.random()
    return if(isLightTheme) color.first else color.second
}

@Preview("Spotlight Card")
@Composable
private fun SpotlightCardPreview() {
    JetPackComposeWalkthroughTheme() {
        SpotlightCard(
            title = "Happy Meals",
            imageUrl = "",
            onClick = {}
        )
    }
}
