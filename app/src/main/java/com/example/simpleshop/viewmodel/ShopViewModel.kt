package com.example.simpleshop.viewmodel

import androidx.lifecycle.ViewModel
import com.example.simpleshop.model.CartItem
import com.example.simpleshop.model.Product
import com.example.simpleshop.model.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ShopViewModel : ViewModel() {

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products.asStateFlow()

    private val _cartItems = MutableStateFlow<List<CartItem>>(emptyList())
    val cartItems: StateFlow<List<CartItem>> = _cartItems.asStateFlow()

    private val _currentUser = MutableStateFlow<User?>(null)
    val currentUser: StateFlow<User?> = _currentUser.asStateFlow()

    init {
        // Initialize with dummy data
        _products.value = listOf(
            Product(1, "Premium Headphones", "Noise cancelling wireless headphones", 299.99),
            Product(2, "Smart Watch", "Track your health and fitness", 199.49),
            Product(3, "Wireless Mouse", "Ergonomic design for long hours", 49.99),
            Product(4, "Mechanical Keyboard", "RGB backlit mechanical keyboard", 89.00),
            Product(5, "USB-C Hub", "Multi-port adapter for your laptop", 35.50),
            Product(6, "Gaming Monitor", "27-inch 144Hz 4K display", 450.00)
        )
    }

    fun login(username: String) {
        _currentUser.value = User(username, "$username@example.com", true)
    }

    fun logout() {
        _currentUser.value = null
        _cartItems.value = emptyList()
    }

    fun addToCart(product: Product) {
        val currentCart = _cartItems.value.toMutableList()
        val existingItem = currentCart.find { it.product.id == product.id }
        if (existingItem != null) {
            existingItem.quantity++
        } else {
            currentCart.add(CartItem(product, 1))
        }
        _cartItems.value = currentCart
    }

    fun removeFromCart(product: Product) {
        val currentCart = _cartItems.value.toMutableList()
        val existingItem = currentCart.find { it.product.id == product.id }
        if (existingItem != null) {
            if (existingItem.quantity > 1) {
                existingItem.quantity--
            } else {
                currentCart.remove(existingItem)
            }
        }
        _cartItems.value = currentCart
    }

    fun getCartTotal(): Double {
        return _cartItems.value.sumOf { it.product.price * it.quantity }
    }
}
