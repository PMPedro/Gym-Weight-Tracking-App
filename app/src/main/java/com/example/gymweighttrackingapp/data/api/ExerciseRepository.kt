package com.example.gymweighttrackingapp.data.api

import com.example.gymweighttrackingapp.data.dataClasses.Exercises
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ExerciseRepository  @Inject constructor (private val api: ApiService) {
    suspend fun getExercises(muscle: String? = null, apiKey: String): List<Exercises> {
        return withContext(Dispatchers.IO) {

            api.getExercises(muscle, apiKey)
        }
    }
}