package com.example.jetpackcomposewalkthrough.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposewalkthrough.constants.Constants
import com.example.jetpackcomposewalkthrough.data.HomeRepository
import com.example.jetpackcomposewalkthrough.ui.components.CircularMenuItemCard
import com.example.jetpackcomposewalkthrough.ui.components.MenuItemCard
import com.example.jetpackcomposewalkthrough.ui.components.SliderItemCard
import com.example.jetpackcomposewalkthrough.ui.theme.FigBlack
import com.example.jetpackcomposewalkthrough.ui.theme.JetPackComposeWalkthroughTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState


@Composable
fun HomeScreen(
    onCategoryClick: () -> Unit,
    onMenuItemClick: () -> Unit,
) {
    val data = HomeRepository.getHomeData()
    val imageUrl = remember { mutableStateOf("") }

    Scaffold {


        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            ///.........Image Slider........../////
            item { Spacer(modifier = Modifier.height(16.dp)) }

            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()

                ){
                    @OptIn(ExperimentalPagerApi::class)
                    HorizontalPager(
                        count = data.imageSliderItems.size,
                        state = rememberPagerState(),
                        contentPadding = PaddingValues(start = 20.dp, end = 60.dp),
                        modifier = Modifier
                            .wrapContentSize()

                    ) { currentPage ->
                            imageUrl.value = data.imageSliderItems[currentPage].image
                            SliderItemCard(
                                sliderMenuItem = data.imageSliderItems[currentPage],
                                onClick = {}
                            )

                    }
                }
            }


            ///.........Circular List........../////
            item { Spacer(modifier = Modifier.height(16.dp)) }

            item {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    item { Spacer(modifier = Modifier.width(5.dp)) }

                    items(data.circularMenuItems) { circularMenuItem ->
                        CircularMenuItemCard(
                            circularMenuItem = circularMenuItem,
                            onClick = onMenuItemClick,
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }


            ///.........Trending Recipe........../////
            item { Spacer(modifier = Modifier.height(16.dp)) }
            item {
                Text(
                    text = "Trending Recipe",
                    style = MaterialTheme.typography.h6,
                    color = FigBlack,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )

                Spacer(modifier = Modifier.height(10.dp))
            }

            item { Spacer(modifier = Modifier.width(16.dp)) }

            item {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    item { Spacer(modifier = Modifier.width(10.dp)) }
                    items(data.popularMenuItems) { menuItem ->
                        MenuItemCard(
                            menuItem = menuItem,
                            onClick = onMenuItemClick,
                            type = Constants.TYPE_HORIZONTAL
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }

            item { Spacer(modifier = Modifier.height(16.dp)) }

            ///.........Featured Recipe........../////

            item {
                Text(
                    text = "Featured Recipe",
                    style = MaterialTheme.typography.h6,
                    color = FigBlack,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )

                Spacer(modifier = Modifier.height(10.dp))
            }

            item { Spacer(modifier = Modifier.width(16.dp)) }

            item {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    item { Spacer(modifier = Modifier.width(10.dp)) }
                    items(data.popularMenuItems) { menuItem ->
                        MenuItemCard(
                            menuItem = menuItem,
                            onClick = onMenuItemClick,
                            type = Constants.TYPE_HORIZONTAL
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }

            item { Spacer(modifier = Modifier.height(16.dp)) }

            ////.........Sweet Tooth........../////

            item {
                Text(
                    text = "Sweet Tooth",
                    style = MaterialTheme.typography.h6,
                    color = FigBlack,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )

                Spacer(modifier = Modifier.height(10.dp))
            }

            item { Spacer(modifier = Modifier.width(16.dp)) }

            item {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    item { Spacer(modifier = Modifier.width(10.dp)) }
                    items(data.popularMenuItems) { menuItem ->
                        MenuItemCard(
                            menuItem = menuItem,
                            onClick = onMenuItemClick,
                            type = Constants.TYPE_HORIZONTAL
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }

            item { Spacer(modifier = Modifier.height(16.dp)) }


            ////.........All Restaurants........../////
            item {
                Text(
                    text = "All Restaurants",
                    style = MaterialTheme.typography.h6,
                    color = FigBlack,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
            }
            item { Spacer(modifier = Modifier.height(16.dp)) }
            item { Spacer(modifier = Modifier.width(10.dp)) }

            items(data.popularMenuItems) { menuItem ->
                MenuItemCard(
                    menuItem = menuItem,
                    onClick = onMenuItemClick,
                    type = Constants.TYPE_VERTICAL
                )
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}


@Preview("HomeScreen")
@Composable
private fun HomeScreenPreview() {
    JetPackComposeWalkthroughTheme {
        HomeScreen(
            onCategoryClick = {},
            onMenuItemClick = {},
        )
    }
}
