package com.example.jetpackcomposewalkthrough.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposewalkthrough.R
import com.example.jetpackcomposewalkthrough.model.CircularMenuItem
import com.example.jetpackcomposewalkthrough.ui.theme.FigBlack
import com.example.jetpackcomposewalkthrough.ui.theme.JetPackComposeWalkthroughTheme

@Composable
fun CircularMenuItemCard(
    circularMenuItem: CircularMenuItem,
    onClick: () -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(start = 10.dp)

    ) {
        Column(
            modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
            .background(Color.Transparent)
            ) {
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)


            ) {
                Image(
                    painterResource(R.drawable.burger),
                    contentDescription = "",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = circularMenuItem.name,
            style = MaterialTheme.typography.button,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,


            color = FigBlack
        )
    }
}


@Preview("Menu Item Card")
@Composable
private fun CircularMenuItemCardPreview() {
    JetPackComposeWalkthroughTheme() {
        CircularMenuItemCard(
            circularMenuItem = CircularMenuItem(
                id = 0,
                name = "Burger",
                image = "TBA"
            ),
            onClick = {}
        )
    }
}