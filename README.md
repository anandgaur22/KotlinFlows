## Kotlin Flow

### What is Flow?
Flow is a reactive stream in Kotlin that emits multiple values asynchronously. It is a part of Kotlin Coroutines and follows a declarative approach to handling streams of data.

- **Asynchronous:** Works with coroutines to provide non-blocking execution.
- **Sequential Emission:** Emits values one by one.
- **Cold by Default:** Only starts emitting when collected.
- **Cancellation Support:** Automatically cancels when the collector stops collecting.

### Cold Flow and Hot Flow

#### Cold Flow
Cold Flow in Kotlin is lazy and starts emitting data only when it has an active subscriber. Each subscriber gets a fresh sequence of values.

- **Example Use Case:** Fetching data from an API where each subscriber gets fresh data.
- **Behavior:** New instance for every subscriber.

#### Hot Flow
Hot Flow emits data even without active subscribers and shares emitted values among multiple subscribers.

- **Example Use Case:** Live UI updates or event notifications.
- **Behavior:** Continuous emission irrespective of subscribers.

### What is a Subscriber in Flow?
A **subscriber** (collector) is an entity that listens to a Flow and processes emitted values.

- Calls `collect()` to receive data.
- Triggers execution in Cold Flow.
- Receives ongoing updates in Hot Flow.

### StateFlow & SharedFlow

#### StateFlow
StateFlow is a Hot Flow that holds the latest value and updates only when a new distinct value is emitted.

- **Features:**
  - Always maintains a single latest value.
  - Designed for UI state management.

#### SharedFlow
SharedFlow is a more advanced Hot Flow that supports multiple subscribers and replaying past values.

- **Features:**
  - Can have multiple collectors.
  - Supports replaying past values to new subscribers.

### Sealed Classes and Enum

#### Sealed Classes
Sealed classes restrict inheritance to predefined types, making them useful for representing limited state variations like `Success`, `Error`, and `Loading`.

- **Features:**
  - Prevents external subclassing.
  - Works well with `when` statements.

#### Enum Classes
Enums define a fixed set of constants, useful for representing predefined categories like days of the week.

- **Features:**
  - Immutable predefined values.
  - Can have associated properties and functions.

By mastering these concepts, you can leverage Kotlin Flow effectively in Android.

