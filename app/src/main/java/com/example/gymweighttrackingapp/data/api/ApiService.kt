package com.example.gymweighttrackingapp.data.api

import com.example.gymweighttrackingapp.data.dataClasses.Exercises
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {
    @GET("v1/exercises")
    suspend fun getExercises(
        @Query("muscle") muscle: String? = null,  // optional
        @Header("X-Api-Key") apiKey: String
    ): List<Exercises>
}