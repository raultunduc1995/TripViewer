package com.example.datatrips.network

import com.example.datatrips.models.TripsResponse
import retrofit2.http.GET

// TODO: Test Autoliv-Service
interface AutolivService {
    @GET("interview-data.json")
    suspend fun listTrips(): TripsResponse
}