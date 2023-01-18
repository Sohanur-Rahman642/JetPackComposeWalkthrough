package com.example.jetpackcomposewalkthrough.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.*
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.jetpackcomposewalkthrough.R
import com.example.jetpackcomposewalkthrough.data.MenuRepository
import com.example.jetpackcomposewalkthrough.model.MenuItem
import com.example.jetpackcomposewalkthrough.ui.components.CustomTopAppBar
import com.example.jetpackcomposewalkthrough.ui.theme.*
import com.google.accompanist.pager.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.launch


val data = MenuRepository.getMenuData()



@OptIn(ExperimentalUnitApi::class, ExperimentalFoundationApi::class)
@ExperimentalPagerApi
@Composable
fun TestScreen() {
    val lazyListState = rememberLazyListState()
    val smartTabsContent = generateContent()
    println("smartTabsContent: $smartTabsContent")
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
                                Modifier
                                    .background(Color.White)
                                    .padding(top = 60.dp)
                            }
                            else -> {
                                Modifier
                                    .background(Color.White)
                                    .padding(top = 10.dp)
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
                                text = tabData.title!!,
                                style = MaterialTheme.typography.subtitle1,
                                color = FigHint
                            )
                        },
                    )
                }


            }

            items( smartTabsContent ){ it ->

                it.title?.let { it1 ->
                    Text(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        text = it1,
                        style = MaterialTheme.typography.body1
                    )
                }
                Spacer(modifier = Modifier.height(60.dp))
            }
        }
        CustomTopAppBar(lazyListState, onBackClick = {}, showWhiteAppBar = showWhiteAppBar)

    }
}



private fun generateContent(): List<TabData> = buildList {
    val groupedItem = data.menuItems.groupBy {
        it.categoryName
    }

    groupedItem.forEach{
        add(TabData.Header(it.key))
        add(TabData.Item(it.value))
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
        println("tabIndex $tabIndex")
        verticalListState.animateScrollToItem(index = tabIndex)
    }
}




sealed class TabData(open val title: String?, open val item: List<MenuItem>?) {

    data class Header(override val title: String) : TabData(title = title, null)

    data class Item(override val item: List<MenuItem>?) : TabData(null, item= item)
}

