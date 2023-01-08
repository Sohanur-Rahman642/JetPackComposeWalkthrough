package com.example.jetpackcomposewalkthrough.ui.home

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposewalkthrough.ui.components.SearchBar
import com.example.jetpackcomposewalkthrough.ui.theme.JetPackComposeWalkthroughTheme
import com.hitanshudhawan.mccompose.data.HomeRepository

@Composable
fun HomeScreen(
    onCategoryClick: () -> Unit,
    onMenuItemClick: () -> Unit,
) {
    val data = HomeRepository.getHomeData()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "McDonald's") }
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            item { Spacer(modifier = Modifier.height(16.dp)) }

            item {
                Text(
                    text = "Hi ${data.user.name}!",
                    style = MaterialTheme.typography.h3,
                    modifier = Modifier.padding( horizontal = 16.dp)
                )
            }

            item {
                SearchBar(
                    text = "Find what you want...",
                    modifier = Modifier.padding(horizontal = 16.dp)
                )

            }
        }
    }
}


@Preview("HomeScreen")
@Composable
private fun HomeScreenPreview() {
    JetPackComposeWalkthroughTheme() {
        HomeScreen(
            onCategoryClick = {},
            onMenuItemClick = {},
        )
    }
}
