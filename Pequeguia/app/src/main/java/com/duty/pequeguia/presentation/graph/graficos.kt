package com.duty.pequeguia.presentation.graph

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.duty.pequeguia.data.Dato
import com.github.tehras.charts.line.LineChart
import com.github.tehras.charts.line.LineChartData
import com.github.tehras.charts.line.renderer.line.SolidLineDrawer
import com.github.tehras.charts.line.renderer.point.FilledCircularPointDrawer

@Composable
fun graf() {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(){
            lineas_pesos()
            lineas_pesos_chistosa("s", 9, 5.3f)
        }

        lineas_tallas()

    }

}


@Composable
fun lineas_pesos_chistosa(sex:String, mes:Int, peso: Float) {

    if(true){
        //Tabla pesos niños

        when(mes){
            3 -> {
                val datos = listOf(
                    Dato("mes 0", 0f),
                    Dato("mes 3", peso),
                    Dato("mes 6", 0f),
                    Dato("mes 9", 0f),
                    Dato("mes 12", 0f),
                )
                var puntos = ArrayList<LineChartData.Point>()
                datos.mapIndexed { index, dato ->
                    puntos.add(
                        LineChartData.Point(
                            value = dato.value,
                            label = dato.label
                        )
                    )
                }
                var lines = ArrayList<LineChartData>()
                lines.add(
                    LineChartData(
                        points = puntos,
                        lineDrawer = SolidLineDrawer(color = Color.Transparent)
                    )
                )
                LineChart(
                    linesChartData = lines,
                    modifier = Modifier
                        .padding(horizontal = 30.dp, vertical = 80.dp)
                        .height(300.dp),
                    labels = listOf("mes 0", "mes 3", "mes 6", "mes 9", "mes 12"),
                    yAxisDrawer = com.github.tehras.charts.line.renderer.yaxis.SimpleYAxisDrawer(labelTextColor = Color.Transparent),
                    pointDrawer = FilledCircularPointDrawer(color = Color.Red, diameter = 10.dp)
                )
            }
            6 -> {
                val datos = listOf(
                    Dato("mes 0", 0f),
                    Dato("mes 3", 0f),
                    Dato("mes 6", peso),
                    Dato("mes 9", 0f),
                    Dato("mes 12", 0f),
                )
                var puntos = ArrayList<LineChartData.Point>()
                datos.mapIndexed { index, dato ->
                    puntos.add(
                        LineChartData.Point(
                            value = dato.value,
                            label = dato.label
                        )
                    )
                }
                var lines = ArrayList<LineChartData>()
                lines.add(
                    LineChartData(
                        points = puntos,
                        lineDrawer = SolidLineDrawer(color = Color.Transparent)
                    )
                )
                LineChart(
                    linesChartData = lines,
                    modifier = Modifier
                        .padding(horizontal = 30.dp, vertical = 80.dp)
                        .height(300.dp),
                    labels = listOf("mes 0", "mes 3", "mes 6", "mes 9", "mes 12"),
                    yAxisDrawer = com.github.tehras.charts.line.renderer.yaxis.SimpleYAxisDrawer(labelTextColor = Color.Transparent),
                    pointDrawer = FilledCircularPointDrawer(color = Color.Red, diameter = 10.dp)
                )
            }
            9 -> {
                val datos = listOf(
                    Dato("mes 0", 0f),
                    Dato("mes 9", 0f),
                    Dato("mes 6", 0f),
                    Dato("mes 9", peso),
                    Dato("mes 12", 0f),
                )
                var puntos = ArrayList<LineChartData.Point>()
                datos.mapIndexed { index, dato ->
                    puntos.add(
                        LineChartData.Point(
                            value = dato.value,
                            label = dato.label
                        )
                    )
                }
                var lines = ArrayList<LineChartData>()
                lines.add(
                    LineChartData(
                        points = puntos,
                        lineDrawer = SolidLineDrawer(color = Color.Transparent)
                    )
                )
                LineChart(
                    linesChartData = lines,
                    modifier = Modifier
                        .padding(horizontal = 30.dp, vertical = 80.dp)
                        .height(300.dp),
                    labels = listOf("mes 0", "mes 3", "mes 6", "mes 9", "mes 12"),
                    yAxisDrawer = com.github.tehras.charts.line.renderer.yaxis.SimpleYAxisDrawer(labelTextColor = Color.Transparent),
                    pointDrawer = FilledCircularPointDrawer(color = Color.Red, diameter = 10.dp)
                )
            }
            12 -> {
                val datos = listOf(
                    Dato("mes 0", 0f),
                    Dato("mes 9", 0f),
                    Dato("mes 6", 0f),
                    Dato("mes 9", 0f),
                    Dato("mes 12", peso),
                )
                var puntos = ArrayList<LineChartData.Point>()
                datos.mapIndexed { index, dato ->
                    puntos.add(
                        LineChartData.Point(
                            value = dato.value,
                            label = dato.label
                        )
                    )
                }
                var lines = ArrayList<LineChartData>()
                lines.add(
                    LineChartData(
                        points = puntos,
                        lineDrawer = SolidLineDrawer(color = Color.Transparent)
                    )
                )
                LineChart(
                    linesChartData = lines,
                    modifier = Modifier
                        .padding(horizontal = 30.dp, vertical = 80.dp)
                        .height(300.dp),
                    labels = listOf("mes 0", "mes 3", "mes 6", "mes 9", "mes 12"),
                    yAxisDrawer = com.github.tehras.charts.line.renderer.yaxis.SimpleYAxisDrawer(labelTextColor = Color.Transparent),
                    pointDrawer = FilledCircularPointDrawer(color = Color.Red, diameter = 10.dp)
                )
            }

        }


    }
    else{
        //Tabla pesos niñas
        val datos: List<Dato> = listOf(
            Dato("mes 0", 3.4f),
            Dato("mes 3", 6.2f),
            Dato("mes 6", 8f),
            Dato("mes 9", 9.2f),
            Dato("mes 12", 10.2f),
        )
        var puntos = ArrayList<LineChartData.Point>()
        datos.mapIndexed { index, dato ->
            puntos.add(
                LineChartData.Point(
                    value = dato.value,
                    label = dato.label
                )
            )
        }
        var lines = ArrayList<LineChartData>()
        lines.add(
            LineChartData(
                points = puntos,
                lineDrawer = SolidLineDrawer(color = Color.Red, thickness = 0.dp)
            )
        )
        LineChart(
            linesChartData = lines,
            modifier = Modifier
                .padding(horizontal = 30.dp, vertical = 80.dp)
                .height(300.dp),
            labels = listOf("mes 0", "mes 3", "mes 6", "mes 9", "mes 12"),
        )
    }

}


@Composable
fun lineas_pesos() {

    if(true){
        //Tabla pesos niños
        val datos: List<Dato> = listOf(
            Dato("mes 0", 3.4f),
            Dato("mes 3", 6.2f),
            Dato("mes 6", 8f),
            Dato("mes 9", 9.2f),
            Dato("mes 12", 10.2f),
        )
        var puntos = ArrayList<LineChartData.Point>()
        var punto = ArrayList<LineChartData.Point>()
        punto.add(
            LineChartData.Point(
                value = 9f,
                label = "3 meses"
            )
        )
        datos.mapIndexed { index, dato ->
            puntos.add(
                LineChartData.Point(
                    value = dato.value,
                    label = dato.label
                )
            )
        }
        var lines = ArrayList<LineChartData>()
        lines.add(
            LineChartData(
                points = puntos,
                lineDrawer = SolidLineDrawer()
            )
        )
        LineChart(
            linesChartData = lines,
            modifier = Modifier
                .padding(horizontal = 30.dp, vertical = 80.dp)
                .height(300.dp)
        )
    }
    else{
        //Tabla pesos niñas
        val datos: List<Dato> = listOf(
            Dato("mes 0", 3f),
            Dato("mes 3", 6f),
            Dato("mes 6", 7.2f),
            Dato("mes 9", 8.1f),
            Dato("mes 12", 9f),
        )
        var puntos = ArrayList<LineChartData.Point>()
        datos.mapIndexed { index, dato ->
            puntos.add(
                LineChartData.Point(
                    value = dato.value,
                    label = dato.label
                )
            )
        }
        var lines = ArrayList<LineChartData>()
        lines.add(
            LineChartData(
                points = puntos,
                lineDrawer = SolidLineDrawer()
            )
        )
        LineChart(
            linesChartData = lines,
            modifier = Modifier
                .padding(horizontal = 30.dp, vertical = 80.dp)
                .height(300.dp)
        )
    }

}


@Composable
fun lineas_tallas() {

    if(true){
        //Tabla tallas niños
        val datos: List<Dato> = listOf(
            Dato("mes 0", 50f),
            Dato("mes 3", 61f),
            Dato("mes 6", 67f),
            Dato("mes 9", 73f),
            Dato("mes 12", 76f),
        )
        var puntos = ArrayList<LineChartData.Point>()
        datos.mapIndexed { index, dato ->
            puntos.add(
                LineChartData.Point(
                    value = dato.value,
                    label = dato.label
                )
            )
        }
        var lines = ArrayList<LineChartData>()
        lines.add(
            LineChartData(
                points = puntos,
                lineDrawer = SolidLineDrawer()
            )
        )
        LineChart(
            linesChartData = lines,
            modifier = Modifier
                .padding(horizontal = 30.dp, vertical = 80.dp)
                .height(300.dp)
        )
    }
    else{
        //Tabla pesos niñas
        val datos: List<Dato> = listOf(
            Dato("mes 0", 49f),
            Dato("mes 3", 60f),
            Dato("mes 6", 66f),
            Dato("mes 9", 70f),
            Dato("mes 12", 74f),
        )
        var puntos = ArrayList<LineChartData.Point>()
        datos.mapIndexed { index, dato ->
            puntos.add(
                LineChartData.Point(
                    value = dato.value,
                    label = dato.label
                )
            )
        }
        var lines = ArrayList<LineChartData>()
        lines.add(
            LineChartData(
                points = puntos,
                lineDrawer = SolidLineDrawer()
            )
        )
        LineChart(
            linesChartData = lines,
            modifier = Modifier
                .padding(horizontal = 30.dp, vertical = 80.dp)
                .height(300.dp)
        )
    }

}

