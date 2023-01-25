package com.example.jetpackcomposewalkthrough.ui.main

import android.annotation.SuppressLint
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposewalkthrough.navigation.NavigationConfiguration
import com.example.jetpackcomposewalkthrough.ui.components.BottomNavigationBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val lazyListState = rememberLazyListState()
    val preFirstVisibleItemIndex = remember { mutableStateOf(0) }


    val isFirstItemVisible by remember {
        derivedStateOf {
            if((lazyListState.firstVisibleItemIndex == 0) || (preFirstVisibleItemIndex.value > lazyListState.firstVisibleItemIndex)){
                true
            }
            else {
                preFirstVisibleItemIndex.value = lazyListState.firstVisibleItemIndex
                false
            }

        }
    }


    Scaffold(
        bottomBar = {
                when (isFirstItemVisible) {
                    true -> {
                        BottomNavigationBar(
                            navController
                        )
                    }
                    else -> {}
                }
            }

    ) {
        NavigationConfiguration(navController, lazyListState, preFirstVisibleItemIndex)
    }
}


