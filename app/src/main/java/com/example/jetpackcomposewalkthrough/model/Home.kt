package com.example.jetpackcomposewalkthrough.model

data class Home(
    val user: User,
    val categories: List<Category>,
    val popularMenuItems: List<MenuItem>,
    val featuredMenuItems: List<MenuItem>,
    val sweetToothItems: List<MenuItem>,
    val allRestaurantsMenuItems: List<MenuItem>,
    val circularMenuItems: List<CircularMenuItem>,
    val imageSliderItems: List<SliderMenuItem>
)
