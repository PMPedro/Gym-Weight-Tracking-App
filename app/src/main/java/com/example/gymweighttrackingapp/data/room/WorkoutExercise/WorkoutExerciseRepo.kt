package com.example.gymweighttrackingapp.data.room.WorkoutExercise

import com.example.gymweighttrackingapp.data.room.Exercises.ExerciseDAO
import com.example.gymweighttrackingapp.data.room.Exercises.ExercisesRoom
import com.example.gymweighttrackingapp.data.room.WorkoutExercisesRelation
import com.example.gymweighttrackingapp.utils.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WorkoutExerciseRepo @Inject constructor
    (private val workoutExerciseDao: WorkoutExerciseDao) {

    suspend fun addExercise(exercise: WorkoutExerciseRoom) {
        workoutExerciseDao.addWorkoutExercise(exercise)
    }

    fun getAll(): Flow<List<WorkoutExerciseRoom>> =
        workoutExerciseDao.getAllWorkoutExercise()

    fun getByWorkoutId(workoutId: Long): Flow<Result<List<WorkoutExercisesRelation>>> = flow {

        emit(com.example.gymweighttrackingapp.utils.Result.Loading)
        try{
            workoutExerciseDao.getExercisesForWorkout(workoutId).collect {
                data ->
                emit(Result.Success(data))
            }
        }catch (e : Exception){
            emit(Result.Error(e))
        }

    }

    fun getByExerciseId(exerciseId: Long): Flow<List<WorkoutExerciseRoom>> =
        workoutExerciseDao.getWorkoutsForExercise(exerciseId)

    suspend fun update(exercise: WorkoutExerciseRoom) {
        workoutExerciseDao.updateWorkoutExercise(exercise)
    }

    suspend fun delete(exercise: WorkoutExerciseRoom) {
        workoutExerciseDao.deleteWorkoutExercise(exercise)
    }


}
