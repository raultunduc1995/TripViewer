package com.example.tripviewer.repository

import com.example.tripviewer.domain.Trip
import com.example.tripviewer.network.AutolivService
import javax.inject.Inject

interface TripsRepository {
    suspend fun getTrips(): List<Trip>
}

class TripsRepositoryImpl @Inject constructor(
    private val autolivService: AutolivService
) : TripsRepository {

    override suspend fun getTrips(): List<Trip> =
        autolivService
            .listTrips()
            .trips
}