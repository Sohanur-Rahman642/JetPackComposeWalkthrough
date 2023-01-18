package com.example.jetpackcomposewalkthrough.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.*
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.rememberImagePainter
import com.example.jetpackcomposewalkthrough.R
import com.example.jetpackcomposewalkthrough.ui.components.CustomTopAppBar
import com.example.jetpackcomposewalkthrough.ui.components.PainterIcon
import com.example.jetpackcomposewalkthrough.ui.theme.*
import com.google.accompanist.pager.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.launch



@Composable
fun ImageLoader(imageUrl: String){
    Image(
        painter = rememberImagePainter(imageUrl),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.size(120.dp)
    )
}


@OptIn(ExperimentalUnitApi::class, ExperimentalFoundationApi::class)
@ExperimentalPagerApi
@Composable
fun TestScreen() {
    val lazyListState = rememberLazyListState()
    val smartTabsContent = generateContent()
    val tabs = smartTabsContent.filter { it is TabData.Header }
    val indexes = smartTabsContent.mapTabs(isTab = {it is TabData.Header})
    val selectedTabIndex = remember { mutableStateOf(0) }
    val coroutineScope = rememberCoroutineScope()

    val showWhiteAppBar by remember {
        derivedStateOf {
            lazyListState.firstVisibleItemIndex > 0
        }
    }

    LaunchedEffect(smartTabsContent, lazyListState) {
        snapshotFlow { lazyListState.firstVisibleItemIndex }
            .mapNotNull {
                val tabData = smartTabsContent.getOrNull(it)
                indexes[tabData]
            }
            .distinctUntilChanged()
            .collectLatest {
                selectedTabIndex.value = it
            }
    }

    val scrollToItem = scroller(
        verticalListState = lazyListState,
        coroutineScope = coroutineScope,
        smartTabsContent = smartTabsContent,
    )

    Box(
        modifier = Modifier
            .background(FigBG1)
    ){

        LazyColumn(
            state = lazyListState,
        ){
            item {
            Box(
                modifier = Modifier
                    .fillParentMaxWidth()

            ) {
                Image(
                    //painterResource(menuItem.image.removePrefix("drawable://").toInt()),
                    painterResource(R.drawable.burger_xpress_cover),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(250.dp)
                        .fillMaxWidth()
                )

            }
        }

            item {
                ConstraintLayout(
                    modifier = Modifier
                        .height(100.dp)
                        .background(Color.White)
                ) {

                }
            }

            stickyHeader {
                AnimatedVisibility(
                    visible = true,
                        modifier = when ( showWhiteAppBar) {
                            true -> {
                                Modifier.background(Color.White).padding(top = 60.dp)
                            }
                            else -> {
                                Modifier.background(Color.White).padding(top = 10.dp)
                            }
                        }
                ) {
                    SmartTabs(
                        selectedTabIndex = selectedTabIndex.value,
                        onTabSelected = {
                            selectedTabIndex.value = it
                        },
                        scrollToItem = scrollToItem,
                        tabs = tabs,
                        smartTab = { tabData, _ ->
                            Text(
                                modifier = Modifier
                                    .padding(14.dp)
                                    .fillMaxWidth(),
                                text = tabData.title,
                                style = MaterialTheme.typography.subtitle1,
                                color = FigHint
                            )
                        },
                    )
                }


            }

            items( smartTabsContent ){ it ->
                Text(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    text = it.title,
                    style = MaterialTheme.typography.body1
                )
            }

        }
        CustomTopAppBar(lazyListState, onBackClick = {}, showWhiteAppBar = showWhiteAppBar)

    }
}



private fun generateContent(): List<TabData> = buildList {
    repeat(100) {
        if (it % 15 == 0) {
            add(TabData.Header("Header - $it"))
        } else {
            add(TabData.Item("Item - $it"))
        }
    }
}

fun <T> List<T>.mapTabs(isTab: (T) -> Boolean): Map<T, Int> = buildMap {
    var headerIndex = -1 // Tabs are zero-based. -1 means tha no tab exist
    this@mapTabs.forEach {
        if (isTab(it)) {
            headerIndex++
        }
        this[it] = headerIndex
    }
}


@Composable
private fun <T> SmartTabs(
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit,
    scrollToItem: (T) -> Unit,
    tabs: List<T>,
    smartTab: @Composable (T, Boolean) -> Unit,
) {
    ScrollableTabRow(
        selectedTabIndex = selectedTabIndex,
        edgePadding = 0.dp,
        backgroundColor = Color.White,
        contentColor = FigCrimson
    ) {
        tabs.forEachIndexed { index, item ->
            Tab(
                selected = selectedTabIndex == index,
                onClick = {
                    onTabSelected(index)
                    scrollToItem(item)
                }
            ) {
                smartTab(item, selectedTabIndex == index)
            }
        }
    }
}


private fun <T> scroller(
    verticalListState: LazyListState,
    coroutineScope: CoroutineScope,
    smartTabsContent: List<T>,
): (T) -> Unit = {
    coroutineScope.launch {
        val tabIndex = smartTabsContent.indexOf(it)
        verticalListState.animateScrollToItem(index = tabIndex)
    }
}




sealed class TabData(open val title: String) {

    data class Header(override val title: String) : TabData(title = title)

    data class Item(override val title: String) : TabData(title = title)
}

