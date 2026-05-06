package com.example.simpleshop.model

data class Product(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val imageRes: Int = 0 // Placeholder
)

data class CartItem(
    val product: Product,
    var quantity: Int
)

data class User(
    val username: String,
    val email: String,
    val isLoggedIn: Boolean = false
)
