package com.example.gymweighttrackingapp.data.room

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(
    entities = [ExercisesRoom::class] ,
    version = 1 ,
    exportSchema = false
)
abstract class ExerciseDatabase: RoomDatabase() {
    abstract fun exerciseDAO(): ExerciseDAO
}