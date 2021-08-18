package com.example.tripviewer.network

import com.example.tripviewer.domain.TripsResponse
import retrofit2.http.GET

// TODO: Test Autoliv-Service
interface AutolivService {
    @GET("interview-data.json")
    suspend fun listTrips(): TripsResponse
}