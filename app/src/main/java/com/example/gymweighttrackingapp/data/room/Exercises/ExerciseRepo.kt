package com.example.gymweighttrackingapp.data.room

import kotlinx.coroutines.flow.Flow


class ExerciseRepoRoom (private val exerciseDao: ExerciseDAO){

    suspend fun addWish(exercise: ExercisesRoom){
        exerciseDao.addExercise(exercise)
    }

    fun getWishes() : Flow<List<ExercisesRoom>> = exerciseDao.getAllExercises()

    fun getWishById(id:Long) :Flow<ExercisesRoom> {
        return exerciseDao.getExercise(id)
    }

    suspend fun updateWish(exercise: ExercisesRoom){
        exerciseDao.updateExercise(exercise)
    }

    suspend fun deleteAWish(exercise: ExercisesRoom){
        exerciseDao.deleteExercise(exercise)
    }
}