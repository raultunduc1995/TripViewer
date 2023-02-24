package com.example.tripviewer.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.featurestripsdetails.ui.screens.TripDetailsScreen
import com.example.featurestripsdetails.ui.themes.TripViewerTheme
import com.example.featurestripsdetails.ui.viewmodels.TripViewModel
import com.example.tripviewer.ui.screens.MainScreen
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

@SuppressLint("UnrememberedGetBackStackEntry")
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