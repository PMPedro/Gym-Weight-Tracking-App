package com.example.gymweighttrackingapp.weightTracker

import androidx.compose.foundation.background
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
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.flightsapp.ui.theme.AppSpacing
import com.example.gymweighttrackingapp.R
/*
import com.example.gymweighttrackingapp.ui.theme.GymWeightTrackingAppTheme
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
*/



@Composable
fun WeightTracker() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
    ) {
       // WeightTrackerTopPart()
        Spacer(Modifier.padding(AppSpacing.L))
        //weightPlot()
    }
}
/*

@Composable
fun WeightTrackerTopPart() {
    Column(
        modifier = Modifier
            .fillMaxHeight(.5f)
            .background(MaterialTheme.colorScheme.primary),
        verticalArrangement = Arrangement.Center,
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(R.drawable.scale),
                contentDescription = "Weight",
                tint = MaterialTheme.colorScheme.surface
            )
            Spacer(Modifier.padding(AppSpacing.M))
            Row() {
                Column(

                ) {
                    Text(
                        "250kg",
                        style = MaterialTheme.typography.headlineLarge,
                        color = MaterialTheme.colorScheme.surface,
                    )

                    Text(
                        "170CM",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.surface,
                    )

                    Text(
                        "50IMC",
                        style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.surface,
                    )

                }

                Icon(
                    painter = painterResource(R.drawable.outline_edit_24),
                    contentDescription = "Edit Weight",
                    tint = MaterialTheme.colorScheme.surface,
                    modifier = Modifier
                        .size(70.dp)
                        .clickable{
                            //todo Do stuff
                        }
                )
            }

        }
    }
}

@Composable
fun weightPlot (){
    Column() {
        val weight = listOf<Float>(50.0f , 51.0f , 55.02f , 53.5f , 60f)
        val dates = listOf<String>("18/01" , "20/01" , "18/02" , "01/03" , "18/04" )

        WeightChartMaterial(weight , dates)


    }
}
@Composable
fun WeightChartMaterial(
    weights: List<Float>,
    dates: List<String>,
    modifier: Modifier = Modifier
) {
    val primary = MaterialTheme.colorScheme.primary
    val onSurface = MaterialTheme.colorScheme.onSurface
    val surface = MaterialTheme.colorScheme.surface

    AndroidView(
        modifier = modifier
            .fillMaxWidth()
            .height(220.dp),
        factory = { context ->
            LineChart(context).apply {


                val entries = weights.mapIndexed { index, value ->
                    Entry(index.toFloat(), value)
                }

                val dataSet = LineDataSet(entries, "Weight").apply {
                    color = primary.toArgb()
                    lineWidth = 2.5f

                    setDrawCircles(true)
                    setCircleColor(primary.toArgb())
                    circleRadius = 4f
                    setDrawCircleHole(false)

                    setDrawValues(false)


                    setDrawFilled(true)
                    fillColor = primary.toArgb()
                    fillAlpha = 60

                    mode = LineDataSet.Mode.CUBIC_BEZIER
                }

                data = LineData(dataSet)

                // --- X Axis ---
                xAxis.apply {
                    valueFormatter = IndexAxisValueFormatter(dates)
                    position = XAxis.XAxisPosition.BOTTOM
                    textColor = onSurface.toArgb()
                    textSize
Unresolved reference 'observeAsState'. = 10f
                    setDrawGridLines(false)
                    granularity = 1f
                    axisLineColor = onSurface.toArgb()
                }

                // --- Y Axis ---
                axisLeft.apply {
                    textColor = onSurface.toArgb()
                    textSize = 10f
                    setDrawGridLines(true)
                    gridColor = onSurface.copy(alpha = 0.15f).toArgb()
                    axisLineColor = onSurface.toArgb()
                }

                axisRight.isEnabled = false


                legend.isEnabled = false
                description.isEnabled = false
                setTouchEnabled(false)
                setScaleEnabled(false)

                setBackgroundColor(surface.toArgb())
                setViewPortOffsets(40f, 20f, 20f, 30f)

                invalidate()
            }
        }
    )
}




@Preview(showBackground = true)
@Composable
fun PrevWorkoutList() {
    GymWeightTrackingAppTheme(darkTheme = false) {
        WeightTracker()

    }
}

@Preview(showBackground = true, uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES)
@Composable
fun WorkoutListDark() {
    GymWeightTrackingAppTheme(darkTheme = true) {
        WeightTracker()

    }
}
*/