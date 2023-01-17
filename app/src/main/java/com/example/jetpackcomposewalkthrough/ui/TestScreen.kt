package com.example.jetpackcomposewalkthrough.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import androidx.navigation.compose.rememberNavController
import coil.ImageLoader
import coil.compose.rememberImagePainter
import com.example.jetpackcomposewalkthrough.R
import com.example.jetpackcomposewalkthrough.navigation.NavigationConfiguration
import com.example.jetpackcomposewalkthrough.ui.components.BottomNavigationBar
import com.example.jetpackcomposewalkthrough.ui.components.CircularMenuItemCard
import com.example.jetpackcomposewalkthrough.ui.components.PainterIcon
import com.example.jetpackcomposewalkthrough.ui.components.TopAppBar
import com.example.jetpackcomposewalkthrough.ui.theme.FigCrimson
import com.example.jetpackcomposewalkthrough.ui.theme.FigHint
import com.example.jetpackcomposewalkthrough.ui.theme.FigNavUnselect
import com.example.jetpackcomposewalkthrough.ui.theme.FigRed
import com.google.accompanist.pager.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.launch

data class Person(
    val id: Int,
    val section: Int,
    val name: String,
    val imageUrl: String,
    val landingPage: String
)


@Composable
fun ImageLoader(imageUrl: String){
    Image(
        painter = rememberImagePainter(imageUrl),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.size(120.dp)
    )
}

@Composable
fun ListItem(person: Person){
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),

        elevation = 8.dp,
    ) {
        Row{
            ImageLoader(person.imageUrl)
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                person.name+' '+person.id,
                style = MaterialTheme.typography.h5,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}


@OptIn(ExperimentalUnitApi::class, ExperimentalFoundationApi::class)
@ExperimentalPagerApi
@Composable
fun TestScreen() {
    val lazyListState = rememberLazyListState()

    val visibility by remember {
        derivedStateOf {
            when {
                lazyListState.layoutInfo.visibleItemsInfo.isNotEmpty() && lazyListState.firstVisibleItemIndex == 0 -> {
                    val imageSize = lazyListState.layoutInfo.visibleItemsInfo[0].size
                    val scrollOffset = lazyListState.firstVisibleItemScrollOffset

                    scrollOffset / imageSize.toFloat()
                }
                else                                                                                               -> 1f
            }
        }
    }
    val firstItemTranslationY by remember {
        derivedStateOf {
            when {
                lazyListState.layoutInfo.visibleItemsInfo.isNotEmpty() && lazyListState.firstVisibleItemIndex == 0 -> lazyListState.firstVisibleItemScrollOffset * .6f
                else                                                                                               -> 0f
            }
        }
    }

    Column(){
        LazyColumn(state = lazyListState){
            item {
                Box(
                    modifier = Modifier
                        .fillParentMaxWidth()
                        .graphicsLayer {
                            alpha = 1f - visibility
                            translationY = firstItemTranslationY
                        }
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

                    Surface(
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .padding(20.dp)
                            .clip(CircleShape)
                            .background(Color.White),
                    ){
                        com.example.jetpackcomposewalkthrough.ui.components.Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.arrowback),
                            modifier = Modifier
                                .size(25.dp)
                                .padding(5.dp),
                            tint = FigRed
                        )
                    }

                    Row(
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(top = 20.dp, end = 20.dp),
                    ){
                        Surface(
                            modifier = Modifier
                                .clip(CircleShape)
                                .background(Color.White),
                        ){
                            com.example.jetpackcomposewalkthrough.ui.components.Icon(
                                imageVector = ImageVector.vectorResource(id = R.drawable.shareicon),
                                modifier = Modifier
                                    .size(25.dp)
                                    .padding(5.dp),
                                tint = FigRed

                            )
                        }

                        Spacer(Modifier.width(5.dp))

                        Surface(
                            modifier = Modifier
                                .clip(CircleShape)
                                .background(Color.White),
                        ){
                            PainterIcon(
                                painter = painterResource(id = R.drawable.heart),
                                modifier = Modifier
                                    .size(25.dp)
                                    .padding(5.dp),
                                tint = FigRed

                            )
                        }
                    }

                }
            }
            item {
                SmartTabsList(
                    smartTabsContent = generateContent(),
                    smartTab = { tab, _ ->
                        Text(
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxWidth(),
                            text = tab.title,
                            style = MaterialTheme.typography.h6
                        )
                    },
                    smartItem = {
                        Text(
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxWidth(),
                            text = it.title,
                            style = MaterialTheme.typography.body1
                        )
                    }
                )
            }
        }

        SmartTabsItems(
            listState = verticalListState,
            smartTabsContent = smartTabsContent,
            smartItem = {
                Text(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    text = it.title,
                    style = MaterialTheme.typography.body1
                )
            }
        )

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
fun <T> SmartTabsList(
    smartTabsContent: List<T>,
    //isTab: (T) -> Boolean,
    smartTab: @Composable (T, Boolean) -> Unit,
    smartItem: @Composable (T) -> Unit,
){
    val tabs = smartTabsContent.filter { it is TabData.Header }
    val indexes = smartTabsContent.mapTabs(isTab = {it is TabData.Header})
    val selectedTabIndex = remember { mutableStateOf(0) }
    val verticalListState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(smartTabsContent, verticalListState) {
        snapshotFlow { verticalListState.firstVisibleItemIndex }
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
        verticalListState = verticalListState,
        coroutineScope = coroutineScope,
        smartTabsContent = smartTabsContent,
    )

    Column {
        AnimatedVisibility(
            visible = true
        ) {
            SmartTabs(
                selectedTabIndex = selectedTabIndex.value,
                onTabSelected = {
                    selectedTabIndex.value = it
                },
                scrollToItem = scrollToItem,
                tabs = tabs,
                smartTab = smartTab,
            )
        }

//        SmartTabsItems(
//            listState = verticalListState,
//            smartTabsContent = smartTabsContent,
//            smartItem = smartItem,
//        )
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
        edgePadding = 0.dp
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

@Composable
private fun <T> SmartTabsItems(
    listState: LazyListState,
    smartTabsContent: List<T>,
    smartItem: @Composable (T) -> Unit,
) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        state = listState
    ) {
        smartTabsContent.forEach {
            item {
                Box {
                    smartItem(it)
                }
            }
        }
    }
}


sealed class TabData(open val title: String) {

    data class Header(override val title: String) : TabData(title = title)

    data class Item(override val title: String) : TabData(title = title)
}

