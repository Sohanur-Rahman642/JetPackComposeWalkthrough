package com.example.jetpackcomposewalkthrough.model

data class Home(
    val user: User,
    val categories: List<Category>,
    val popularMenuItems: List<MenuItem>,
    val recommendedMenuItems: List<MenuItem>,
    val circularMenuItems: List<CircularMenuItem>,
    val imageSliderItems: List<SliderMenuItem>
)