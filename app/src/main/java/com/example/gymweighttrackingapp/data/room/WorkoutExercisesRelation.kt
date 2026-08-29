package com.example.gymweighttrackingapp.data.room

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.gymweighttrackingapp.data.room.Exercises.ExercisesRoom
import com.example.gymweighttrackingapp.data.room.WorkoutExercise.WorkoutExerciseRoom
import com.example.gymweighttrackingapp.data.room.WorkoutPlay.WorkoutPlayRoom

data class WorkoutExercisesRelation(


    @Embedded val workout: WorkoutPlayRoom,

    @Relation(
        parentColumn = "workoutId",
        entityColumn = "id",
        associateBy = Junction(
            value = WorkoutExerciseRoom::class,
            parentColumn = "workoutId",
            entityColumn = "exerciseId"
        )
    )
    val exercises: List<ExercisesRoom>
)