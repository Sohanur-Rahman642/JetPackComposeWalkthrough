package com.example.jetpackcomposewalkthrough.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposewalkthrough.ui.theme.JetPackComposeWalkthroughTheme
import com.example.jetpackcomposewalkthrough.R
import com.example.jetpackcomposewalkthrough.ui.theme.FigCrimson
import com.example.jetpackcomposewalkthrough.ui.theme.FigHint

@Composable
fun SearchBar(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    androidx.compose.material.Surface(
        modifier = modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.small,
        color = Color.White,
        contentColor = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
    ) {
        Row(
            modifier = Modifier
                .clickable(onClick = {})
                .padding(5.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            PainterIcon(
                painter = painterResource(id = R.drawable.search),
                modifier = Modifier
                    .height(22.dp)
                    .width(22.dp)
                    .padding(start = 10.dp),
                tint = FigCrimson
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = text,
                style = MaterialTheme.typography.body2,
                color = FigHint
            )

        }
    }
}


@Preview("SearchBar")
@Composable
private fun SearchBarPreview() {
    JetPackComposeWalkthroughTheme() {
        SearchBar(
            text = "Search for restaurant name...",
            onClick = {}
        )
    }
}
