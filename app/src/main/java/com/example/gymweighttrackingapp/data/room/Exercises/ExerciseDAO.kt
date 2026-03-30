package com.example.gymweighttrackingapp.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
abstract class  ExerciseDAO {

    @Insert(onConflict = OnConflictStrategy.Companion.IGNORE)
    abstract suspend fun addExercise(exerciseEnt: ExercisesRoom)

    @Query("SELECT * from 'exercises-table'")
    abstract fun getAllExercises(): Flow<List<ExercisesRoom>>

    @Update
    abstract suspend fun updateExercise(exerciseEnt: ExercisesRoom)

    @Delete
    abstract suspend fun deleteExercise(exerciseEnt: ExercisesRoom)

    @Query("SELECT * from 'exercises-table' where `wish-name`=:wishName")
    abstract fun getExercise(wishName: Long): Flow<ExercisesRoom>
}