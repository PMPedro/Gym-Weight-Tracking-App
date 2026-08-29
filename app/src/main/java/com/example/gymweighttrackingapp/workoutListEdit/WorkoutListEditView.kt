package com.example.gymweighttrackingapp.workoutListEdit

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.flightsapp.ui.theme.AppShapes
import com.example.flightsapp.ui.theme.AppSpacing
import com.example.gymweighttrackingapp.R
import com.example.gymweighttrackingapp.data.dataClasses.Exercises
import com.example.gymweighttrackingapp.ui.theme.GymWeightTrackingAppTheme
import javax.annotation.meta.When

@Composable
fun WorkoutListEdit(
    onSaveButtonNav: () -> Unit,
    viewModel: WorkoutListEditViewModel
) {


    val state by viewModel.uiState.collectAsState()
    Column(
        modifier = Modifier.Companion
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
    ) {

        SearchBar(viewModel)
        Spacer(Modifier.Companion.padding(AppSpacing.M))
        WorkoutList(state,viewModel)
        Spacer(Modifier.Companion.padding(AppSpacing.S))
        BottomButton(onSaveButtonNav)

    }

}

@Composable
fun SearchBar(
    viewModel: WorkoutListEditViewModel
) {
    Surface(
        shadowElevation = 32.dp
    ) {
        var text by remember { mutableStateOf("") }
        Column(
            modifier = Modifier.Companion
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primary),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Companion.CenterHorizontally,
        )
        {
            Column(
                modifier = Modifier.Companion
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Companion.CenterHorizontally
            )
            {
                Spacer(Modifier.Companion.padding(AppSpacing.XL))
                OutlinedTextField(
                    value = text,
                    modifier = Modifier.Companion.fillMaxWidth(0.95f),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                        unfocusedBorderColor = Color.Companion.Transparent
                    ),
                    shape = AppShapes.extraLarge,
                    trailingIcon = {
                        Icon(
                            painter = painterResource(R.drawable.search),
                            contentDescription = "",
                            modifier = Modifier.Companion.size(40.dp)
                            // tint = MaterialTheme.colorScheme.primary
                        )
                    },
                    onValueChange = {
                        text = it
                        viewModel.loadExercises(text)
                    },
                    label = {
                        Text(
                            "Muscle name",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                )
                Spacer(Modifier.Companion.padding(AppSpacing.XL))
            }
        }
    }
}

@Composable
fun WorkoutList(
    state: WorkoutListEditUiState ,
    viewModel: WorkoutListEditViewModel
) {
    Column(
        modifier = Modifier.Companion.fillMaxHeight(0.8f)
    )
    {
        when {
            state.isLoading -> {
                SpiningLoadWheel()
            }

            state.error != null -> {
                errorText("Error fetching data")
            }

            state.workouts.isEmpty() -> {
                errorText("Error fetching data (is empty) ")
            }

            else -> {
                LazyColumn() {
                    items(state.workouts) { item ->
                        WorkoutListItem(item,viewModel)
                        Spacer(Modifier.Companion.padding(AppSpacing.S))
                    }
                }
            }
        }
    }
}

@Composable
fun errorText(
    text: String

) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            "$text ",
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.headlineMedium
        )
    }
}

@Composable
fun SpiningLoadWheel() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}


@Composable
fun WorkoutListItem(
    item: Exercises ,
    viewModel: WorkoutListEditViewModel
) {
    Surface(
        shadowElevation = 8.dp
    ) {
        Column(
            modifier = Modifier.Companion
                .fillMaxWidth()
                .height(100.dp)
                .background(
                    brush = Brush.Companion.horizontalGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.surface,
                            MaterialTheme.colorScheme.secondary
                        )
                    ),
                ),
            horizontalAlignment = Alignment.Companion.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                verticalAlignment = Alignment.Companion.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(R.drawable.corner_down_right),
                    contentDescription = "",
                    modifier = Modifier
                        .Companion
                        .size(50.dp)

                    ,
                    tint = MaterialTheme.colorScheme.secondary
                )
                Text(
                    item.name,
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.Companion
                        .fillMaxWidth(.9f)
                        .basicMarquee(),
                    maxLines = 1,
                    overflow = TextOverflow.Companion.Clip
                )
                Icon(
                    painter = painterResource(R.drawable.add_ic),
                    contentDescription = "",
                    tint = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier
                        .Companion
                        .size(50.dp).clickable{
                            viewModel.addToList(item)
                        }

                )

            }
            Text(
                "${item.difficulty}" + " - " + "${item.type}" + " - " + "${item.muscle}",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.secondary
            )
        }

    }

}


@Composable
fun BottomButton(
    onSaveButtonNav: () -> Unit
) {
    Column(
        modifier = Modifier.Companion.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Companion.CenterHorizontally
    ) {
        Button(
            modifier = Modifier.Companion.fillMaxWidth(0.9f),
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
                onSaveButtonNav()
            }
        ) {
            Text(
                "Save",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSecondary
            )
        }
    }
}
