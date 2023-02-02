package com.example.spotimusic.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.spotimusic.feature_products.presentation.home.HomeScreen
import com.example.spotimusic.feature_products.presentation.home.products.ProductViewModel
import com.example.spotimusic.feature_products.presentation.cart.CartScreen
import com.example.spotimusic.feature_products.presentation.help.HelpScreen
import com.example.spotimusic.feature_products.presentation.profile.ProfileScreen
import com.example.spotimusic.feature_products.presentation.search.SearchScreen
import com.example.spotimusic.feature_products.presentation.wallet.WalletScreen

@Composable
fun Navigation(
    productViewModel: ProductViewModel,
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Screens.HomeScreen.route
    ){
        composable(route = Screens.HomeScreen.route){
            HomeScreen(productViewModel, navController)
        }
        composable(route = Screens.WalletScreen.route){
            WalletScreen(navController)
        }
        composable(route = Screens.ProfileScreen.route){
            ProfileScreen(navController)
        }
        composable(route = Screens.HelpScreen.route){
            HelpScreen(navController)
        }
        composable(route = Screens.SearchScreen.route){
            SearchScreen()
        }
        composable(route = Screens.CartScreen.route){
            CartScreen(navController)
        }
    }

}
