package com.example.gymweighttrackingapp.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.gymweighttrackingapp.data.room.Exercises.ExerciseDAO
import com.example.gymweighttrackingapp.data.room.Exercises.ExercisesRoom
import com.example.gymweighttrackingapp.data.room.WorkoutExercise.WorkoutExerciseDao
import com.example.gymweighttrackingapp.data.room.WorkoutExercise.WorkoutExerciseRoom
import com.example.gymweighttrackingapp.data.room.WorkoutPlay.WorkoutPlayDAO
import com.example.gymweighttrackingapp.data.room.WorkoutPlay.WorkoutPlayRoom


@Database(
    entities = [ExercisesRoom::class ,
                WorkoutExerciseRoom::class ,
                WorkoutPlayRoom::class
               ] ,
    version = 1 ,
    exportSchema = false
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun exerciseDAO(): ExerciseDAO
    abstract fun workoutDAO(): WorkoutPlayDAO
    abstract fun workoutExerciseDAO(): WorkoutExerciseDao

}