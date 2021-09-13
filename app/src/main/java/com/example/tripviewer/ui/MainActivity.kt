package com.example.tripviewer.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.tripviewer.ui.screen.MainScreen
import com.example.tripviewer.ui.screen.TripDetailsScreen
import com.example.tripviewer.ui.theme.TripViewerTheme
import com.example.tripviewer.ui.viewmodel.TripViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TripViewerTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Container()
                }
            }
        }
    }
}

@Composable
fun Container() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "mainscreen", route = "MainRoute") {
        composable("mainscreen") {
            val viewModel = hiltViewModel<TripViewModel>(
                navController.getBackStackEntry("MainRoute")
            )
            MainScreen(navController, viewModel)
        }
        composable(
            "tripdetailsscreen/{tripId}",
            arguments = listOf(navArgument("tripId") { type = NavType.StringType })
        ) { backstackEntry ->
            val viewModel = hiltViewModel<TripViewModel>(
                navController.getBackStackEntry("MainRoute")
            )
            TripDetailsScreen(
                navController,
                viewModel,
                tripId = backstackEntry.arguments?.getString("tripId", "default-value")
            )
        }
    }
}