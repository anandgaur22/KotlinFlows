package com.example.kotlinflows

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.collectLatest

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun UserScreen(viewModel: UserViewModel = viewModel()) {
    val uiState by viewModel.uiState.collectAsState()

    // Collecting Notifications (Hot Flow - SharedFlow)
    LaunchedEffect(Unit) {
        viewModel.notifications.collectLatest { message ->
            println("Notification: $message")  // For debugging
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("User Dashboard") },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primary)
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)  // Padding for inner elements
                .padding(top = 86.dp)  // Added padding to ensure content starts below TopAppBar
        ) {
            when (uiState) {
                is Resource.Loading -> CircularProgressIndicator()
                is Resource.Success -> {
                    val user = (uiState as Resource.Success<User>).data
                    Text("Name: ${user.name}", style = MaterialTheme.typography.bodyLarge)  // Increased font size
                    Text("Email: ${user.email}", style = MaterialTheme.typography.bodyLarge)  // Increased font size
                    Text("Phone: ${user.phone}", style = MaterialTheme.typography.bodyLarge)  // Increased font size
                }
                is Resource.Error -> {
                    Text("Error: ${(uiState as Resource.Error).message}")
                }
            }
        }
    }
}