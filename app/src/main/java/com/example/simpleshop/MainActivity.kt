package com.example.simpleshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.simpleshop.ui.screens.CartScreen
import com.example.simpleshop.ui.screens.HomeScreen
import com.example.simpleshop.ui.theme.SimpleShopTheme
import com.example.simpleshop.viewmodel.ShopViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleShopTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ShopApp()
                }
            }
        }
    }
}

@Composable
fun ShopApp() {
    val viewModel: ShopViewModel = viewModel()
    val navController = rememberNavController()

    val homeRoute = stringResource(R.string.home_route)
    val cartRoute = stringResource(R.string.cart_route)

    NavHost(
        navController = navController,
        startDestination = homeRoute
    ) {
        composable(homeRoute) {
            HomeScreen(
                viewModel = viewModel,
                onGoToCart = { navController.navigate(cartRoute) }
            )
        }
        composable(cartRoute) {
            CartScreen(
                viewModel = viewModel,
                onBack = { navController.popBackStack() }
            )
        }
    }
}
