package com.example.jetpackcomposewalkthrough.ui.details

import android.annotation.SuppressLint
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.animation.*
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.Velocity
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.jetpackcomposewalkthrough.R
import com.example.jetpackcomposewalkthrough.data.SectionRepository
import com.example.jetpackcomposewalkthrough.model.MenuSections
import com.example.jetpackcomposewalkthrough.ui.components.*
import com.example.jetpackcomposewalkthrough.ui.theme.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.math.abs
import kotlin.math.roundToInt


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DetailsScreen(
    itemId: Long,
    onBackClick: () -> Unit,
) {

    ////Modal BottomSheet
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

    //data
    val data = SectionRepository.getMenuSections()
    val menuItem = data.flatMap { it.menuItems }.find { it.id == 1017L }


    val appBarHeight = 400.dp
    var height by remember {
        mutableStateOf(0f)
    }

    println("height77 $height")

    val density = LocalDensity.current
    val animatedHeight by animateDpAsState(targetValue = with(density){height.toDp()})

    val lazyListState = rememberLazyListState()

    val showWhiteAppBar by remember {
        derivedStateOf {
            height < 10f || lazyListState.firstVisibleItemIndex > 0
        }
    }


    var textWidth by remember { mutableStateOf(0.dp) }


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
        Box(modifier = Modifier.fillMaxSize()){
            Column(modifier = Modifier.fillMaxWidth()){
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .height(height = animatedHeight)
                    .background(Color.White)

                ){
                    Image(
                        painterResource(R.drawable.burger_xpress_cover),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .height(250.dp)
                            .fillMaxWidth()
                    )

                    Column(
                        modifier = Modifier
                            .height(150.dp)
                            .fillMaxWidth()
                            .background(Color.White)
                    ) {

                        Row(
                            modifier  = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(
                                modifier = Modifier.width(350.dp)
                            ) {
                                Text(
                                    modifier = Modifier
                                        .padding(start = 15.dp, end = 10.dp, top=15.dp)
                                        ,
                                    text = "Burger Xpress Banani",
                                    style = MaterialTheme.typography.h6,
                                    color = Color.Black
                                )

                                Text(
                                    modifier = Modifier
                                        .padding(start = 15.dp, end = 10.dp, top= 5.dp)
                                        ,
                                    text = "House-33, 17, Block-E, Road Abdul Alim Nakib Road, Dhaka 1213",
                                    maxLines = 2,
                                    style = MaterialTheme.typography.body1,
                                    color = FigPrimaryBodyColor
                                )

                                Row(
                                    modifier = Modifier
                                        .padding(start = 15.dp, end = 10.dp, top= 5.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceAround
                                ){
                                    Surface() {
                                        Row(
                                            verticalAlignment = Alignment.CenterVertically
                                        ){
                                            Icon(
                                                imageVector = ImageVector.vectorResource(id = R.drawable.ic_baseline_add_circle_24),
                                                modifier = Modifier
                                                    .size(24.dp)
                                                    .padding(5.dp),
                                                tint = FigCrimson
                                            )
                                            Text(
                                                modifier = Modifier.padding(start = 2.dp),
                                                text = "Delivery 40min",
                                                maxLines = 2,
                                                style = MaterialTheme.typography.body2,
                                                color = FigPrimaryBlack
                                            )
                                        }

                                    }

                                    Surface() {
                                        Row(
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Icon(
                                                imageVector = ImageVector.vectorResource(id = R.drawable.ic_baseline_add_circle_24),
                                                modifier = Modifier
                                                    .size(24.dp)
                                                    .padding(5.dp),
                                                tint = FigCrimson
                                            )
                                            Text(
                                                modifier = Modifier.padding(start = 2.dp),
                                                text = "1.4km away",
                                                maxLines = 2,
                                                style = MaterialTheme.typography.body2,
                                                color = FigPrimaryBlack
                                            )
                                        }
                                    }
                                }


                                Row(){
                                    Surface() {

                                    }

                                    Surface() {

                                    }
                                }
                            }

                            Column(
                                modifier = Modifier.padding(end = 10.dp, top = 15.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Surface(
                                    modifier = Modifier,
                                    shape = RoundedCornerShape(8.dp)
                                ) {
                                    Image(
                                        painterResource(R.drawable.burger_xpress_cover),
                                        contentDescription = "",
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .height(70.dp)
                                            .width(80.dp)
                                    )
                                }

                                Surface(
                                    modifier = Modifier
                                        .padding(top = 10.dp),

                                    shape =  MaterialTheme.shapes.medium,
                                    color = FigMatLightGreen
                                ){
                                    Text(
                                        text = "More info",
                                        textAlign = TextAlign.Center,
                                        style = MaterialTheme.typography.button,
                                        maxLines = 1,
                                        modifier = Modifier.padding(5.dp),
                                        color = FigGreen
                                    )
                                }
                            }
                        }


                    }
                }
                LazyScrollView(onOffsetChanged = {
                    Log.d("OFFSET","$it")
                    height = it
                },
                    appBarHeight = appBarHeight,
                    lazyListState = lazyListState
                )
            }
             CustomTopAppBar(lazyListState = lazyListState, showWhiteAppBar = showWhiteAppBar, onBackClick)

        }

    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LazyScrollView(
    onOffsetChanged: (Float) -> Unit,
    appBarHeight: Dp,
    lazyListState: LazyListState,
){

    val data = SectionRepository.getMenuSections()
    val coroutineScope = rememberCoroutineScope()
    val modalSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        confirmStateChange = { it != ModalBottomSheetValue.HalfExpanded },
        skipHalfExpanded = true
    )

    val sectionsListState = rememberLazyListState()
    var selectedSectionIndex by remember { mutableStateOf(0) }


    val pixelValue = with(LocalDensity.current){appBarHeight.toPx()}
    val nestedScrollState = rememberNestedScrollConnection(onOffsetChanged = onOffsetChanged, appBarHeight = pixelValue)
    LaunchedEffect(key1 = Unit, block = {
        onOffsetChanged(pixelValue)
    })


    BoxWithConstraints(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
        .nestedScroll(nestedScrollState)
    ) {
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

                       if( sectionIndex > 0) {
                           onOffsetChanged(120f)
                       }else{
                           onOffsetChanged(918f)
                       }
                   }
               )

               Divider(
                   modifier = Modifier.shadow(elevation = 2.dp)
               )


               MenuItemsView(
                   data = data,
                   lazyListState = lazyListState,
                   coroutineScope = coroutineScope,
                   modalSheetState = modalSheetState,
                   onPostScroll = {
                       val currentSectionIndex = lazyListState.firstVisibleItemIndex
                       if (selectedSectionIndex != currentSectionIndex) {
                           selectedSectionIndex = currentSectionIndex

                           coroutineScope.launch {
                               sectionsListState.animateScrollToItem(currentSectionIndex)
                           }
                       }
                   }
               )
           }
    }

}


@Composable
fun rememberNestedScrollConnection(onOffsetChanged:(Float)->Unit,appBarHeight:Float) = remember {
    var currentHeight = appBarHeight
    object : NestedScrollConnection {
        override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
            Log.d("AVAILABLE","$available")
            currentHeight = (currentHeight+available.y).coerceIn(minimumValue = 0f, maximumValue = appBarHeight)
            return if(abs(currentHeight) == appBarHeight || abs(currentHeight) == 0f){
                super.onPreScroll(available, source)
            }else{
                onOffsetChanged(currentHeight)
                available
            }
        }

        override suspend fun onPreFling(available: Velocity): Velocity {
            if(available.y<0){
                onOffsetChanged(0f)
            }else{
                onOffsetChanged(appBarHeight)
            }
            return super.onPreFling(available)
        }
    }
}


@Composable
fun MenuSectionsView(
    selectedIndex: Int,
    menuSections: List<MenuSections>,
    sectionsListState: LazyListState,
    onClick: (sectionIndex: Int) -> Unit,
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
                    modifier = Modifier
                        .padding(start = 15.dp, top = 15.dp)
                        .clickable { onClick(i) },

                    text = section.title,
                    isSelected = selectedIndex == i
                )
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


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MenuItemsView(
    data: List<MenuSections>,
    lazyListState: LazyListState,
    coroutineScope: CoroutineScope,
    modalSheetState: ModalBottomSheetState,
    onPostScroll: () -> Unit
) {
    LazyColumn(
        state = lazyListState,
        modifier = Modifier
            .fillMaxSize()
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


@Preview("HomeScreen")
@Composable
private fun CategoryScreenPreview() {
    JetPackComposeWalkthroughTheme {
        DetailsScreen(
            itemId = 4004,
            onBackClick = {},
        )
    }
}