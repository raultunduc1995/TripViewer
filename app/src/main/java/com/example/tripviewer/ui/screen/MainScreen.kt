package com.example.tripviewer.ui.screen

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.example.tripviewer.R
import com.example.tripviewer.domain.Trip
import com.example.tripviewer.domain.UIState
import com.example.tripviewer.ui.component.TripAppBar
import com.example.tripviewer.ui.theme.TripViewerTheme
import com.example.tripviewer.ui.viewmodel.TripViewModel


@Composable
fun MainScreen(
    navController: NavController,
    viewModel: TripViewModel
) {
    val tripsUIState by viewModel.tripsUIState.observeAsState(UIState.None())

    Column {
        TripAppBar(title = stringResource(id = R.string.app_name))
        when (tripsUIState) {
            is UIState.None -> {
            }
            is UIState.Error<List<Trip>> -> {
                ErrorDetails()
            }
            is UIState.Success<List<Trip>> -> {
                TripsList(
                    trips = (tripsUIState as UIState.Success<List<Trip>>).value
                ) {
                    navController.navigate(
                        "tripdetailsscreen/${it.id}"
                    )
                }
            }
        }
    }
}

@Composable
fun ErrorDetails() {
    Text(
        text = stringResource(id = R.string.error_loading_trips),
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun TripsList(
    trips: List<Trip>,
    onTripClicked: (trip: Trip) -> Unit
) {
    LazyColumn {
        items(trips, key = { trip -> trip.id }) { trip ->
            TripItem(
                imageURL = trip.image,
                startTime = trip.start,
                endTime = trip.end,
                startCity = trip.location.start.city,
                endCity = trip.location.end.city,
                onItemClicked = { onTripClicked.invoke(trip) }
            )
        }
    }
}

@Composable
fun TripItem(
    imageURL: String,
    startTime: String,
    endTime: String,
    startCity: String,
    endCity: String,
    onItemClicked: () -> Unit
) {
    val resources = LocalContext.current.resources
    val painter = rememberImagePainter(
        data = imageURL,
        builder = {
            crossfade(true)
        }
    )

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable(enabled = true, onClick = onItemClicked)
    ) {
        Box {
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier.size(128.dp)
            )
            when (painter.state) {
                is ImagePainter.State.Loading -> {
                    // Display a circular progress indicator whilst loading
                    CircularProgressIndicator(Modifier.align(Alignment.Center))
                }
            }
        }
        Column(modifier = Modifier.padding(horizontal = 8.dp)) {
            Text(text = resources.getString(R.string.start_time, startTime))
            Text(text = resources.getString(R.string.end_time, endTime))
            Text(text = resources.getString(R.string.start_city, startCity))
            Text(text = resources.getString(R.string.end_city, endCity))
        }
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
fun DefaultPreview() {
    TripViewerTheme {
        Surface(color = MaterialTheme.colors.background) {
            Column {
                TripAppBar(title = stringResource(id = R.string.app_name))
                TripsList(emptyList()) {}
            }
        }
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
fun ErrorScreenPreview() {
    TripViewerTheme {
        Surface(color = MaterialTheme.colors.background) {
            Column {
                TripAppBar(title = stringResource(id = R.string.app_name))
                ErrorDetails()
            }
        }
    }
}

