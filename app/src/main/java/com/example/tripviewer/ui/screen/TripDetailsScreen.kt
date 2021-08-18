package com.example.tripviewer.ui.screen

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.tripviewer.ui.component.TripAppBar
import com.example.tripviewer.ui.theme.TripViewerTheme
import com.example.tripviewer.ui.viewmodel.TripViewModel

@Composable
fun TripDetailsScreen(
    navController: NavController,
    viewModel: TripViewModel,
    tripId: String?
) {
    Log.d("TAG", "${tripId}")
    val trips by viewModel.tripsList.observeAsState(initial = emptyList())
    Log.d("TAG", trips.toString())
    val trip = trips.firstOrNull { it.id == tripId }
    Log.d("TAG", trip.toString())

    Column {
        TripAppBar(
            title = trip?.id ?: "",
            onBackPressed = { navController.popBackStack() }
        )
    }
}

@Preview(
    name = "Light Mode",
    showBackground = true
)
@Preview(
    name = "Dark Mode",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun TripDetailsPreview() {
    TripViewerTheme {
        Surface(color = MaterialTheme.colors.background) {
            Column {
                TripAppBar(title = "Title")
            }
        }
    }
}