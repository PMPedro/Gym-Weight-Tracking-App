package com.example.gymweighttrackingapp.data.dataClasses

data class Exercises(
    val name: String,
    val type: String,
    val muscle: String,
    val difficulty: String,
    val instructions: String,
    val equipments: List<String>
)