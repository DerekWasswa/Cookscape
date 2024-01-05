package com.rosen.cookscape

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rosen.cookscape.navigation.Route
import com.rosen.cookscape.presentation.AddCategoryProduct
import com.rosen.cookscape.presentation.Bookmarks
import com.rosen.cookscape.presentation.CategoryDetail
import com.rosen.cookscape.presentation.Home
import com.rosen.cookscape.ui.components.BottomNavigationBar
import com.rosen.cookscape.ui.theme.CookscapeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CookscapeTheme {
                val navController = rememberNavController()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = { BottomNavigationBar(navController = navController) }
                ) { contentPadding ->

                    NavHost(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = MaterialTheme.colorScheme.background),
                        navController = navController,
                        startDestination = Route.Home.route
                    ) {

                        composable(route = Route.Home.route) {
                            Home(navController)
                        }

                        composable(route = "${Route.CategoryDetail.route}/{categoryId}") { backStackEntry ->
                            val categoryId = backStackEntry.arguments?.getString("categoryId")
                            CategoryDetail(categoryId = categoryId)
                        }

                        composable(route = Route.AddCategoryProduct.route) {
                            AddCategoryProduct()
                        }

                        composable(route = Route.Bookmarks.route) {
                            Bookmarks(contentPadding)
                        }

                    }

                }
            }
        }
    }
}