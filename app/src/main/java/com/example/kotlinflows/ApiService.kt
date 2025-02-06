package com.example.kotlinflows

import retrofit2.http.GET

interface ApiService {
    @GET("users/1")
    suspend fun getUser(): User  // Make sure the endpoint and data model match
}