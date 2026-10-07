package com.example.gymweighttrackingapp.workoutLists

import com.example.gymweighttrackingapp.data.room.WorkoutExercise.WorkoutExerciseRoom
import com.example.gymweighttrackingapp.data.room.WorkoutExercisesRelation
import com.example.gymweighttrackingapp.data.room.WorkoutPlay.WorkoutPlayRoom

data class WorkoutUiState(
    val isLoading: Boolean = true,
    val workouts: List<WorkoutExercisesRelation> = emptyList(),
    val error: String? = null
)