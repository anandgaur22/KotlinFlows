package com.example.kotlinflows

/*

Cold Flow Example:

fun getColdFlow(): Flow<Int> = flow {
    println("Generating numbers...")
    for (i in 1..3) {
        delay(1000)  // Simulating network delay
        emit(i)  // Sending data
    }
}

fun main() {
    println("Collector 1 is collecting...")
    GlobalScope.launch {
        getColdFlow().collect { value ->
            println("Collector 1 received: $value")
        }
    }

    Thread.sleep(5000) // Giving time for execution
    println("\nCollector 2 is collecting...")

    GlobalScope.launch {
        getColdFlow().collect { value ->
            println("Collector 2 received: $value")
        }
    }

    Thread.sleep(5000) // Giving time for execution
}


Output:

Collector 1 is collecting...
Generating numbers...
Collector 1 received: 1
Collector 1 received: 2
Collector 1 received: 3

Collector 2 is collecting...
Generating numbers...
Collector 2 received: 1
Collector 2 received: 2
Collector 2 received: 3




Hot Flow Example:


val sharedFlow = MutableSharedFlow<Int>(replay = 2) // Last 2 values store karega

fun main() {
    GlobalScope.launch {
        for (i in 1..5) {
            delay(1000)
            println("Emitting: $i")
            sharedFlow.emit(i)
        }
    }

    Thread.sleep(2500) // Let the flow emit some values before collecting

    GlobalScope.launch {
        println("Collector 1 is collecting...")
        sharedFlow.collect { value ->
            println("Collector 1 received: $value")
        }
    }

    Thread.sleep(3000) // Giving time for next collector

    GlobalScope.launch {
        println("Collector 2 is collecting...")
        sharedFlow.collect { value ->
            println("Collector 2 received: $value")
        }
    }

    Thread.sleep(5000) // Giving time for execution
}

Output:

Emitting: 1
Emitting: 2
Collector 1 is collecting...
Collector 1 received: 1
Collector 1 received: 2
Emitting: 3
Collector 1 received: 3
Emitting: 4
Collector 1 received: 4
Emitting: 5
Collector 1 received: 5

Collector 2 is collecting...
Collector 2 received: 4
Collector 2 received: 5



Simple Subscriber in Cold Flow

fun getNumbers(): Flow<Int> = flow {
    for (i in 1..5) {
        delay(1000)  // Simulating delay
        emit(i)  // Sending data
    }
}

fun main() {
    GlobalScope.launch {
        println("Subscriber 1 started")
        getNumbers().collect { value ->
            println("Subscriber 1 received: $value")
        }
    }

    Thread.sleep(7000)  // Giving time for execution
}


Output:

Subscriber 1 started
Subscriber 1 received: 1
Subscriber 1 received: 2
Subscriber 1 received: 3
Subscriber 1 received: 4
Subscriber 1 received: 5


StateFlow example:

val _stateFlow = MutableStateFlow(0)
val stateFlow: StateFlow<Int> = _stateFlow

fun updateState(value: Int) {
    _stateFlow.value = value
}


SharedFlow example:

val sharedFlow = MutableSharedFlow<Int>(replay = 2)

suspend fun emitValues() {
    for (i in 1..5) {
        sharedFlow.emit(i)
        delay(1000)
    }
}



Flow Works with Coroutines

fun fetchNumbers(): Flow<Int> = flow {
    for (i in 1..5) {
        delay(1000)
        emit(i)
    }
}.flowOn(Dispatchers.IO)  // Running on IO thread



// Sealed Class definition

sealed class Result

// Subclasses of the sealed class
data class Success(val data: String) : Result()
data class Error(val message: String) : Result()
object Loading : Result()

// Using the sealed class in a when statement
fun handleResult(result: Result) {
    when (result) {
        is Success -> println("Data: ${result.data}")
        is Error -> println("Error: ${result.message}")
        Loading -> println("Loading...")
    }
}



Enum

// Enum class definition
enum class Direction {
    NORTH, EAST, SOUTH, WEST
}

// Using Enum in a when statement
fun move(direction: Direction) {
    when (direction) {
        Direction.NORTH -> println("Moving North")
        Direction.EAST -> println("Moving East")
        Direction.SOUTH -> println("Moving South")
        Direction.WEST -> println("Moving West")
    }
}



*/
