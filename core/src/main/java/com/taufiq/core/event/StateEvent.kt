package com.taufiq.core.event

// UI EVENT
sealed class StateEvent<T: Any> {
    class Loading<T: Any>: StateEvent<T>()
    data class Success<T: Any>(val data: T) : StateEvent<T>()
    data class Failure<T: Any>(val exception: Throwable): StateEvent<T>()
}