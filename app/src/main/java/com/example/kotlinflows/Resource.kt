package com.example.kotlinflows

sealed class Resource<T> {
    data class Success<T>(val data: T) : Resource<T>()
    data class Error<T>(val message: String) : Resource<T>()
    class Loading<T> : Resource<T>()  // Make sure this is a class and instantiated with `()` (empty constructor)
}