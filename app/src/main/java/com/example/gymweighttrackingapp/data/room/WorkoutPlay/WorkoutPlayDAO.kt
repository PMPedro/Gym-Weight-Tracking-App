package com.example.gymweighttrackingapp.data.room.WorkoutPlay

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.gymweighttrackingapp.data.room.Exercises.ExercisesRoom
import kotlinx.coroutines.flow.Flow

@Dao
abstract class WorkoutPlayDAO {
    @Insert(onConflict = OnConflictStrategy.Companion.IGNORE)
    abstract suspend fun addExercise(exerciseEnt: WorkoutPlayRoom)
    @Query("SELECT * from 'WorkoutPlayRoom-table'")
    abstract fun getAllExercises(): Flow<List<WorkoutPlayRoom>>


    @Query("SELECT * from `WorkoutPlayRoom-table` WHERE workoutId = :id ")
    abstract fun getAllExercisesByyWorkoutId(id : Long): Flow<List<WorkoutPlayRoom>>

    @Update
    abstract suspend fun updateExercise(exerciseEnt: WorkoutPlayRoom)
    @Delete
    abstract suspend fun deleteExercise(exerciseEnt: WorkoutPlayRoom)
    @Query("SELECT * from 'WorkoutPlayRoom-table' where 'WorkoutPlayRoom-name' =:wishName")
    abstract fun  getExercise(wishName: String): Flow<WorkoutPlayRoom>

    @Query("SELECT workoutId from `workoutplayroom-table` where `WorkoutPlayRoom-name` = :name " )
    abstract suspend fun getWorkoutIdByName(name : String) : Long




}