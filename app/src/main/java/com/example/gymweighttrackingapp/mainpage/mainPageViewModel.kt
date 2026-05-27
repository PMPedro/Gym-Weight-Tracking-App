package com.example.gymweighttrackingapp.mainpage.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.gymweighttrackingapp.data.room.WorkoutPlay.WorkoutPlayDAO
import com.example.gymweighttrackingapp.data.room.WorkoutPlay.WorkoutPlayRepo
import com.example.gymweighttrackingapp.data.room.WorkoutPlay.WorkoutPlayRoom
import kotlinx.coroutines.launch


class mainPageViewModel (
    private val workoutPlayRepo: WorkoutPlayRepo ,
) : ViewModel()
{

    fun createPlay(){
        val randomNumber = (1000..9999999999).random()
        val name = "My Workout #$randomNumber"
        viewModelScope.launch{
            workoutPlayRepo.addWorkoutList(
                WorkoutPlayRoom(workoutName = name)
            )
        }
    }

}