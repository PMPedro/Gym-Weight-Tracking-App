package com.example.gymweighttrackingapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.gymweighttrackingapp.data.room.WorkoutPlay.WorkoutPlayRepo
import com.example.gymweighttrackingapp.mainpage.mainPageViewModel
import com.example.gymweighttrackingapp.utils.Result
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class MainPageViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var repo: WorkoutPlayRepo
    private lateinit var viewModel: mainPageViewModel

    @Before
    fun setup() {

        repo = mockk(relaxed = true)

        every {
            repo.getWorkoutList()
        } returns flowOf(Result.Success(emptyList()))

        viewModel = mainPageViewModel(repo)
    }

    @Test
    fun createPlay_callsRepositoryAddWorkoutList() = runTest {

        viewModel.createPlay()

        advanceUntilIdle()

        coVerify {
            repo.addWorkoutList(any())
        }
    }
}