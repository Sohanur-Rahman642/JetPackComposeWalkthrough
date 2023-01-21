package com.example.jetpackcomposewalkthrough.model

data class Home(
    val user: User,
    val categories: List<Category>,
    val popularMenuItems: List<ResturantDishDetails>,
    val featuredMenuItems: List<ResturantDishDetails>,
    val sweetToothItems: List<ResturantDishDetails>,
    val allRestaurantsMenuItems: List<ResturantDishDetails>,
    val circularMenuItems: List<CircularMenuItem>,
    val imageSliderItems: List<SliderMenuItem>
)
