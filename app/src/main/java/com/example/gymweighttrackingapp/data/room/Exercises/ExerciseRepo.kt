package com.example.gymweighttrackingapp.data.room.Exercises

import com.example.gymweighttrackingapp.utils.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class ExerciseRepoRoom @Inject constructor
    (private val exerciseDao: ExerciseDAO){

    suspend fun addExercise(exercise: ExercisesRoom){
        exerciseDao.addExercise(exercise)
    }

    fun getExercise() : Flow<List<ExercisesRoom>> = exerciseDao.getAllExercises()

    fun getExerciseById(id:Long) :Flow<ExercisesRoom> {
        return exerciseDao.getExercise(id)
    }

    suspend fun updateExercise(exercise: ExercisesRoom){
        exerciseDao.updateExercise(exercise)
    }

    suspend fun deleteAExercise(exercise: ExercisesRoom){
        exerciseDao.deleteExercise(exercise)
    }

    fun getExercisebyId(excerciseId: Long) : Flow<Result<ExercisesRoom>> = flow {
        emit(Result.Loading)
        try {
            exerciseDao.getExercisebyId(excerciseId).collect() {
                data ->
                emit(Result.Success(data))
            }
        }catch (e: Exception){
            emit(Result.Error(e))
        }
    }

    suspend fun getExerciseIdByName(name : String) : Long{
        return exerciseDao.getExerciseIdByName(name)
    }

    suspend fun updateReps(reps: Int , id: Long){
        exerciseDao.updateReps(reps, id )
    }

    suspend fun updateSets(sets: Int , id: Long){
        exerciseDao.updateSets(sets, id )
    }

    suspend fun updateWeight(weight: Float , id: Long){
        exerciseDao.updateWeight(weight, id )
    }
}
