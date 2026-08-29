package com.example.gymweighttrackingapp.workoutListEdit

import com.example.gymweighttrackingapp.data.dataClasses.Exercises
import com.example.gymweighttrackingapp.data.room.WorkoutExercisesRelation

data class WorkoutListEditUiState (
    val isLoading: Boolean = true,
    val workouts: List<Exercises> = emptyList(),
    val error: String? = null
)

