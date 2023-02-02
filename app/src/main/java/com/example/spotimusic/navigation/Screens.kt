package com.example.spotimusic.navigation

sealed class Screens(val route: String) {
    object HomeScreen : Screens("Home_screen")
    object SearchScreen : Screens("Search_screen")
    object ProfileScreen : Screens("Profile_screen")
    object WalletScreen : Screens("Payments_screen")
    object HelpScreen : Screens("Help_screen")
    object CartScreen : Screens("Cart_screen")
}