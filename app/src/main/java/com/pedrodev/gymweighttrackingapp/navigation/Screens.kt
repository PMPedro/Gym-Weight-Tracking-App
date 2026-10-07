package com.example.gymweighttrackingapp.navigation


sealed class Screens(val route: String) {

    object MainPage : Screens("mainpage")
    object StrengthTest : Screens("strengthtest")
    object WeightTracker : Screens("weighttracker")
    object WorkoutListEdit : Screens("workoutlistedit")
    object WorkoutList : Screens("workoutlist")
    object WorkoutListDetail : Screens("workoutlist/{workoutId}") {
        fun createRoute(workoutId: String) = "workoutlist/$workoutId"
    }

    object WorkoutListEditDetail : Screens("workoutlistedit/{workoutId}") {
        fun createRoute(workoutId: String) = "workoutlistedit/$workoutId"
    }

}
