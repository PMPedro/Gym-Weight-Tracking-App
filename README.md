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

- UI (Jetpack Compose) 

- ViewModel 
    
- Repository 

- Room Database / API Layer 

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
### 📸 Screenshots

| MainPage | MainPage Light Mode | Creating Playlist |  Fetching API Data |
|:--------:|:-------------------:|:-----------------:|:------------------:|
| ![MainPage](https://github.com/user-attachments/assets/605fd7b8-4888-434e-9695-ea0f4af21a79) | ![MainPage LightMode](https://github.com/user-attachments/assets/dae3a03b-3dce-41f8-b8b7-004d64645a1a) | ![Creating Playlist](https://github.com/user-attachments/assets/aaeb2b1e-06b5-4e73-84ca-6c5b20c2beb0) | ![Fetching API Data](https://github.com/user-attachments/assets/d1f466b1-4896-4448-a301-3d2033da33ee) |

| Playlist After Adding Data | Playlist Light Mode | Search Bar | Playlist Creation |
|:--------------------------:|:-------------------:|:----------:|:-----------------:|
| ![Playlist After Adding Data](https://github.com/user-attachments/assets/4d5b6098-15d3-4157-ac48-4ca31e4a3f2b) | ![Playlist Light Mode](https://github.com/user-attachments/assets/55a540f1-6758-4512-87b6-4e8e9b457ff1) | ![Search Bar](https://github.com/user-attachments/assets/b3b48273-6702-4cd9-bc93-09f23dcde8de) | ![Playlist Creation](https://github.com/user-attachments/assets/3de81173-81f0-42ec-8d3a-7551c41aefa9) |




---

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
