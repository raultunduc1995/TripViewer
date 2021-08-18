package com.example.tripviewer.network

import com.example.tripviewer.domain.TripsResponse
import retrofit2.http.GET

interface AutolivService {
    @GET("interview-data.json")
    suspend fun listTrips(): TripsResponse
}