package com.example.gymweighttrackingapp.comon

data class Exercises(
    val name : String ,
    val bodyPart : String ,
    val type : String ,
    val dificulty : String ,
)


val exercisesList = listOf(
    Exercises(
        name = "Push-Up",
        bodyPart = "Chest",
        type = "Strength",
        dificulty = "Beginner"
    ),
    Exercises(
        name = "Squat",
        bodyPart = "Legs",
        type = "Strength",
        dificulty = "Beginner"
    ),
    Exercises(
        name = "Plank",
        bodyPart = "Core",
        type = "Isometric",
        dificulty = "Intermediate"
    ),
    Exercises(
        name = "Bicep Curl",
        bodyPart = "Arms",
        type = "Strength",
        dificulty = "Beginner"
    ),
    Exercises(
        name = "Burpee",
        bodyPart = "Full Body",
        type = "Cardio",
        dificulty = "Advanced"
    )
)
