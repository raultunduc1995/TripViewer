package com.example.featurestripsdetails.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.featurestripsdetails.R
import com.example.featurestripsdetails.ui.components.TripAppBar
import com.example.featurestripsdetails.ui.themes.TripViewerTheme
import com.example.featurestripsdetails.ui.viewmodels.TripViewModel

// TODO: Finish the UI Implementation
@Composable
fun TripDetailsScreen(
    navController: NavController,
    viewModel: TripViewModel,
    tripId: String?
) {
    val resources = LocalContext.current.resources
    val trips by viewModel.tripsList.observeAsState(initial = emptyList())
    val trip = trips.firstOrNull { it.id == tripId }

    Column {
        TripAppBar(
            title = trip?.id ?: "",
            onBackPressed = { navController.popBackStack() }
        )
        Text(text = trip?.location?.start?.city ?: "Unknown city")
        Text(
            text = resources.getString(
                R.string.end_city,
                trip?.location?.end?.city ?: "Unknown city..."
            )
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