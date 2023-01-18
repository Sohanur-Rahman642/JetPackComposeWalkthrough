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
import com.example.jetpackcomposewalkthrough.constants.Constants
import com.example.jetpackcomposewalkthrough.data.MenuRepository
import com.example.jetpackcomposewalkthrough.model.MenuItem
import com.example.jetpackcomposewalkthrough.ui.components.CustomTopAppBar
import com.example.jetpackcomposewalkthrough.ui.components.MenuItemCard
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
    println("indexes $indexes")
    val selectedTabIndex = remember { mutableStateOf(0) }
    println("selectedTabIndex ${selectedTabIndex.value}")
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
                println("tabData $tabData")
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
//            item {
//            Box(
//                modifier = Modifier
//                    .fillParentMaxWidth()
//
//            ) {
//                Image(
//                    //painterResource(menuItem.image.removePrefix("drawable://").toInt()),
//                    painterResource(R.drawable.burger_xpress_cover),
//                    contentDescription = "",
//                    contentScale = ContentScale.Crop,
//                    modifier = Modifier
//                        .height(250.dp)
//                        .fillMaxWidth()
//                )
//
//            }
//        }
//
//            item {
//                ConstraintLayout(
//                    modifier = Modifier
//                        .height(100.dp)
//                        .background(Color.White)
//                ) {
//
//                }
//            }

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

            smartTabsContent.forEach {tabs->
                                item {
                                    tabs.title?.let { title ->
                                        Text(
                                            modifier = Modifier
                                                .padding(16.dp)
                                                .fillMaxWidth(),
                                            text = title,
                                            style = MaterialTheme.typography.body1
                                        )
                                    }
                                }

                                tabs.items?.let {
                                    items( it ) { item->
                                        Spacer(modifier = Modifier.width(16.dp))
                                        MenuItemCard(
                                            menuItem = item,
                                            onClick = {},
                                            type = Constants.TYPE_HORIZONTAL
                                        )
                                        Spacer(modifier = Modifier.height(8.dp))
                                    }
                                }
            }

//            items( smartTabsContent ){ it ->
//                Text(
//                        modifier = Modifier
//                            .padding(16.dp)
//                            .fillMaxWidth(),
//                        text = it.title,
//                        style = MaterialTheme.typography.body1
//                    )
//
////                it.title?.let { it1 ->
////                    Text(
////                        modifier = Modifier
////                            .padding(16.dp)
////                            .fillMaxWidth(),
////                        text = it1,
////                        style = MaterialTheme.typography.body1
////                    )
////                }
////                Spacer(modifier = Modifier.height(60.dp))
//            }


        }
       // CustomTopAppBar(lazyListState, onBackClick = {}, showWhiteAppBar = showWhiteAppBar)

    }
}



private fun generateContent(): List<TabData> = buildList {
    val groupedItem = data.menuItems.groupBy {
        it.categoryName
    }

    println("groupedItem $groupedItem")

    groupedItem.forEach{
        add(TabData.Header(it.key))
        add(TabData.Item( it.value))
    }

//    repeat(100) {
//        if (it % 15 == 0) {
//            add(TabData.Header("Header- $it"))
//        }else{
//            add(TabData.Item("Item- $it"))
//        }
//    }

}

fun <T> List<T>.mapTabs(isTab: (T) -> Boolean): Map<T, Int> = buildMap {
    println("isTab $isTab")
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




sealed class TabData(open val title: String?, open val items: List<MenuItem>?) {

    data class Header(override val title: String) : TabData(title = title, null)

    data class Item( override val items: List<MenuItem>) : TabData( null,  items = items)
}

//data class MenuContainer(
//    var type: String,
//    var items: List<MenuItem>
//)

