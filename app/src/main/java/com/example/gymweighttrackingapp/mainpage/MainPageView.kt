package com.example.gymweighttrackingapp.mainpage.view

import android.app.AlertDialog
import android.content.Context
import android.widget.EditText
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.flightsapp.ui.theme.AppSpacing
import com.example.gymweighttrackingapp.R
import com.example.gymweighttrackingapp.ui.theme.GymWeightTrackingAppTheme
import kotlin.collections.listOf

@Composable
fun MainPage(
    onStrengthTestNav : () -> Unit ,
    onWorkoutListNav : (String) -> Unit,
    onAddWorkoutNav : () -> Unit ,
    onWeightNav : () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface),

        ) {
        TopPart(onWeightNav)
        StrenghTest(onStrengthTestNav)
        Spacer(Modifier.padding(AppSpacing.XL))
        WorkoutPlayists(onWorkoutListNav)
        Spacer(Modifier.padding(AppSpacing.S))
        AddPlayButton(onAddWorkoutNav)
    }
}

// Custom diagonal shape
fun DiagonalShape() = GenericShape { size, _ ->
    moveTo(0f, 0f)
    lineTo(size.width, 0f)
    lineTo(size.width, size.height * 0.5f)
    lineTo(0f, size.height)

    close()
}

@Composable
fun TopPart(
    onWeightNav : () -> Unit
) {
    Surface(
        shape = DiagonalShape(),
        tonalElevation = 32.dp,
        shadowElevation = 32.dp
    )
    {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
                .clip(DiagonalShape())
                .background(MaterialTheme.colorScheme.primary),
            contentAlignment = Alignment.TopCenter,
            ) {

            WeightSection({ "250" },onWeightNav )
        }
    }
}

@Composable
fun WeightSection(
    funThatGivesWeight: () -> String,
    navToWeight: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Spacer(Modifier.padding(AppSpacing.M))
        Icon(
            painter = painterResource(R.drawable.scale),
            contentDescription = "",
            tint = MaterialTheme.colorScheme.surface,
            modifier = Modifier.clickable {
                navToWeight()
            }
        )
        Text(
            funThatGivesWeight() + "KG",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.surface,
        )
    }
}

@Composable
fun StrenghTest(onStrengthTestNav : () -> Unit ) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    )
    {
        Text(
            "LET'S GOOOOOO",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.secondary
        )
        Spacer(Modifier.padding(AppSpacing.S))
        Button(
            modifier = Modifier.fillMaxWidth(0.8f),
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
                onStrengthTestNav()
            }
        ) {
            Text(
                "Strength Test",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSecondary
            )
        }
    }
}

@Composable
fun WorkoutPlayists(
    onWorkoutListNav : (String) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            "Weight Tracking",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurface
        )
        val workoutLists =
            listOf<String>("Lower", "Upper", "Lower", "Upper", "Lower", "Upper", "Lower", "Upper")
        Column(
            modifier = Modifier.fillMaxHeight(0.5f)
        )
        {
            LazyColumn() {
                items(workoutLists) { item ->
                    WorkoutPlayistsItems(item , onWorkoutListNav)
                    Spacer(Modifier.padding(AppSpacing.S))
                }
            }
        }
    }
}

@Composable
fun WorkoutPlayistsItems(
    //todo add a data class here , with the lists name and all
    listName: String ,
    onWorkoutListNav : (String) -> Unit
) {
    Button(
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 8.dp,
            pressedElevation = 12.dp
        ),
        modifier = Modifier
            .fillMaxWidth(0.7f)
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.secondary,
                shape = RoundedCornerShape(16.dp)
            )
            .shadow(8.dp, RoundedCornerShape(16.dp))
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.surface,
                        MaterialTheme.colorScheme.secondary
                    )
                ),
                shape = RoundedCornerShape(16.dp),
            ),
        onClick = {
            onWorkoutListNav(
                listName
            )
        }) {
        Text(
            listName,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSecondary
        )
    }
}

@Composable
fun AddPlayButton(
    onAddWorkoutNav : () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    )
    {
        Button(
            modifier = Modifier.fillMaxWidth(0.8f),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
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
                //TODO add a modal to schose a playist name

                onAddWorkoutNav()
            }
        ) {
            Text(
                "Add Workout List",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}

@Composable
fun WorkoutExercisesDialog (
    context: Context ,
    onConfirm: (String) -> Unit)
{
    val editText = EditText(context)
    editText.hint = "Workout List Name"

    val dialog = AlertDialog.Builder(context)
        .setTitle("Create Workout List")
        .setView(editText)
        .setPositiveButton("Create" , null)
        .setNegativeButton("Cancel", null)
        .create()

    dialog.setOnShowListener {
        val button = dialog.getButton(AlertDialog.BUTTON_POSITIVE)
        button.setOnClickListener {
            val name = editText.text.toString()
            if(name.isBlank()){
                editText.error = "Name Required"
            }else if (name.length < 3){
                editText.error = "Must Have at Least 3 letters"
            }else{
                onConfirm(name)
                dialog.dismiss()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PrevMainPage() {
    GymWeightTrackingAppTheme(darkTheme = false) {
        MainPage({} , {} , {}, {})
    }
}

@Preview(showBackground = true, uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PrevMainPageDark() {
    GymWeightTrackingAppTheme(darkTheme = true) {
        MainPage({} , {} , {}, {})
    }
}


