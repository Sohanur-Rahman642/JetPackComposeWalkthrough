package com.example.jetpackcomposewalkthrough.ui


//
//@OptIn(ExperimentalUnitApi::class, ExperimentalFoundationApi::class)
//@ExperimentalPagerApi
//@Composable
//fun TestScreen() {
//    val data = SectionRepository.getMenuSections()
//    val scope = rememberCoroutineScope()
//
//    val sectionsListState = rememberLazyListState()
//    val itemsListState = rememberLazyListState()
//    var selectedSectionIndex by remember { mutableStateOf(0) }
//
//    val showWhiteAppBar by remember {
//        derivedStateOf {
//            itemsListState.firstVisibleItemIndex > 0
//        }
//    }
//
//    val onPostScroll : () -> Unit = {
//        val currentSectionIndex = itemsListState.firstVisibleItemIndex
//        println("currentSectionIndex12345 $currentSectionIndex")
//        println("selectedSectionIndex12345 $selectedSectionIndex")
//        if (selectedSectionIndex != currentSectionIndex) {
//            selectedSectionIndex = currentSectionIndex
//
//            scope.launch {
//                sectionsListState.animateScrollToItem(currentSectionIndex)
//            }
//        }
//    }
//
//    Box(){
//
//        LazyColumn(
//            state = itemsListState,
//            modifier = Modifier
//                .padding()
//                .nestedScroll(object : NestedScrollConnection {
//                    override fun onPostScroll(
//                        consumed: Offset,
//                        available: Offset,
//                        source: NestedScrollSource
//                    ): Offset {
//                        onPostScroll()
//                        return super.onPostScroll(consumed, available, source)
//                    }
//                })
//        ) {
//
//            item {
//                Box(
//                    modifier = Modifier
//                        .fillParentMaxWidth()
//
//                ) {
//                    Image(
//                        //painterResource(menuItem.image.removePrefix("drawable://").toInt()),
//                        painterResource(R.drawable.burger_xpress_cover),
//                        contentDescription = "",
//                        contentScale = ContentScale.Crop,
//                        modifier = Modifier
//                            .height(250.dp)
//                            .fillMaxWidth()
//                    )
//
//                }
//            }
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
//
//
//
//            stickyHeader {
//
//                MenuSectionsView(
//                    selectedIndex = selectedSectionIndex,
//                    menuSections = data,
//                    sectionsListState = sectionsListState,
//                    onClick = { sectionIndex ->
//                        println("sectionIndex $sectionIndex")
//                        selectedSectionIndex = sectionIndex
//
//
//                        scope.launch {
//                            sectionsListState.animateScrollToItem(sectionIndex)
//                            itemsListState.animateScrollToItem(sectionIndex)
//                        }
//                    }
//                )
//
//                Divider()
//            }
//
////            item {
////                Spacer(modifier = Modifier.height(60.dp))
////            }
//
//            data.forEach { section ->
//                item {
//                    Text(
//                        modifier = Modifier.padding(10.dp),
//                        text = section.title,
//                        style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),
//                        color = FigCrimson
//                    )
//                    MenuItemView(section)
//                }
//            }
//        }
//
//        CustomTopAppBar(itemsListState, onBackClick = {}, showWhiteAppBar = showWhiteAppBar)
//    }
//}
//
//
//
//@Composable
//fun MenuItemView(section: MenuSections) {
//    Column() {
//        section.menuItems.forEach { menuItem ->
//                MenuItemCard(menuItem = menuItem, onClick = { /*TODO*/ }, type = Constants.TYPE_VERTICAL)
//                Spacer(modifier = Modifier.height(10.dp))
//            }
//        }
//}
//
//
//@Composable
//fun MenuSectionsView(
//    selectedIndex: Int,
//    menuSections: List<MenuSections>,
//    sectionsListState: LazyListState,
//    onClick: (sectionIndex: Int) -> Unit,
//) {
//    LazyRow(
//        modifier = Modifier.padding().background(Color.White),
//        state = sectionsListState
//    ) {
//        menuSections.forEachIndexed { i, section ->
//            item {
//                SectionTextView(
//                    modifier = Modifier
//                        .padding(horizontal = 10.dp)
//                        .clickable { onClick(i) },
//                    text = section.title,
//                    isSelected = selectedIndex == i
//                )
//            }
//        }
//    }
//}
//
//
//@Composable
//fun SectionTextView(
//    modifier: Modifier = Modifier,
//    text: String,
//    isSelected: Boolean
//) {
//    Column(modifier) {
//        var textWidth by remember { mutableStateOf(0.dp) }
//        val density = LocalDensity.current
//
//        Text(
//            modifier = Modifier.onGloballyPositioned {
//                textWidth = with(density) { it.size.width.toDp() } //update text width value according to the content size
//            },
//            text = text,
//            style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),
//            color = if (isSelected) FigCrimson else Color.DarkGray
//        )
//
//        //Show the text underline with animation
//        AnimatedVisibility(
//            visible = isSelected,
//            enter = expandHorizontally() + fadeIn(),
//            exit = shrinkHorizontally() + fadeOut()
//        ) {
//            Box(
//                Modifier
//                    .width(textWidth)
//                    .padding(top = 15.dp)
//                    .height(3.dp)
//                    .background(FigCrimson)
//            ) {}
//        }
//    }
//}






