package com.example.jetpackcomposewalkthrough.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.jetpackcomposewalkthrough.R
import com.example.jetpackcomposewalkthrough.constants.Constants
import com.example.jetpackcomposewalkthrough.data.HomeRepository
import com.example.jetpackcomposewalkthrough.ui.components.*
import com.example.jetpackcomposewalkthrough.ui.theme.*
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeScreen(
    onCategoryClick: () -> Unit,
    onMenuItemClick: () -> Unit,
) {
    val data = HomeRepository.getHomeData()

    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                FigGradientOne,
                                FigGradientTwo,
                                FigGradientThree
                            )
                        )
                    )
                    .fillMaxWidth()
                    .height(130.dp)
            ) {
                ConstraintLayout(
                    modifier = Modifier
                        .padding(20.dp)
                        .fillMaxSize()
                ) {
                    val (locationIcon, deliverText, addressText, arrowDownIcon, searchBox,  profileBox, filterBox ) = createRefs()

                    Box(
                        modifier = Modifier.constrainAs(locationIcon){
                            start.linkTo(parent.start, margin = 5.dp)
                           // end.linkTo(deliverText.start)
                            top.linkTo(parent.top, margin = 20.dp)

                        }
                    ){
                        PainterIcon(
                            painter = painterResource(id = R.drawable.location),
                            modifier = Modifier
                                .height(22.dp)
                                .width(22.dp)
                                .padding(start = 10.dp),
                            tint = FigCrimson
                        )
                    }

                    Box(
                        modifier = Modifier.constrainAs(deliverText){
                            start.linkTo(locationIcon.end, margin = 5.dp)
                            //end.linkTo(parent.end, margin = 5.dp)
                            top.linkTo(parent.top, margin = 15.dp)

                        }
                    ){
                        Text(
                            text = "Deliver to",
                            style = MaterialTheme.typography.body2,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            color = FigCrimson
                        )
                    }

                    Box(
                        modifier = Modifier
                            .constrainAs(profileBox) {
                                //start.linkTo(deliverText.end, margin = 5.dp)
                                end.linkTo(parent.end, margin = 5.dp)
                                top.linkTo(parent.top, margin = 10.dp)

                            }
                            .clip(CircleShape)
                            .background(FigCrimson)
                    ){
                        PainterIcon(
                            painter = painterResource(id = R.drawable.profile),
                            modifier = Modifier
                                .padding(10.dp)
                                .height(22.dp)
                                .width(22.dp),
                            tint = Color.White
                        )
                    }

                    Row(
                        modifier = Modifier
                            .constrainAs(addressText) {
                                start.linkTo(locationIcon.end, margin = 5.dp)
                                top.linkTo(deliverText.bottom, margin = 2.dp)

                            }
                            .wrapContentSize()
                    ) {
                        Text(
                            text = "Baridhara Diplomatic Zone...",
                            style = MaterialTheme.typography.subtitle2,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            color = FigBlack
                        )

                        PainterIcon(
                            painter = painterResource(id = R.drawable.ic_baseline_keyboard_arrow_down_24),
                            modifier = Modifier,

                            tint = FigBlack
                        )
                    }



                    Box(
                        modifier = Modifier
                            .constrainAs(searchBox) {
                                start.linkTo(parent.start, margin = 12.dp)
                                top.linkTo(addressText.bottom, margin = 5.dp)

                            }
                            .width(250.dp)
                    ){
                        SearchBar(
                            text = "Search for restaurant name...",
                            onClick = {}
                        )
                    }

                    Box(
                        modifier = Modifier
                            .constrainAs(filterBox) {
                                //start.linkTo(deliverText.end, margin = 5.dp)
                                end.linkTo(parent.end, margin = 5.dp)
                                top.linkTo(profileBox.bottom, margin = 5.dp)

                            }
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color.White)
                    ){
                        PainterIcon(
                            painter = painterResource(id = R.drawable.filter),
                            modifier = Modifier
                                .padding(10.dp)
                                .height(22.dp)
                                .width(22.dp),
                            tint = FigCrimson
                        )
                    }


                }
            }
        },
        bottomBar = { BottomNavigationBar() }
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            ///.........Image Slider........../////
            item { Spacer(modifier = Modifier.height(16.dp)) }

            item {
                Column(
                    modifier = Modifier,
                    horizontalAlignment = Alignment.CenterHorizontally,

                ){
                    val pagerState = rememberPagerState(initialPage = 0)
                    HorizontalPager(
                        count = data.imageSliderItems.size,
                        state = pagerState,
                        contentPadding = PaddingValues(end = 120.dp),
                        modifier = Modifier
                            .wrapContentSize()

                    ) { currentPage ->
                        SliderItemCard(
                            sliderMenuItem = data.imageSliderItems[currentPage],
                            onClick = {}
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    HorizontalPagerIndicator(
                        totalDots = data.imageSliderItems.size,
                        selectedIndex = pagerState.currentPage,
                        selectedColor = FigCrimson,
                        unSelectedColor = FigHint,
                    )
                }
            }


            ///.........Circular List........../////
            item { Spacer(modifier = Modifier.height(16.dp)) }

            item {
                LazyRow(

                ) {
                    item { Spacer(modifier = Modifier.width(16.dp)) }

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
                    items(data.featuredMenuItems) { menuItem ->
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
                    items(data.sweetToothItems) { menuItem ->
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

            items(data.allRestaurantsMenuItems) { menuItem ->
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
