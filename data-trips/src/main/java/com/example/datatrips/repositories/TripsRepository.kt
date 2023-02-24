package com.example.datatrips.repositories

import com.example.datatrips.models.Trip
import com.example.datatrips.network.AutolivService
import javax.inject.Inject

// TODO: Test the repository
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