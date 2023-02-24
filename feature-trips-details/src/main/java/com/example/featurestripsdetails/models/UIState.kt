package com.example.featurestripsdetails.models

import androidx.compose.runtime.Stable

@Stable
sealed class UIState<T> {
    class None<T> : UIState<T>()
    data class Success<T>(val value: T) : UIState<T>()
    data class Error<T>(val error: Throwable) : UIState<T>()
}