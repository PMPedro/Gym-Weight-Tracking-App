# Gym Weight Tracking App 💪

A modern Android fitness tracking application built with Kotlin and Jetpack Compose.  
The app focuses on clean architecture, scalability, and real-world Android development practices.

It allows users to create and manage workout playlists, organize exercises, and track training progress using a local database, with a modern reactive UI built entirely in Compose.

---

## 🚀 Features

- Create and manage workout playlists
- Organize workouts and exercises
- Persistent local storage using Room Database
- Modern Jetpack Compose UI
- Navigation between multiple screens
- Reactive state management (StateFlow + LiveData)
- Repository pattern for clean data separation
- Dependency Injection with Hilt
- API-ready architecture (Retrofit integration structure)
- Coroutine-based asynchronous operations

---

## 🧱 Architecture

The app follows MVVM + Clean Architecture principles:

UI (Jetpack Compose)
    ↓
ViewModel
    ↓
Repository
    ↓
Room Database / API Layer

This ensures separation of concerns, scalability, and maintainability.

---

## 🛠 Tech Stack

- Kotlin
- Jetpack Compose
- MVVM Architecture
- Hilt (Dependency Injection)
- Room Database
- Coroutines & Flow
- StateFlow / LiveData
- Retrofit (network layer structure)
- Navigation Compose

---

## 🧪 Testing

Basic unit testing setup using:

- JUnit
- MockK
- kotlinx-coroutines-test

Includes ViewModel testing with coroutine handling.

---

## 📌 Project Status

This project is still in active development.

### 🔧 Currently In Progress:
- Improved search functionality
- Swipe-to-delete for workouts and playlists
- Rename playlist feature
- Weight tracking system improvements
- Additional unit tests
- UI/UX refinements and polish

---

## 🎯 Purpose of This Project

This project was built to improve my understanding of:

- Modern Android development (Jetpack Compose)
- Clean architecture principles
- State management with Kotlin Flow
- Dependency injection (Hilt)
- Local persistence (Room)
- Unit testing in Android
- Scalable app design

---
<!--
## 📸 Screenshots

(Add screenshots here)

---
-->
## 📈 Future Improvements

- Advanced workout analytics
- Cloud sync support
- Performance optimizations
- More robust testing coverage
- Better UI animations and transitions

---

## 📬 Feedback

Any feedback or suggestions are welcome.
This project is continuously evolving as part of my learning journey.
