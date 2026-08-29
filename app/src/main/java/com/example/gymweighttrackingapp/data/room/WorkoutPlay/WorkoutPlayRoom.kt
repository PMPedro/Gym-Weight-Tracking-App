package com.example.gymweighttrackingapp.data.room.WorkoutPlay

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "WorkoutPlayRoom-table")
data class WorkoutPlayRoom(
    @PrimaryKey(autoGenerate = true)
    val workoutId : Long = 0L,
    @ColumnInfo(name = "WorkoutPlayRoom-name")
    val workoutName: String= ""
)