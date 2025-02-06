package com.example.kotlinflows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class UserViewModel(private val userRepository: UserRepository = UserRepository()) : ViewModel() {

    // Flow to expose UI state (loading, success, error)
    private val _uiState = MutableStateFlow<Resource<User>>(Resource.Loading())
    val uiState: StateFlow<Resource<User>> get() = _uiState

    // Flow for notifications (Hot Flow - SharedFlow)
    private val _notifications = MutableSharedFlow<String>()
    val notifications: SharedFlow<String> get() = _notifications

    init {
        // Start collecting user data when the ViewModel is created
        fetchUserData()
    }

    // Collect user data from repository
    private fun fetchUserData() {
        viewModelScope.launch {
            userRepository.getUserData()
                .onStart { _uiState.value = Resource.Loading() }  // Show loading state
                .catch { e -> _uiState.value = Resource.Error("Error: ${e.message}") }  // Handle errors
                .collect { user -> _uiState.value = Resource.Success(user) }  // Emit the success state with user data
        }
    }

    // Function to trigger notification sending
    fun sendNotification(message: String) {
        viewModelScope.launch {
            _notifications.emit(message)
        }
    }
}