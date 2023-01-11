package com.example.jetpackcomposewalkthrough.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposewalkthrough.R
import com.example.jetpackcomposewalkthrough.constants.Constants
import com.example.jetpackcomposewalkthrough.model.CircularMenuItem
import com.example.jetpackcomposewalkthrough.model.MenuItem
import com.example.jetpackcomposewalkthrough.model.SliderMenuItem
import com.example.jetpackcomposewalkthrough.ui.theme.JetPackComposeWalkthroughTheme

@Composable
fun SliderItemCard(
    sliderMenuItem: SliderMenuItem,
    onClick: () -> Unit,
) {

    Card(
        modifier = Modifier
            .width(300.dp)
            .height(200.dp)
            .clickable(onClick = onClick),

        shape = MaterialTheme.shapes.medium,
        backgroundColor = Color.White,
    ) {
        Box(
            modifier = Modifier

        ) {
            NetworkImage(
                imageUrl = sliderMenuItem.image,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize(),
                previewPlaceholder = R.drawable.banner1
            )
        }
    }
}

@Preview("Menu Item Card")
@Composable
private fun SliderItemCardPreview() {
    JetPackComposeWalkthroughTheme() {
        SliderItemCard(
            sliderMenuItem = SliderMenuItem(
                id = 0,
                image = ""
            ),
            onClick = {}
        )
    }
}