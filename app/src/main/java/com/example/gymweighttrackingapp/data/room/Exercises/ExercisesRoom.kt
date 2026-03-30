package com.example.gymweighttrackingapp.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercises-table")
data class ExercisesRoom(
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0L ,
    @ColumnInfo(name = "wish-name")
    val name: String = "" ,
    @ColumnInfo(name = "wish-type")
    val type: String = "" ,
    @ColumnInfo(name = "wish-muscle")
    val muscle: String = "",
    @ColumnInfo(name = "wish-difficulty")
    val difficulty: String = "",
    @ColumnInfo(name = "wish-instructions")
    val instructions: String = "",
    @ColumnInfo(name = "wish-equipments")
    val equipments: String = ""
)




