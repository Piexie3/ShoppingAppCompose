package com.example.spotimusic.feature_products.presentation.profile

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.spotimusic.navigation.BottomNavItem
import com.example.spotimusic.navigation.BottomNavMenu

@Composable
fun ProfileScreen(
    navController: NavController
) {
    Scaffold(
        bottomBar = {
            BottomAppBar(
                modifier = Modifier.wrapContentHeight(),
                backgroundColor = Color.Black,
                cutoutShape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
            ) {
                BottomNavMenu(selectedItem = BottomNavItem.PROFILE, navController = navController)

            }
        }
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Profile Screen",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 32.sp,
                    color = Color.Black
                )
            }
        }
    }
}
