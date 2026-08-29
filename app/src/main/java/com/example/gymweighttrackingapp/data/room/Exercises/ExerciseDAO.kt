package com.example.gymweighttrackingapp.data.room.Exercises

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.gymweighttrackingapp.utils.Result
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

    @Query("SELECT * from 'exercises-table' where `exercises-name`=:wishName")
    abstract fun getExercise(wishName: Long): Flow<ExercisesRoom>

    @Query("SELECT * from 'exercises-table' where id = :excersiceId")
    abstract fun getExercisebyId(excersiceId: Long): Flow<ExercisesRoom>

    @Query("SELECT id from `exercises-table` where `exercises-name` = :name " )
    abstract suspend fun getExerciseIdByName(name : String) : Long

    @Query("Update `exercises-table` set `exercises-reps` = :reps  Where id = :id")
    abstract suspend fun updateReps(reps: Int , id: Long )

    @Query("Update `exercises-table` set `exercises-sets` = :sets  Where id = :id")
    abstract suspend fun updateSets(sets: Int , id: Long )

    @Query("Update `exercises-table` set `exercises-weight` = :weight  Where id = :id")
    abstract suspend fun updateWeight(weight: Float , id: Long )


}