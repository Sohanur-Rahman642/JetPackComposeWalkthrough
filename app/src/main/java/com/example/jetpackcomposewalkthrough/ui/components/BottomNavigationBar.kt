package com.example.jetpackcomposewalkthrough.ui.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposewalkthrough.navigation.NavigationItem
import com.example.jetpackcomposewalkthrough.ui.theme.FigHint
import com.example.jetpackcomposewalkthrough.ui.theme.FigNavUnselect

@Composable
fun BottomNavigationBar() {
    val items = listOf(
        NavigationItem.Category,
        NavigationItem.Details,
        NavigationItem.Home,
        NavigationItem.Cart,
        NavigationItem.Profile
    )
    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = FigNavUnselect
    ) {
        items.forEach { item ->
            BottomNavigationItem(
                icon = { androidx.compose.material.Icon(painterResource(id = item.icon), contentDescription = item.title) },
                label = { Text(text = item.title) },
                selectedContentColor = Color.Yellow,
                unselectedContentColor = FigNavUnselect,
                alwaysShowLabel = true,
                selected = false,
                onClick = {
                    /* Add code later */
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {
    BottomNavigationBar()
}