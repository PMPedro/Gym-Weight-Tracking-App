package com.example.gymweighttrackingapp.workoutListEdit

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.gymweighttrackingapp.data.api.ExerciseRepository
import com.example.gymweighttrackingapp.data.room.Exercises.ExerciseRepoRoom
import com.example.gymweighttrackingapp.data.room.WorkoutExercise.WorkoutExerciseRepo
import com.example.gymweighttrackingapp.workoutLists.WorkoutUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.gymweighttrackingapp.BuildConfig
import com.example.gymweighttrackingapp.data.dataClasses.Exercises
import com.example.gymweighttrackingapp.data.dataClasses.WorkoutExercise
import com.example.gymweighttrackingapp.data.room.Exercises.ExercisesRoom
import com.example.gymweighttrackingapp.data.room.WorkoutExercise.WorkoutExerciseRoom
import com.example.gymweighttrackingapp.data.room.WorkoutExercisesRelation
import com.example.gymweighttrackingapp.data.room.WorkoutPlay.WorkoutPlayRepo
import com.example.gymweighttrackingapp.utils.ApiKeys
import kotlinx.coroutines.flow.filter
import kotlin.math.log

@HiltViewModel
class WorkoutListEditViewModel @Inject constructor(
    private val apiRepo: ExerciseRepository,
    private val workoutPlayRepo: WorkoutPlayRepo,
    private val exercisesRepo: ExerciseRepoRoom,
    private val workoutExercisesRepo: WorkoutExerciseRepo ,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _uiState = MutableStateFlow(WorkoutListEditUiState())
    val uiState: StateFlow<WorkoutListEditUiState> = _uiState

    val playlistName: String = savedStateHandle["workoutId"] ?: ""

    private val _workoutPLayName = MutableLiveData(playlistName)
    val workoutPlayName: LiveData<String> = _workoutPLayName

    init {
        loadExercises()
    }

    fun loadExercises(
        muscle : String? = null
    ) {
        viewModelScope.launch {
            val apiKey = ApiKeys.API_NINJAS_KEY
            //apiRepo.getExercises()
            _uiState.value = WorkoutListEditUiState(isLoading = true)

            try {

                val data = apiRepo.getExercises(muscle = muscle, apiKey = apiKey)

                _uiState.value = WorkoutListEditUiState(
                    isLoading = false,
                    workouts = data
                )

            } catch (e: Exception) {
                _uiState.value = WorkoutListEditUiState(
                    isLoading = false,
                    error = e.message
                )
            }
        }
    }


    fun addToList(item : Exercises){
        // TODO: replace name-based lookup with insert-returned ID

        viewModelScope.launch {

            val exRom = ExercisesRoom(
                name = item.name ,
                type = item.type ,
                muscle = item.muscle ,
                difficulty = item.difficulty ,
                instructions = item.instructions ,
                equipments = item.equipments.joinToString(" - ") ,
                sets = 0 ,
                reps = 0 ,
                weight = 0.0f
            )

            try {
                exercisesRepo.addExercise(exRom)

                val id = exercisesRepo.getExerciseIdByName(item.name)
                val workoutPlayId = workoutPlayRepo.getWorkoutIdByName(playlistName)

                workoutExercisesRepo.addExercise(
                    WorkoutExerciseRoom(
                        workoutId = workoutPlayId ,
                        exerciseId = id
                    ))

            }catch (e : Exception) {
                Log.d("ERROR", "==> ${e.message} <==")
            }
        }
    }



}