package com.example.kotlinflows

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UserRepository {

    fun getUserData(): Flow<User> = flow {
        try {
            val user = RetrofitInstance.api.getUser()  // Fetch user data from API
            emit(user)  // Emit the user data
        } catch (e: Exception) {
            throw e  // Handle errors appropriately
        }
    }
}