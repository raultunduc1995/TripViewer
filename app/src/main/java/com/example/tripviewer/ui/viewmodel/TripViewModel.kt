package com.example.tripviewer.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tripviewer.domain.Trip
import com.example.tripviewer.domain.UIState
import com.example.tripviewer.repository.TripsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

// TODO: Test the view-model
@HiltViewModel
class TripViewModel @Inject constructor(
    private val tripsRepository: TripsRepository
) : ViewModel() {
    private val _tripsUIState = MutableLiveData<UIState<List<Trip>>>(UIState.None())
    val tripsUIState: LiveData<UIState<List<Trip>>>
        get() = _tripsUIState
    private val _tripsList = MutableLiveData<List<Trip>>(emptyList())
    val tripsList: LiveData<List<Trip>>
        get() = _tripsList

    init {
        viewModelScope.launch {
            try {
                val trips = tripsRepository.getTrips()
                _tripsUIState.value = UIState.Success(value = trips)
                _tripsList.value = trips
            } catch (error: Throwable) {
                _tripsUIState.value = UIState.Error(error = error)
            }
        }
    }
}