package com.example.gymweighttrackingapp.workoutLists.view

import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.gymweighttrackingapp.ui.theme.GymWeightTrackingAppTheme
import java.nio.file.WatchEvent
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Locale


@Composable
fun WorkoutListScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
    ) {

        TopPart()
        Spacer(Modifier.padding(AppSpacing.M))
        WorkoutListWeight()
        Spacer(Modifier.padding(AppSpacing.S))
        BottomWeightButton()

    }

}

@Composable
fun TopPart() {

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
                    .padding(start = 50.dp)
                ,
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            )
            {
                Spacer(Modifier.padding(AppSpacing.XL))

                Row(
                    modifier = Modifier.fillMaxWidth() ,
                    horizontalArrangement = Arrangement.Start ,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "Deadlift" ,
                            style = MaterialTheme.typography.headlineLarge ,
                            color = MaterialTheme.colorScheme.surface ,
                            modifier = Modifier.fillMaxWidth(.7f)
                        )
                    Icon(
                        painter = painterResource(R.drawable.outline_edit_24) ,
                        contentDescription = "" ,
                        tint = MaterialTheme.colorScheme.surface ,
                        modifier = Modifier.size(100.dp)
                    )
                }
                Text(
                    "MONDAY - Gym Session - Let's Gooooo" ,
                    style = MaterialTheme.typography.bodySmall ,
                    color = MaterialTheme.colorScheme.surface ,

                    )

                Spacer(Modifier.padding(AppSpacing.XL))
            }
        }
    }
}

@Composable
fun WorkoutListWeight() {

    var tempWorkList = listOf<String>(
        "Deadlift with back ends behinf the back upside down",
        "Squat",
        "Etc",
        "Deadlift",
        "Squat",
        "Etc"
    )

    Column(
        modifier = Modifier.fillMaxHeight(0.8f)
    )
    {
        LazyColumn() {
            items(tempWorkList) { item ->
                WorkoutListWeightItem(item)
                Spacer(Modifier.padding(AppSpacing.S))
            }
        }
    }
}


@Composable
fun WorkoutListWeightItem(
    name: String
) {
    Surface(
        shadowElevation = 8.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.surface,
                            MaterialTheme.colorScheme.secondary
                        )
                    ),
                ),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(R.drawable.corner_down_right),
                    contentDescription = "",
                    modifier = Modifier.size(50.dp),
                    tint = MaterialTheme.colorScheme.secondary
                )
                Text(
                    name,
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier
                        .fillMaxWidth(.6f)
                        .basicMarquee(),
                    maxLines = 1,
                    overflow = TextOverflow.Clip
                )
                Column(
                    verticalArrangement = Arrangement.Center ,
                    horizontalAlignment = Alignment.End ,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 10.dp)
                        .clickable{

                        }
                ) {
                    Text(
                        "4 Sets",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.surface
                    )
                    Text(
                        "10 Reps",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.surface
                    )
                    Text(
                        "Max" + " !0kg",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.surface
                    )
                }
            }
            Text(
                "INTERMIDIADIATE" + " - " + "Strengh" + " - " + "Full Body",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.secondary
            )
        }

    }

}


@Composable
fun BottomWeightButton() {
    Column(
        modifier = Modifier.fillMaxWidth() ,
        verticalArrangement = Arrangement.Center ,
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


@Preview(showBackground = true)
@Composable
fun PrevWorkoutList() {
    GymWeightTrackingAppTheme(darkTheme = false) {
        WorkoutListScreen()

    }
}

@Preview(showBackground = true, uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES)
@Composable
fun WorkoutListDark() {
    GymWeightTrackingAppTheme(darkTheme = true) {
        WorkoutListScreen()
    }
}

