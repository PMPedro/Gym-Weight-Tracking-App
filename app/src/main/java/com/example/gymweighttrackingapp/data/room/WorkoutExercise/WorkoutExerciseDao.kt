package com.example.gymweighttrackingapp.data.room.WorkoutExercise

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.gymweighttrackingapp.data.room.WorkoutExercisesRelation
import kotlinx.coroutines.flow.Flow


@Dao
abstract class WorkoutExerciseDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun addWorkoutExercise(exerciseEnt: WorkoutExerciseRoom)

    @Query("SELECT * FROM Workout_Exercise_table")
    abstract fun getAllWorkoutExercise(): Flow<List<WorkoutExerciseRoom>>

    @Query("SELECT * FROM `WorkoutPlayRoom-table` WHERE workoutId = :workoutId")
    abstract fun getExercisesForWorkout(workoutId: Long): Flow<List<WorkoutExercisesRelation>>

    @Query("SELECT * FROM Workout_Exercise_table WHERE exerciseId = :exerciseId")
    abstract fun getWorkoutsForExercise(exerciseId: Long): Flow<List<WorkoutExerciseRoom>>

    @Update
    abstract suspend fun updateWorkoutExercise(exerciseEnt: WorkoutExerciseRoom)

    @Delete
    abstract suspend fun deleteWorkoutExercise(exerciseEnt: WorkoutExerciseRoom)


}
