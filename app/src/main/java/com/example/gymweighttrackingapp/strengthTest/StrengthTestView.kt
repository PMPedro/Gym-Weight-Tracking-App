package com.example.gymweighttrackingapp.strengthTest

import android.content.res.Configuration
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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.flightsapp.ui.theme.AppSpacing
import com.example.gymweighttrackingapp.R
import com.example.gymweighttrackingapp.ui.theme.GymWeightTrackingAppTheme

/*
* In future make most of this code reusable , and use on other workouts lists
* */
@Composable
fun StrengthTest(
    onDoneButtonNav : () -> Unit
) {
    Column(
        modifier = Modifier.Companion
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
    ) {

        TopPartStrengthTest()
        Spacer(Modifier.Companion.padding(AppSpacing.M))
        WorkoutListWeightStrengthTest()
        Spacer(Modifier.Companion.padding(AppSpacing.S))
        BottomWeightButtonStrengthTest(onDoneButtonNav)

    }

}

@Composable
fun TopPartStrengthTest(

) {

    Surface(
        shadowElevation = 32.dp
    ) {
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
                    .fillMaxWidth()
                    .padding(start = 50.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Companion.Start
            )
            {
                Spacer(Modifier.Companion.padding(AppSpacing.XL))

                Row(
                    modifier = Modifier.Companion.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.Companion.CenterVertically
                ) {
                    Text(
                        "Strength Test",
                        style = MaterialTheme.typography.headlineLarge,
                        color = MaterialTheme.colorScheme.surface,
                        modifier = Modifier.Companion.fillMaxWidth(.7f)
                    )
                    Icon(
                        painter = painterResource(R.drawable.arm_9795045),
                        contentDescription = "",
                        tint = MaterialTheme.colorScheme.surface,
                        modifier = Modifier.Companion
                            .size(100.dp)

                    )
                }
                Text(
                    "MONDAY - Let's Test that Strength - Let's Gooooo",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.surface,

                    )

                Spacer(Modifier.Companion.padding(AppSpacing.XL))
            }
        }
    }
}

@Composable
fun WorkoutListWeightStrengthTest() {

    var tempWorkList = listOf<String>(
        "Deadlift with back ends behinf the back upside down",
        "Squat",
        "Etc",
        "Deadlift",
        "Squat",
        "Etc"
    )

    Column(
        modifier = Modifier.Companion.fillMaxHeight(0.8f)
    )
    {
        LazyColumn() {
            items(tempWorkList) { item ->
                StrengthTestWorkoutListWeightItem(item)
                Spacer(Modifier.Companion.padding(AppSpacing.S))
            }
        }
    }
}


@Composable
fun StrengthTestWorkoutListWeightItem(
    name: String
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
                    modifier = Modifier.Companion.size(50.dp),
                    tint = MaterialTheme.colorScheme.secondary
                )
                Text(
                    name,
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.Companion
                        .fillMaxWidth(.6f)
                        .basicMarquee(),
                    maxLines = 1,
                    overflow = TextOverflow.Companion.Clip
                )
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Companion.End,
                    modifier = Modifier.Companion
                        .fillMaxWidth()
                        .padding(end = 10.dp)
                        .clickable {

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
fun BottomWeightButtonStrengthTest(
    onDoneButtonNav : () -> Unit
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


@Preview(showBackground = true)
@Composable
fun PrevWorkoutList() {
    GymWeightTrackingAppTheme(darkTheme = false) {
        StrengthTest({})

    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun WorkoutListDark() {
    GymWeightTrackingAppTheme(darkTheme = true) {
        StrengthTest({})
    }
}