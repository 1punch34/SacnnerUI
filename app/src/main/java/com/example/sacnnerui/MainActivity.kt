package com.example.sacnnerui

import ProductsScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.sacnnerui.ui.theme.SacnnerUITheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.searchwidgetdemo.SearchViewModel

class MainActivity : ComponentActivity() {
    private val searchViewModel: SearchViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SacnnerUITheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.Home.rout
                    ){
                        composable(route = Screen.Home.rout){
                            HomeScreen(navController = navController)
                        }
                        composable(route = Screen.Products.rout){
                            ProductsScreen(navController = navController)
                        }
                        composable(route = Screen.Location.rout){
                            LocationsScreen(navController = navController)
                        }
                    }
                }



            }
        }
    }
}

