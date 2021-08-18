package com.example.tripviewer.di

import com.example.tripviewer.BuildConfig
import com.example.tripviewer.network.AutolivService
import com.example.tripviewer.repository.TripsRepository
import com.example.tripviewer.repository.TripsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ViewModelComponent::class)
abstract class BindViewModelComponent {
    @Binds
    abstract fun bindTripsRepository(tripsRepositoryImpl: TripsRepositoryImpl): TripsRepository
}

@Module
@InstallIn(SingletonComponent::class)
class ProvideSingletonComponentModule {
    @Provides
    fun provideAutolivService(): AutolivService =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.URL)
            .build()
            .create(AutolivService::class.java)
}