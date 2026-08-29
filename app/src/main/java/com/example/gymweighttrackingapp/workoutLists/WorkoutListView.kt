package com.example.gymweighttrackingapp.workoutLists

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.flightsapp.ui.theme.AppSpacing
import com.example.gymweighttrackingapp.R
import com.example.gymweighttrackingapp.data.room.Exercises.ExercisesRoom
import com.example.gymweighttrackingapp.mainpage.MainPageUiState
import com.example.gymweighttrackingapp.ui.theme.GymWeightTrackingAppTheme
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


@Composable
fun WorkoutListScreen(
    onWorkoutEditListNav: (String) -> Unit,
    onDoneButtonNav: () -> Unit,
    viewModel: workoutListViewModel
) {
    val state by viewModel.uiState.collectAsState()
    val playistName by viewModel.workoutPlayName.observeAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
    ) {


        TopPart(onWorkoutEditListNav, playistName.toString())
        Spacer(Modifier.padding(AppSpacing.M))
        WorkoutListWeight(state = state, viewModel)
        Spacer(Modifier.padding(AppSpacing.S))
        BottomWeightButton(onDoneButtonNav)

    }

}

@Composable
fun TopPart(
    onWorkoutEditListNav: (String) -> Unit,
    playistName: String
) {
    val dayName = SimpleDateFormat("EEEE", Locale.getDefault())
        .format(Calendar.getInstance().time)


    Surface(
        shadowElevation = 32.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primary),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        )
        {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 50.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            )
            {
                Spacer(Modifier.padding(AppSpacing.XL))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        "$playistName",
                        style = MaterialTheme.typography.headlineLarge,
                        color = MaterialTheme.colorScheme.surface,
                        modifier = Modifier
                            .fillMaxWidth(.7f)
                            .basicMarquee(),
                        maxLines = 1,
                        overflow = TextOverflow.Visible
                    )

                    Icon(
                        painter = painterResource(R.drawable.outline_edit_24),
                        contentDescription = "",
                        tint = MaterialTheme.colorScheme.surface,
                        modifier = Modifier
                            .size(100.dp)
                            .clickable {
                                onWorkoutEditListNav(playistName)
                            }

                    )
                }
                Text(
                    "$dayName - Gym Session - Let's Gooooo",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.surface,

                    )

                Spacer(Modifier.padding(AppSpacing.XL))
            }
        }
    }
}

@Composable
fun WorkoutListWeight(
    state: WorkoutUiState,
    viewModel: workoutListViewModel
) {
    Column(
        modifier = Modifier.fillMaxHeight(0.8f)
    )
    {
        if (state.workouts.isEmpty()) {
            nothingToShowText()
            Log.d("INFOTAG","state -> $state stateWorkouts-> ${state.workouts} and ->" )
        } else {

            LazyColumn {
                items(state.workouts) { item ->

                    item.exercises.forEach { exercise ->
                        WorkoutListWeightItem(exercise, viewModel)
                        Spacer(Modifier.padding(AppSpacing.S))
                    }

                }

            }
        }
    }

}

@Composable
fun nothingToShowText() {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    )
    {
        Text(
            "Nothing to show yet...",
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.bodyLarge,
        )
        Spacer(Modifier.padding(AppSpacing.M))

        Text(
            "Go to Edit , to add some Exercises! ",
            color = MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.bodyMedium,
        )
        Spacer(Modifier.padding(AppSpacing.M))
        Text(
            "Lets Gooo!",
            color = MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.bodySmall,
        )

    }
}

@Composable
fun WorkoutListWeightItem(
    exercisesRoom: ExercisesRoom,
    viewModel: workoutListViewModel
) {
    Surface(
        shadowElevation = 8.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(130.dp) // was 100.dp — too tight for 2 rows of content
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.surface,
                            MaterialTheme.colorScheme.secondary
                        )
                    ),
                )
                .padding(vertical = 8.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Row 1: icon + name
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    painter = painterResource(R.drawable.corner_down_right),
                    contentDescription = "",
                    modifier = Modifier.size(40.dp),
                    tint = MaterialTheme.colorScheme.secondary
                )
                Text(
                    exercisesRoom.name,
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier
                        .weight(1f)
                        .basicMarquee(),
                    maxLines = 1,
                    overflow = TextOverflow.Visible
                )
            }

            // Row 2: the 3 number inputs, side by side
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp)
            ) {
                NumberField(
                    label = "Sets",
                    value = exercisesRoom.sets.toString(),
                    onValueChange = { text ->
                        text.toIntOrNull()?.let { viewModel.updateSets(exercisesRoom.name, it) }
                    }
                )
                NumberField(
                    label = "Reps",
                    value = exercisesRoom.reps.toString(),
                    onValueChange = { text ->
                        text.toIntOrNull()?.let { viewModel.updateReps(exercisesRoom.name, it) }
                    }
                )
                NumberField(
                    label = "Kg",
                    value = exercisesRoom.weight.toString(),
                    onValueChange = { text ->
                        text.toFloatOrNull()?.let { viewModel.updateWeight(exercisesRoom.name, it) }
                    }
                )
            }
        }
    }
}

@Composable
fun NumberField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            label,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSecondary
        )
        Spacer(Modifier.height(2.dp))
        Box(
            modifier = Modifier
                .width(52.dp)
                .height(36.dp)
                .background(
                    color = MaterialTheme.colorScheme.surface,
                    shape = MaterialTheme.shapes.small
                ),
            contentAlignment = Alignment.Center
        ) {
            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                textStyle = MaterialTheme.typography.bodyMedium.copy(
                    color = MaterialTheme.colorScheme.onSurface,
                    textAlign = TextAlign.Center
                ),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp)
            )
        }
    }
}


@Composable
fun BottomWeightButton(
    onDoneButtonNav: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            modifier = Modifier.fillMaxWidth(0.9f),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.secondary,
                contentColor = MaterialTheme.colorScheme.onSecondary
            ),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 8.dp,
                pressedElevation = 12.dp,
                disabledElevation = 0.dp,
                hoveredElevation = 10.dp,
                focusedElevation = 10.dp
            ),
            onClick = {
                onDoneButtonNav()
            }
        ) {
            Text(
                "Done",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSecondary
            )
        }
    }
}

/*
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun WorkoutListDark() {
    GymWeightTrackingAppTheme(darkTheme = true) {
        //  WorkoutListScreen({} , {})
    }
}
*/
