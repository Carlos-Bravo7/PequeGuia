package com.duty.pequeguia.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.yml.charts.axis.AxisData
import co.yml.charts.common.model.Point
import co.yml.charts.ui.linechart.LineChart
import co.yml.charts.ui.linechart.model.GridLines
import co.yml.charts.ui.linechart.model.IntersectionPoint
import co.yml.charts.ui.linechart.model.Line
import co.yml.charts.ui.linechart.model.LineChartData
import co.yml.charts.ui.linechart.model.LinePlotData
import co.yml.charts.ui.linechart.model.LineStyle
import co.yml.charts.ui.linechart.model.LineType
import co.yml.charts.ui.linechart.model.SelectionHighlightPoint
import co.yml.charts.ui.linechart.model.SelectionHighlightPopUp
import co.yml.charts.ui.linechart.model.ShadowUnderLine
import com.duty.pequeguia.R


@Composable
fun RegistroNino() {
    var sexo: Boolean = true
    var edad by remember { mutableStateOf("") }
    var peson by remember { mutableStateOf("") }
    var pesoactu by remember { mutableStateOf("") }
    var tallan by remember { mutableStateOf("") }
    var tallaactu by remember { mutableStateOf("") }
    var graf: Boolean = false


    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.newfondo),
            contentDescription = "Fondo",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.padding(20.dp))
            Text(
                text = "Guia de crecimiento",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )
            Text(
                text = "Completa la siguiente información",
                fontSize = 15.sp
            )
            Spacer(modifier = Modifier.padding(10.dp))

            //Parte blanca
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White.copy(alpha = 0.5f))
                    .blur(30.dp)

            )
            {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.padding(5.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    )
                    {
                        Text(text = "Sexo")

                        Button(
                            onClick = { sexo = true },
                            modifier = Modifier
                                .width(100.dp)
                                .height(48.dp),
                            colors = ButtonDefaults.buttonColors(
                                Color(0xFFFFCBCB),
                                Color.Black,
                                Color(0xFFFFCBCB),
                                Color.Black
                            )
                        )
                        {
                            Text(text = "Niña")
                            Icon(
                                imageVector = ImageVector.vectorResource(R.drawable.baseline_female_24),
                                contentDescription = "jh"
                            )
                        }
                        Button(
                            onClick = { sexo = false },
                            modifier = Modifier
                                .width(100.dp)
                                .height(48.dp),
                            colors = ButtonDefaults.buttonColors(
                                Color(0xFFA3D8FF),
                                Color.Black,
                                Color(0xFFA3D8FF),
                                Color.Black
                            )
                        )
                        {
                            Text(text = "Niño")
                            Icon(
                                imageVector = ImageVector.vectorResource(R.drawable.baseline_male_24),
                                contentDescription = "jh"
                            )
                        }
                    }
                    Spacer(modifier = Modifier.padding(5.dp))
                    OutlinedTextField(
                        value = peson,
                        onValueChange = { peson = it },
                        modifier = Modifier,
                        textStyle = TextStyle(color = Color.Black),
                        label = { Text(text = "Peso al nacer") },
                        placeholder = { Text(text = "Ingrese el peso al nacer") },
                        leadingIcon = {
                            Icon(
                                imageVector = ImageVector.vectorResource(R.drawable.baseline_airline_seat_flat_24),
                                contentDescription = ""
                            )
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                        singleLine = true,
                        maxLines = 1,
                        minLines = 1,
                        shape = RoundedCornerShape(20.dp)
                    )
                    Spacer(modifier = Modifier.padding(3.dp))
                    OutlinedTextField(
                        value = pesoactu,
                        onValueChange = { pesoactu = it },
                        modifier = Modifier,
                        textStyle = TextStyle(color = Color.Black),
                        label = { Text(text = "Peso actual") },
                        placeholder = { Text(text = "Ingrese el peso actual") },
                        leadingIcon = {
                            Icon(
                                imageVector = ImageVector.vectorResource(R.drawable.baseline_airline_seat_flat_24),
                                contentDescription = ""
                            )
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                        singleLine = true,
                        maxLines = 1,
                        minLines = 1,
                        shape = RoundedCornerShape(20.dp)
                    )
                    Spacer(modifier = Modifier.padding(3.dp))
                    OutlinedTextField(
                        value = tallan,
                        onValueChange = { tallan = it },
                        modifier = Modifier,
                        textStyle = TextStyle(color = Color.Black),
                        label = { Text(text = "Talla al nacer") },
                        placeholder = { Text(text = "Ingrese la talla al nacer") },
                        leadingIcon = {
                            Icon(
                                imageVector = ImageVector.vectorResource(R.drawable.baseline_format_line_spacing_24),
                                contentDescription = ""
                            )
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                        singleLine = true,
                        maxLines = 1,
                        minLines = 1,
                        shape = RoundedCornerShape(20.dp)
                    )
                    Spacer(modifier = Modifier.padding(3.dp))
                    OutlinedTextField(
                        value = tallaactu,
                        onValueChange = { tallaactu = it },
                        modifier = Modifier,
                        textStyle = TextStyle(color = Color.Black),
                        label = { Text(text = "Talla actual") },
                        placeholder = { Text(text = "Ingrese la talla actual") },
                        leadingIcon = {
                            Icon(
                                imageVector = ImageVector.vectorResource(R.drawable.baseline_format_line_spacing_24),
                                contentDescription = ""
                            )
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                        singleLine = true,
                        maxLines = 1,
                        minLines = 1,
                        shape = RoundedCornerShape(20.dp)
                    )
                    Spacer(modifier = Modifier.padding(3.dp))
                    OutlinedTextField(
                        value = edad,
                        onValueChange = { edad = it },
                        modifier = Modifier,
                        textStyle = TextStyle(color = Color.Black),
                        label = { Text(text = "Edad") },
                        placeholder = { Text(text = "Edad en meses") },
                        leadingIcon = {
                            Icon(imageVector = Icons.Default.DateRange, contentDescription = "")
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                        singleLine = true,
                        maxLines = 1,
                        minLines = 1,
                        shape = RoundedCornerShape(20.dp)
                    )
                    Spacer(modifier = Modifier.padding(20.dp))
                    // Spacer(modifier = Modifier.padding(20.dp))
                    Button(
                        onClick = { graf = true},
                        modifier = Modifier
                            .fillMaxWidth(0.6f)
                            .height(48.dp),
                        colors = ButtonDefaults.buttonColors(
                            Color(0xFF95BDFF),
                            Color.White,
                            Color.Gray,
                            Color.White
                        )
                    )
                    {
                        Text(text = "Graficar")
                    }

                    Spacer(modifier = Modifier.padding(30.dp))
                    Spacer(modifier = Modifier.padding(20.dp))
                    Card(
                        modifier = Modifier
                            .padding(horizontal = 8.dp, vertical = 8.dp)
                            .fillMaxWidth(0.9f),
                        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White,
                        ),
                        shape = RoundedCornerShape(corner = CornerSize(16.dp))

                    ) {
                        Text(text = "Esta aplicación se basa en las tablas de crecimiento de bebés de la OMS y te ayuda a hacer un seguimiento de la evolución de tu bebé",
                            modifier = Modifier.padding(8.dp),
                            fontSize = 15.sp)
                    }
                    Spacer(modifier = Modifier.padding(5.dp))
                    Text(
                        text = "Crecimiento / Peso",
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        modifier = Modifier.padding(10.dp)
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Card(
                            modifier = Modifier
                                .padding(horizontal = 8.dp, vertical = 8.dp)
                                .size(150.dp),
                            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color.White,
                            ),
                            shape = RoundedCornerShape(corner = CornerSize(16.dp))

                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(text = "Al nacer")
                                Divider(
                                    color = Color(0xFF424242),
                                    modifier = Modifier
                                        .height(1.dp)
                                        .fillMaxWidth(0.9f)
                                )
//                       Text(text = "$peson kg")
                            }
                        }
                        Card(
                            modifier = Modifier
                                .padding(horizontal = 8.dp, vertical = 8.dp)
                                .size(150.dp),
                            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color.White,
                            ),
                            shape = RoundedCornerShape(corner = CornerSize(16.dp))

                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(text = "Actual")
                                Divider(
                                    color = Color(0xFF424242),
                                    modifier = Modifier
                                        .height(1.dp)
                                        .fillMaxWidth(0.9f)
                                )
//                        Text(text = "$pesoactu kg")
                            }
                        }
                        Card(
                            modifier = Modifier
                                .padding(horizontal = 8.dp, vertical = 8.dp)
                                .size(200.dp),
                            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color.White,
                            ),
                            shape = RoundedCornerShape(corner = CornerSize(16.dp))

                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(text = "Diferencia")
                                Divider(
                                    color = Color(0xFF424242),
                                    modifier = Modifier
                                        .height(1.dp)
                                        .fillMaxWidth(0.9f)
                                )
//                        Text(text = "$difpeso kg")
                            }
                        }
                    }

                    Spacer(modifier = Modifier.padding(10.dp))
                    Column() {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(0.9f)
                                .height(40.dp),
                            verticalAlignment = Alignment.CenterVertically
                        )
                        {
                            Text(
                                text = "Edad / Peso",
                                fontSize = 20.sp,
                                color = Color(0xFF424242),
                            )
                        }
                        Divider(
                            color = Color(0xFF424242),
                            modifier = Modifier
                                .height(1.dp)
                                .fillMaxWidth(0.9f)
                        )
                    }
                    gra_peso_boy()
                    Spacer(modifier = Modifier.padding(20.dp))
                    Column() {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(0.9f)
                                .height(40.dp),
                            verticalAlignment = Alignment.CenterVertically
                        )
                        {
                            Text(
                                text = "Edad / talla",
                                fontSize = 20.sp,
                                color = Color(0xFF424242),
                            )
                        }
                        Divider(
                            color = Color(0xFF424242),
                            modifier = Modifier
                                .height(1.dp)
                                .fillMaxWidth(0.9f)
                        )
                    }
                    gra_peso_girl()
                    Spacer(modifier = Modifier.padding(30.dp))
                }

            }
        }

    }
}


@Composable
fun gra_peso_boy() {
    val steps = 5
    val pointsData = listOf(
        Point(0f, 3.4f),
        Point(3f, 6.2f),
        Point(6f, 8f),
        Point(9f, 9.2f),
        Point(12f, 10.2f)
    )
    val pointsData2 = listOf(
        Point(2.4f, 8.2f),
    )

    val xAxisData = AxisData.Builder()
        .axisStepSize(30.dp)
        .backgroundColor(Color.Transparent)
        .steps(pointsData.size - 1)
        .labelData { i -> i.toString() }
        .labelAndAxisLinePadding(15.dp)
        .axisLineColor(MaterialTheme.colorScheme.tertiary)
        .axisLabelColor(MaterialTheme.colorScheme.tertiary)
        .build()

    val yAxisData = AxisData.Builder()
        .steps(steps)
        .backgroundColor(Color.Transparent)
        .labelAndAxisLinePadding(20.dp)
        .labelData { i ->
            val yScale = 10 / steps
            (i * yScale).toString()
        }
        .axisLineColor(MaterialTheme.colorScheme.tertiary)
        .axisLabelColor(MaterialTheme.colorScheme.tertiary)
        .build()

    val lineChartData = LineChartData(
        linePlotData = LinePlotData(
            lines = listOf(
                Line(
                    dataPoints = pointsData,
                    LineStyle(
                        color = MaterialTheme.colorScheme.tertiary,
                        lineType = LineType.Straight(isDotted = false)
                    ),
                    IntersectionPoint(
                        color = MaterialTheme.colorScheme.tertiary
                    ),
                    SelectionHighlightPoint(color = MaterialTheme.colorScheme.primary),
                    ShadowUnderLine(
                        alpha = 0.5f,
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                MaterialTheme.colorScheme.inversePrimary,
                                Color.Transparent
                            )
                        )
                    ),
                    SelectionHighlightPopUp()
                ),
                Line(
                    dataPoints = pointsData2,
                    LineStyle(
                        color = MaterialTheme.colorScheme.tertiary,
                        lineType = LineType.Straight(isDotted = false)
                    ),
                    IntersectionPoint(
                        color = MaterialTheme.colorScheme.tertiary
                    ),
                    SelectionHighlightPoint(color = MaterialTheme.colorScheme.primary),
                    ShadowUnderLine(
                        alpha = 0.5f,
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                MaterialTheme.colorScheme.inversePrimary,
                                Color.Transparent
                            )
                        )
                    ),
                    SelectionHighlightPopUp()
                )
            ),
        ),
        backgroundColor = MaterialTheme.colorScheme.surface,
        xAxisData = xAxisData,
        yAxisData = yAxisData,
        gridLines = GridLines(color = MaterialTheme.colorScheme.outlineVariant)
    )
    LineChart(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp), lineChartData = lineChartData
    )

}

@Composable
fun gra_peso_girl() {
    val steps = 5
    val pointsData = listOf(
        Point(0f, 3f),
        Point(3f, 6f),
        Point(6f, 7.2f),
        Point(9f, 8.2f),
        Point(12f, 9f)
    )
    val pointsData2 = listOf(
        Point(3.6f, 5.2f),
    )

    val xAxisData = AxisData.Builder()
        .axisStepSize(30.dp)
        .backgroundColor(Color.Transparent)
        .steps(pointsData.size - 1)
        .labelData { i -> i.toString() }
        .labelAndAxisLinePadding(15.dp)
        .axisLineColor(MaterialTheme.colorScheme.tertiary)
        .axisLabelColor(MaterialTheme.colorScheme.tertiary)
        .build()

    val yAxisData = AxisData.Builder()
        .steps(steps)
        .backgroundColor(Color.Transparent)
        .labelAndAxisLinePadding(20.dp)
        .labelData { i ->
            val yScale = 10 / steps
            (i * yScale).toString()
        }
        .axisLineColor(MaterialTheme.colorScheme.tertiary)
        .axisLabelColor(MaterialTheme.colorScheme.tertiary)
        .build()

    val lineChartData = LineChartData(
        linePlotData = LinePlotData(
            lines = listOf(
                Line(
                    dataPoints = pointsData,
                    LineStyle(
                        color = MaterialTheme.colorScheme.tertiary,
                        lineType = LineType.Straight(isDotted = false)
                    ),
                    IntersectionPoint(
                        color = MaterialTheme.colorScheme.tertiary
                    ),
                    SelectionHighlightPoint(color = MaterialTheme.colorScheme.primary),
                    ShadowUnderLine(
                        alpha = 0.5f,
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                MaterialTheme.colorScheme.inversePrimary,
                                Color.Transparent
                            )
                        )
                    ),
                    SelectionHighlightPopUp()
                ),
                Line(
                    dataPoints = pointsData2,
                    LineStyle(
                        color = MaterialTheme.colorScheme.tertiary,
                        lineType = LineType.Straight(isDotted = false)
                    ),
                    IntersectionPoint(
                        color = MaterialTheme.colorScheme.tertiary
                    ),
                    SelectionHighlightPoint(color = MaterialTheme.colorScheme.primary),
                    ShadowUnderLine(
                        alpha = 0.5f,
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                MaterialTheme.colorScheme.inversePrimary,
                                Color.Transparent
                            )
                        )
                    ),
                    SelectionHighlightPopUp()
                )
            ),
        ),
        backgroundColor = MaterialTheme.colorScheme.surface,
        xAxisData = xAxisData,
        yAxisData = yAxisData,
        gridLines = GridLines(color = MaterialTheme.colorScheme.outlineVariant)
    )
    LineChart(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp), lineChartData = lineChartData
    )

}