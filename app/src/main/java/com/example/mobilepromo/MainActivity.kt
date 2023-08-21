package com.example.mobilepromo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mobilepromo.screens.DetailScreen
import com.example.mobilepromo.screens.HomeScreen
import com.example.mobilepromo.ui.theme.MobilePromoTheme

class MainActivity : ComponentActivity() {
    private val promoViewModel by viewModels<PromoViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            MobilePromoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(navController = navController, startDestination = "homeScreen") {
                        composable("homeScreen"){
                            HomeScreen(promoViewModel = promoViewModel, navController = navController)
                        }
                        composable("detailScreen/{id}", arguments = listOf(navArgument("id"){type= NavType.IntType})
                        ){
                                navBackStackEntry -> DetailScreen(model = promoViewModel, id = navBackStackEntry.arguments?.getInt("id")!!)
                        }
                    }
                }
            }
        }
    }
}
