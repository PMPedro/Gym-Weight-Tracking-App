package com.example.gymweighttrackingapp.mainpage

import com.example.gymweighttrackingapp.data.dataClasses.WorkoutPlay
import com.example.gymweighttrackingapp.data.room.WorkoutPlay.WorkoutPlayRoom

data class MainPageUiState(
    val isLoading: Boolean = true,
    val workouts: List<WorkoutPlayRoom> = emptyList(), //sucess
    val error: String? = null
)