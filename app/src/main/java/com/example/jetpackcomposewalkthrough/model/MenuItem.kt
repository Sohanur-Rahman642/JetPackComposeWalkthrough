package com.example.jetpackcomposewalkthrough.model

data class MenuItem(
    val id: Long,
    val name: String,
   // val description: String,
    val image: String,
    val price: Int,
    val categoryId: Long,
    val categoryName: String,
    val rating: Float,
    val totalRaters: Int,
    val deliveryDuration: String,
    val discountRate: Int,
    val isFavourite: Boolean,
    //
    var quantity: Int = 0
)