package com.example.jetpackcomposewalkthrough.ui.details

import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.compose.animation.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.jetpackcomposewalkthrough.R
import com.example.jetpackcomposewalkthrough.data.SectionRepository
import com.example.jetpackcomposewalkthrough.model.MenuSections
import com.example.jetpackcomposewalkthrough.ui.components.*
import com.example.jetpackcomposewalkthrough.ui.theme.FigCrimson
import com.example.jetpackcomposewalkthrough.ui.theme.JetPackComposeWalkthroughTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterialApi::class)
@Composable
fun DetailsScreen(
    itemId: Long,
    onBackClick: () -> Unit,
    lazyListState: LazyListState
) {

    val data = SectionRepository.getMenuSections()
    val menuItem = data.flatMap { it.menuItems }.find { it.id == 1017L }


    ////BottomSheet
    val coroutineScope = rememberCoroutineScope()
    val modalSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        confirmStateChange = { it != ModalBottomSheetValue.HalfExpanded },
        skipHalfExpanded = true
    )


    var isSheetFullScreen by remember { mutableStateOf(false) }
    val roundedCornerRadius = if (isSheetFullScreen) 0.dp else 12.dp
    val bottomSheetModifier = if (isSheetFullScreen)
        Modifier
            .fillMaxSize()
    else
        Modifier.fillMaxWidth()

    BackHandler(modalSheetState.isVisible) {
        coroutineScope.launch { modalSheetState.hide() }
    }

    val sectionsListState = rememberLazyListState()
    var selectedSectionIndex by remember { mutableStateOf(0) }

    val showWhiteAppBar by remember {
        derivedStateOf {
            lazyListState.firstVisibleItemIndex > 0
        }
    }

    val onPostScroll : () -> Unit = {
        val currentSectionIndex = lazyListState.firstVisibleItemIndex
        if (selectedSectionIndex != currentSectionIndex) {
            selectedSectionIndex = currentSectionIndex

            coroutineScope.launch {
                sectionsListState.animateScrollToItem(currentSectionIndex)
            }
        }
    }


    ModalBottomSheetLayout(
        sheetShape = RoundedCornerShape(topStart = roundedCornerRadius, topEnd = roundedCornerRadius),
        sheetState = modalSheetState,
        sheetContent = {
            Column(
                modifier = bottomSheetModifier.background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                menuItem?.let { BottomSheetContent(it) }
                Button(
                    onClick = {
                        isSheetFullScreen = !isSheetFullScreen
                    }
                ) {
                    Text(text = "Toggle Sheet Fullscreen")
                }

                Button(
                    onClick = {
                        coroutineScope.launch { modalSheetState.hide() }
                    }
                ) {
                    Text(text = "Hide Sheet")
                }
            }
        }
    ){
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .nestedScroll(object : NestedScrollConnection {
                    override fun onPostScroll(
                        consumed: Offset,
                        available: Offset,
                        source: NestedScrollSource
                    ): Offset {
                        onPostScroll()
                        return super.onPostScroll(consumed, available, source)
                    }
                })
        ){

            when ( showWhiteAppBar ){
                true -> {
                    Column() {
                        MenuSectionsView(
                            selectedIndex = selectedSectionIndex,
                            menuSections = data,
                            sectionsListState = sectionsListState,
                            onClick = { sectionIndex ->
                                selectedSectionIndex = sectionIndex

                                coroutineScope.launch {
                                    sectionsListState.animateScrollToItem(sectionIndex)
                                    lazyListState.animateScrollToItem(sectionIndex)
                                }
                            },
                            showWhiteAppBar = true
                        )

                        Divider()

                        LazyColumn(state = lazyListState,) {
                            items(data) { section ->
                                Text(
                                    modifier = Modifier.padding(16.dp),
                                    text = section.title,
                                    style = MaterialTheme.typography.subtitle1,
                                    color = FigCrimson
                                )
                                MenuItemView(
                                    section = section,
                                    coroutineScope = coroutineScope,
                                    modalSheetState = modalSheetState,
                                )
                            }
                        }
                    }

                }
                else -> {
                    LazyColumn(
                        state = lazyListState,
                        modifier = Modifier

                    ) {

                        item {
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

                        item {
                            ConstraintLayout(
                                modifier = Modifier
                                    .height(100.dp)
                                    .background(Color.White)
                            ) {

                            }
                        }

                        stickyHeader {

                            MenuSectionsView(
                                selectedIndex = selectedSectionIndex,
                                menuSections = data,
                                sectionsListState = sectionsListState,
                                onClick = { sectionIndex ->
                                    selectedSectionIndex = sectionIndex

                                    coroutineScope.launch {
                                        sectionsListState.animateScrollToItem(sectionIndex)
                                        lazyListState.animateScrollToItem(sectionIndex)
                                    }
                                },
                                showWhiteAppBar = false
                            )


                        }

                        item {
                            Divider()
                        }


                        items(data) { section ->
                            Text(
                                modifier = Modifier.padding(16.dp),
                                text = section.title,
                                style = MaterialTheme.typography.subtitle1,
                                color = FigCrimson
                            )
                            MenuItemView(
                                section = section,
                                coroutineScope = coroutineScope,
                                modalSheetState = modalSheetState,
                            )
                        }
                    }
                }
            }
            CustomTopAppBar(
                lazyListState,
                onBackClick = onBackClick,
                showWhiteAppBar = showWhiteAppBar
            )
        }
    }

}


@Composable
fun MenuSectionsView(
    selectedIndex: Int,
    menuSections: List<MenuSections>,
    sectionsListState: LazyListState,
    onClick: (sectionIndex: Int) -> Unit,
    showWhiteAppBar: Boolean
) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White),

        state = sectionsListState
    ) {
        item {
            Spacer(modifier = Modifier.width(16.dp))
        }
        menuSections.forEachIndexed { i, section ->
            item {
                SectionTextView(
                    modifier = when ( showWhiteAppBar ) {
                        true -> {
                            Modifier
                                .padding(start = 15.dp, top = 65.dp)
                                .clickable { onClick(i) }
                        }
                        else -> {
                            Modifier
                                .padding(start = 15.dp, top = 10.dp)
                                .clickable { onClick(i) }
                        }
                    },
                    text = section.title,
                    isSelected = selectedIndex == i
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MenuItemView(
    section: MenuSections,
    coroutineScope: CoroutineScope,
    modalSheetState: ModalBottomSheetState
) {
    Column() {
        when(section.title){
            "Popular" -> {
                LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)){
                    item { Spacer(modifier = Modifier.width(10.dp)) }
                    items(section.menuItems) { menuItem ->
                        RestaurantMenuItemCard(
                            menuItem = menuItem,
                            onClick = {
                                coroutineScope.launch {
                                    if (modalSheetState.isVisible)
                                        modalSheetState.hide()
                                    else
                                        modalSheetState.animateTo(ModalBottomSheetValue.Expanded)
                                }
                            }
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }
            else -> {
                section.menuItems.forEach { menuItem ->
                    ResVerticalMenuItemCard(menuItem = menuItem, onClick = {
                        coroutineScope.launch {
                            if (modalSheetState.isVisible)
                                modalSheetState.hide()
                            else
                                modalSheetState.animateTo(ModalBottomSheetValue.Expanded)
                        }
                    })
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }
    }
}


@Composable
fun SectionTextView(
    modifier: Modifier = Modifier,
    text: String,
    isSelected: Boolean
) {
    Column(modifier) {
        var textWidth by remember { mutableStateOf(0.dp) }
        val density = LocalDensity.current

        Text(
            modifier = Modifier.onGloballyPositioned {
                textWidth = with(density) { it.size.width.toDp() } //update text width value according to the content size
            },
            text = text,
            style = MaterialTheme.typography.subtitle1,
            color = if (isSelected) FigCrimson else Color.DarkGray
        )

        //Show the text underline with animation
        AnimatedVisibility(
            visible = isSelected,
            enter = expandHorizontally() + fadeIn(),
            exit = shrinkHorizontally() + fadeOut()
        ) {
            Box(
                Modifier
                    .width(textWidth)
                    .padding(top = 15.dp)
                    .height(5.dp)
                    .background(FigCrimson)
            ) {}
        }
    }
}



@Preview("HomeScreen")
@Composable
private fun CategoryScreenPreview() {
    JetPackComposeWalkthroughTheme {
        DetailsScreen(
            itemId = 4004,
            onBackClick = {},
            rememberLazyListState()
        )
    }
}