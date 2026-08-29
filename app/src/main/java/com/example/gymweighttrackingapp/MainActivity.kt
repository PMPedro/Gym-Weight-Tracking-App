package com.example.gymweighttrackingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.gymweighttrackingapp.data.room.WorkoutPlay.WorkoutPlayDAO
import com.example.gymweighttrackingapp.data.room.WorkoutPlay.WorkoutPlayRepo
import com.example.gymweighttrackingapp.navigation.NavigationGrath
import com.example.gymweighttrackingapp.ui.theme.GymWeightTrackingAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            GymWeightTrackingAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    NavigationGrath(navController = navController)
                }
            }
        }

    }
}
