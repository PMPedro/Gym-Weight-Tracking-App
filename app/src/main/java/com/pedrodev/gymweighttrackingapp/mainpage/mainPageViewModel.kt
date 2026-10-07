package com.example.gymweighttrackingapp.mainpage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gymweighttrackingapp.data.room.WorkoutPlay.WorkoutPlayRepo
import com.example.gymweighttrackingapp.data.room.WorkoutPlay.WorkoutPlayRoom
import com.example.gymweighttrackingapp.utils.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class mainPageViewModel @Inject constructor (
    private val workoutPlayRepo: WorkoutPlayRepo,
) : ViewModel() {
    private val _uiState = MutableStateFlow(MainPageUiState())
    val uiState: StateFlow<MainPageUiState> = _uiState

    private val _workoutPLayName = MutableLiveData("")
    val workoutPlayName: LiveData<String> = _workoutPLayName

    init {
        loadWorkoutPlays()
    }

    fun createPlay() {
        val randomNumber = (1000..9999999999).random()
        val name = "My Workout $randomNumber"
        _workoutPLayName.value = name
        viewModelScope.launch {
            workoutPlayRepo.addWorkoutList(
                WorkoutPlayRoom(workoutName = name)
            )
        }
    }

    fun loadWorkoutPlays() {
        viewModelScope.launch {
            workoutPlayRepo.getWorkoutList().collect { result ->
                when (result) {
                    is Result.Loading -> {
                        _uiState.update {
                            it.copy(isLoading = true)
                        }
                    }

                    is Result.Success -> {
                        _uiState.update {
                            it.copy(
                                isLoading = false,
                                workouts = result.data,
                                error = null
                            )
                        }
                    }

                    is Result.Error -> {
                        _uiState.update {
                            it.copy(
                                isLoading = false,
                                error = result.exception.message
                            )
                        }
                    }
                }
            }
        }
    }

}