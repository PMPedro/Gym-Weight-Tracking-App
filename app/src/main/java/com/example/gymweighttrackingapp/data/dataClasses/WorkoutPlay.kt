package com.example.gymweighttrackingapp.data.room.dataClasses

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class workoutPlay(
    val workoutId : Long = 0L,
    val workoutName: String = ""
)
