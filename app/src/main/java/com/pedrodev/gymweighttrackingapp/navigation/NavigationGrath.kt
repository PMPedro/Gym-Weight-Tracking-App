package com.example.gymweighttrackingapp.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.gymweighttrackingapp.data.room.WorkoutPlay.WorkoutPlayRepo
import com.example.gymweighttrackingapp.mainpage.MainPage
import com.example.gymweighttrackingapp.mainpage.mainPageViewModel
import com.example.gymweighttrackingapp.strengthTest.StrengthTest
import com.example.gymweighttrackingapp.weightTracker.WeightTracker
import com.example.gymweighttrackingapp.workoutListEdit.WorkoutListEdit
import com.example.gymweighttrackingapp.workoutListEdit.WorkoutListEditViewModel
import com.example.gymweighttrackingapp.workoutLists.WorkoutListScreen
import com.example.gymweighttrackingapp.workoutLists.workoutListViewModel


@Composable
fun NavigationGrath(
    navController: NavHostController,
    ) {

    NavHost(navController = navController, startDestination = Screens.MainPage.route)
    {

        composable(Screens.MainPage.route) {
            val mainPageViewModel: mainPageViewModel = hiltViewModel()
            MainPage(
                onStrengthTestNav = { navController.navigate(Screens.StrengthTest.route) },
                onWorkoutListNav = { workoutId ->
                    navController.navigate(Screens.WorkoutListDetail.createRoute(workoutId))
                },
                onAddWorkoutNav = { navController.navigate(Screens.WorkoutListEdit.route) },
                onWeightNav = { navController.navigate(Screens.WeightTracker.route) },
                viewModel = mainPageViewModel
            )
        }

        composable(
            route = Screens.WorkoutListDetail.route,
            arguments = listOf(
                navArgument("workoutId") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val workoutListViewModel: workoutListViewModel = hiltViewModel()


            WorkoutListScreen(
                onWorkoutEditListNav = { workoutId ->
                    navController.navigate(Screens.WorkoutListEditDetail.createRoute(workoutId))
                },
                onDoneButtonNav = { navController.popBackStack() } ,
                viewModel = workoutListViewModel
            )
        }

        composable(Screens.WorkoutList.route) {
            val workoutListViewModel: workoutListViewModel = hiltViewModel()
            WorkoutListScreen(
                onWorkoutEditListNav = { workoutId ->
                    navController.navigate(Screens.WorkoutListEditDetail.createRoute(workoutId))
                },
                onDoneButtonNav = { navController.popBackStack() } ,
                viewModel = workoutListViewModel
            )
        }

        composable(

            route = Screens.WorkoutListEditDetail.route,
            arguments = listOf(
                navArgument("workoutId") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val workoutListEditViewModel: WorkoutListEditViewModel = hiltViewModel()

            WorkoutListEdit(
                onSaveButtonNav = { navController.popBackStack() } ,
                viewModel = workoutListEditViewModel
            )
        }



        composable(Screens.WorkoutListEdit.route) {
            val workoutListEditViewModel: WorkoutListEditViewModel = hiltViewModel()
            WorkoutListEdit(
                onSaveButtonNav = { navController.popBackStack() } ,
                viewModel = workoutListEditViewModel
            )
        }


        composable(Screens.StrengthTest.route) {
            StrengthTest(
                onDoneButtonNav = { navController.popBackStack() }
            )
        }

        composable(Screens.WeightTracker.route) {
            WeightTracker()
        }


    }
}
