package com.example.gymweighttrackingapp.data.room.WorkoutExercise


import androidx.compose.ui.text.font.FontWeight
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.gymweighttrackingapp.data.room.Exercises.ExercisesRoom
import com.example.gymweighttrackingapp.data.room.WorkoutPlay.WorkoutPlayRoom

@Entity(
    tableName = "Workout_Exercise_table",
    primaryKeys = ["workoutId", "exerciseId"],
    foreignKeys = [
        ForeignKey(
            entity = WorkoutPlayRoom::class,
            parentColumns = ["workoutId"],
            childColumns = ["workoutId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = ExercisesRoom::class,
            parentColumns = ["id"],
            childColumns = ["exerciseId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class WorkoutExerciseRoom(
    val workoutId : Long ,
    val exerciseId : Long ,

)