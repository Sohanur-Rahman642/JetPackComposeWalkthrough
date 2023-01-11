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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposewalkthrough.ui.theme.JetPackComposeWalkthroughTheme

@Composable
fun SearchBar(
    text: String,
    modifier: Modifier = Modifier
) {
    androidx.compose.material.Surface(
        modifier = modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.small,
        color = MaterialTheme.colors.surface,
        contentColor = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
    ) {
        Row(
            modifier = Modifier
                .clickable(onClick = {})
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(Icons.Rounded.Search)
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = text,
                style = MaterialTheme.typography.subtitle1.copy(fontWeight = FontWeight.Normal)
            )

        }
    }
}


@Preview("SearchBar")
@Composable
private fun SearchBarPreview() {
    JetPackComposeWalkthroughTheme() {
        SearchBar(
            text = "Search for restaurant name..."
        )
    }
}
