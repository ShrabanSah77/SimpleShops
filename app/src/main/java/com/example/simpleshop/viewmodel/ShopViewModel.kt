package com.example.simpleshop.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simpleshop.model.CartItem
import com.example.simpleshop.model.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ShopViewModel : ViewModel() {

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products.asStateFlow()

    private val _cartItems = MutableStateFlow<List<CartItem>>(emptyList())
    val cartItems: StateFlow<List<CartItem>> = _cartItems.asStateFlow()

    init {
        loadProducts()
    }

    private fun loadProducts() {
        viewModelScope.launch(Dispatchers.Default) {
            // Loading products in background to keep UI responsive during startup
            _products.value = listOf(
                Product(1, "Premium Headphones", "Noise cancelling wireless headphones", 299.99, "https://images.unsplash.com/photo-1505740420928-5e560c06d30e?w=400&q=80"),
                Product(2, "Smart Watch", "Track your health and fitness", 199.49, "https://images.unsplash.com/photo-1523275335684-37898b6baf30?w=400&q=80"),
                Product(3, "Wireless Mouse", "Ergonomic design for long hours", 49.99, "https://images.unsplash.com/photo-1527864550417-7fd91fc51a46?w=400&q=80"),
                Product(4, "Mechanical Keyboard", "RGB backlit mechanical keyboard", 89.00, "https://images.unsplash.com/photo-1511467687858-23d96c32e4ae?w=400&q=80"),
                Product(5, "USB-C Hub", "Multi-port adapter for your laptop", 35.50, "https://images.unsplash.com/photo-1540497077202-7c8a3999166f?w=400&q=80"),
                Product(6, "Gaming Monitor", "27-inch 144Hz 4K display", 450.00, "https://images.unsplash.com/photo-1527443224154-c4a3942d3acf?w=400&q=80"),
                Product(7, "Laptop Pro", "Powerful laptop for professionals", 1299.99, "https://images.unsplash.com/photo-1496181133206-80ce9b88a853?w=400&q=80"),
                Product(8, "Digital Camera", "High resolution mirrorless camera", 799.00, "https://images.unsplash.com/photo-1516035069371-29a1b244cc32?w=400&q=80"),
                Product(9, "Bluetooth Speaker", "Portable speaker with deep bass", 59.99, "https://images.unsplash.com/photo-1608156639585-34a072755c96?w=400&q=80"),
                Product(10, "External SSD", "1TB fast external storage", 120.00, "https://images.unsplash.com/photo-1597740985671-2a8a3b80502e?w=400&q=80")
            )
        }
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
