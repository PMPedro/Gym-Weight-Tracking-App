package com.example.gymweighttrackingapp.comon

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ExerciseRepository(private val api: ApiService) {
    suspend fun getExercises(muscle: String? = null, apiKey: String): List<Exercises> {
        return withContext(Dispatchers.IO) {

            api.getExercises(muscle, apiKey)
        }
    }
}