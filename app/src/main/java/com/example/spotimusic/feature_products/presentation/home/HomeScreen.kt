package com.example.spotimusic.feature_products.presentation.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddShoppingCart
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.BottomEnd
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.spotimusic.R
import com.example.spotimusic.feature_products.domain.models.Product
import com.example.spotimusic.feature_products.presentation.home.products.ProductViewModel
import com.example.spotimusic.navigation.BottomNavItem
import com.example.spotimusic.navigation.BottomNavMenu
import com.example.spotimusic.navigation.Screens
import com.example.spotimusic.ui.theme.LightGreen1
import com.example.spotimusic.ui.theme.Teal200

@Composable
fun HomeScreen(
    productviewModel: ProductViewModel,
    navController: NavController
) {

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    Box(modifier = Modifier
                        .clip(RoundedCornerShape(15.dp))
                        .background(Color.Black)) {
                        IconButton(modifier = Modifier.clip(CircleShape), onClick = { /*TODO*/ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_headline),
                                tint = Color.White,
                                contentDescription = "create"
                            )
                        }
                    }
                },
                title = {
                    Text(
                        text = "Bettways",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        fontFamily = FontFamily.SansSerif,
                    )
                },
                actions = {
                    IconButton(onClick = { navController.navigate(Screens.SearchScreen.route) }) {
                        Icon(imageVector = Icons.Default.Search, contentDescription = "search")
                    }
                },
            )

        },
        bottomBar = {
            BottomAppBar(
                modifier = Modifier.wrapContentHeight(),
                backgroundColor = Color.Black,
                cutoutShape = CircleShape
            ) {
                BottomNavMenu(selectedItem = BottomNavItem.HOME, navController = navController)
            }
        }
    ) {

        val categories = productviewModel.categoriesState.value
        val state = productviewModel.productsState.value
        Box(modifier = Modifier.fillMaxSize()) {
            LazyVerticalGrid(columns = GridCells.Fixed(2)
            ) {
                item(span = { GridItemSpan(2) }) {

                    Categories(categories = categories, viewModel = productviewModel)

                }
                item(span = { GridItemSpan(2) }) {
                    Spacer(modifier = Modifier.height(8.dp))
                }
                items(state.products) { product ->
                    ProductItem(
                        product = product,
                        modifier = Modifier
                            .width(150.dp)
                    )
                }
            }
        }
    }
}


@Composable
fun ProductItem(
    product: Product,
    modifier: Modifier,
) {
    Card(
        modifier = modifier
            .padding(4.dp)
            .clickable {

            },
        elevation = 2.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(8.dp)
    ) {
        Box(){
            Column(
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp),
            ) {
                Image(
                    painter = rememberAsyncImagePainter(
                        ImageRequest.Builder(LocalContext.current)
                            .data(data = product.image)
                            .apply(block = fun ImageRequest.Builder.() {
                                placeholder(R.drawable.ic_placeholder)
                                crossfade(true)
                            }).build()
                    ),
                    contentDescription = null,
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = product.title,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = product.category,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.Black,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.ExtraLight
                )
                Spacer(modifier = Modifier.height(8.dp))
                Box(
                    modifier = Modifier,
                ) {
                    Column(verticalArrangement = Arrangement.Top) {
                        Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                            Icon(
                                modifier = Modifier
                                    .size(18.dp)
                                    .align(CenterVertically),
                                painter = painterResource(id = R.drawable.ic_star),
                                contentDescription = null,
                                tint = Color.Yellow
                            )
                            Text(
                                modifier = Modifier.align(CenterVertically),
                                text = "${product.rating.rate} (${product.rating.count})",
                                fontSize = 14.sp,
                                color = Color.Black,
                                fontWeight = FontWeight.Light
                            )
                        }
                        Text(
                            text = "$${product.price}",
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

            }
            OutlinedButton(
                onClick = {},
                modifier = Modifier
                    .align(BottomEnd)
                    .size(40.dp),
                shape = CircleShape,
                border = BorderStroke(0.dp, Color.Transparent),
                contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color.Black,
                    backgroundColor = LightGreen1
                )
            ) {
                Icon(
                    modifier = Modifier.size(20.dp),
                    imageVector = Icons.Filled.AddShoppingCart,
                    contentDescription = null,
                    tint = Color.Black
                )
            }
        }

    }

}
@Composable
fun Categories(categories: List<String>, viewModel: ProductViewModel) {
    LazyRow(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(categories) { category ->
            Text(
                text = category,
                style = typography.body1.merge(),
                color = Color.White,
                modifier = Modifier
                    .clip(
                        shape = RoundedCornerShape(
                            size = 8.dp,
                        ),
                    )
                    .clickable {
                        viewModel.setCategory(category)
                        viewModel.getProducts(viewModel.selectedCategory.value)
                    }
                    .background(
                        if (category == viewModel.selectedCategory.value) {
                            Teal200
                        } else {
                            Color.LightGray
                        }
                    )
                    .padding(
                        10.dp
                    )
            )
        }
    }
}