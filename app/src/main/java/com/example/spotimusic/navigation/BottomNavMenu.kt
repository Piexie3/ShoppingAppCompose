package com.example.spotimusic.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Help
import androidx.compose.material.icons.outlined.AccountBalanceWallet
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.HomeWork
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

enum class BottomNavItem(val icon: ImageVector, val route: String){
    HOME(Icons.Outlined.HomeWork, Screens.HomeScreen.route),
    CART(Icons.Outlined.ShoppingCart, Screens.CartScreen.route),
    WALLET(Icons.Outlined.AccountBalanceWallet, Screens.WalletScreen.route),
    HELP(Icons.Default.Help, Screens.HelpScreen.route),
    PROFILE(Icons.Outlined.AccountCircle, Screens.ProfileScreen.route),

}

@Composable
fun BottomNavMenu(
    selectedItem: BottomNavItem,
    navController: NavController
) {
    Row(){
        for (item in BottomNavItem.values()) {
            Image(
                imageVector = item.icon,
                contentDescription = "Image Item",
                modifier = Modifier
                    .size(40.dp)
                    .weight(1f)
                    .padding(5.dp)
                    .clickable {
                        navController.navigate(item.route)
                    },
                colorFilter = if (item == selectedItem)
                    ColorFilter.tint(Color.White) else
                        ColorFilter.tint(Color.DarkGray)
            )
        }
    }
}