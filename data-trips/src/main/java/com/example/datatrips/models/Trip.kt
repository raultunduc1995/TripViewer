package com.example.datatrips.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TripsResponse(
    val trips: List<Trip>
) : Parcelable

@Parcelize
data class Trip(
    val id: String,
    val start: String,
    val end: String,
    val location: StartEndLocation,
    val image: String
) : Parcelable

@Parcelize
data class StartEndLocation(
    val start: Location,
    val end: Location
) : Parcelable

@Parcelize
data class Location(
    val city: String,
    val county: String,
    val country: String
) : Parcelable