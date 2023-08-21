package com.example.mobilepromo.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.mobilepromo.PromoViewModel
import com.example.mobilepromo.R
import com.example.mobilepromo.model.PromoModelItem


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(promoViewModel: PromoViewModel, navController: NavController) {
    Scaffold(
        topBar = { TopBarApp(navController = navController)},
        content = {
            Column {
                Spacer(modifier = Modifier.height(15.dp))
                DetailList(promoList = promoViewModel.listPromo, navController = navController, promoViewModel = promoViewModel)
            }
        }
    )
}

@Composable
fun DetailList(promoList: List<PromoModelItem?>?, navController: NavController, promoViewModel: PromoViewModel) {
    if(promoList?.size!! > 0) {
        LazyColumn{
            itemsIndexed(items = promoList) {_, item ->
                DetailCard(data = item!!, navController = navController, promoViewModel = promoViewModel)
            }
        }
    }
}

@Composable
fun DetailCard(data: PromoModelItem?, navController: NavController, promoViewModel: PromoViewModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable {
                promoViewModel.getDetailPromo(data?.id!!)
                navController.navigate("detailScreen/${data.id}")
            },
        shape = RoundedCornerShape(15.dp)
    ) {
        Box(
            modifier = Modifier.height(200.dp)
        ) {
            Card(
                modifier = Modifier.fillMaxWidth()
            )
            {
                Image(
                    painter = rememberImagePainter(
                        data = data?.img?.formats?.medium?.url,
                        builder = {
                            placeholder(R.drawable.placeholder)
                        }
                    ),
                    contentDescription = data?.nama,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
            Box(modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        listOf(
                            Color.Transparent,
                            Color.Black
                        ),
                        startY = 400f
                    )
                ))
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(text = data?.nama!!, style = TextStyle(color = Color.White, fontSize = 16.sp))
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarApp(navController: NavController) {
    TopAppBar(
        title = { Text(text = "Mobile Promo")},
        actions = {
            IconButton(
                onClick = {
                    navController.navigate("profileScreen")
                }
            ) {
                androidx.compose.material3.Icon(Icons.Filled.AccountCircle, contentDescription = "Profile")
            }
        }
    )
}

