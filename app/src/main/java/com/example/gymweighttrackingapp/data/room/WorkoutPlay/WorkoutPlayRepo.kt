package com.example.gymweighttrackingapp.data.room.WorkoutPlay

import com.example.gymweighttrackingapp.data.room.Exercises.ExerciseDAO
import com.example.gymweighttrackingapp.data.room.Exercises.ExercisesRoom
import com.example.gymweighttrackingapp.utils.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WorkoutPlayRepo @Inject constructor(private val exerciseDao: WorkoutPlayDAO) {
    suspend fun addWorkoutList(exercise: WorkoutPlayRoom) {
        exerciseDao.addExercise(exercise)
    }

     fun getWorkoutList(): Flow<Result<List<WorkoutPlayRoom>>> = flow {
        emit(com.example.gymweighttrackingapp.utils.Result.Loading)
        try {
        exerciseDao.getAllExercises().collect() { data -> emit(Result.Success(data)) }
    } catch (e: Exception) {
        emit(Result.Error(e))
    }
    }

    suspend fun getWorkoutPlayById(name : String): Flow<WorkoutPlayRoom> {
        return exerciseDao.getExercise(name)
    }

    suspend fun updateWorkout(exercise: WorkoutPlayRoom) {
        exerciseDao.updateExercise(exercise)
    }

    suspend fun deleteWorkout(exercise: WorkoutPlayRoom) {
        exerciseDao.deleteExercise(exercise)
    }

    suspend fun getWorkoutIdByName(name : String) : Long{
        return exerciseDao.getWorkoutIdByName(name)
    }
}