package com.example.gymweighttrackingapp.workoutLists

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gymweighttrackingapp.data.dataClasses.Exercises
import com.example.gymweighttrackingapp.data.room.Exercises.ExerciseRepoRoom
import com.example.gymweighttrackingapp.data.room.WorkoutExercise.WorkoutExerciseRepo
import com.example.gymweighttrackingapp.data.room.WorkoutPlay.WorkoutPlayRepo
import javax.inject.Inject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.gymweighttrackingapp.utils.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import android.util.Log

@HiltViewModel
class workoutListViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val workoutPlayRepo: WorkoutPlayRepo,
    private val exercisesRepo: ExerciseRepoRoom,
    private val workoutExercises: WorkoutExerciseRepo
) : ViewModel() {

    val playlistName: String = savedStateHandle["workoutId"] ?: ""
    private val _workoutPlayId = MutableStateFlow<Long>(0L)
    val workoutPlayId: StateFlow<Long> = _workoutPlayId

    private val _uiState = MutableStateFlow(WorkoutUiState())
    val uiState: StateFlow<WorkoutUiState> = _uiState

    private val _workoutPLayName = MutableLiveData(playlistName)
    val workoutPlayName: LiveData<String> = _workoutPLayName


    init {

        loadWorkoutId()

    }

    fun loadWorkoutId() {
        viewModelScope.launch {

            val id = workoutPlayRepo
                .getWorkoutIdByName(_workoutPLayName.value.toString())

            loadWorkoutExerciseData(id)
        }
    }

    fun loadWorkoutExerciseData(workoutId: Long) {
        viewModelScope.launch {
            workoutExercises.getByWorkoutId(workoutId).collect { result ->
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
                                workouts = result.data
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

    fun updateSets(exerciseName: String, sets: Int){
        viewModelScope.launch {
            val id = exercisesRepo.getExerciseIdByName(exerciseName)
            exercisesRepo.updateSets(sets , id)
        }
    }

    fun updateReps(exerciseName: String, reps: Int){
        viewModelScope.launch {
            val id = exercisesRepo.getExerciseIdByName(exerciseName)
            exercisesRepo.updateReps(reps , id)
        }
    }

    fun updateWeight(exerciseName: String, weight: Float){
        viewModelScope.launch {
            val id = exercisesRepo.getExerciseIdByName(exerciseName)
            exercisesRepo.updateWeight(weight , id)
        }
    }



}
