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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.duty.pequeguia.R

@Composable
fun vacunas() {
    var scroll = rememberScrollState()
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
            Spacer(modifier = Modifier.padding(30.dp))
            Text(
                text = "Guía de Vacunas",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )

            Box(modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.vacunasddd),
                    contentDescription = "foto de perfil",
                    modifier = Modifier.matchParentSize()
                )
            }

            Spacer(modifier = Modifier.padding(10.dp))

            //Parte blanca
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White.copy(alpha = 0.5f))
                    .blur(20.dp)

            )
            {
                Column(modifier = Modifier.verticalScroll(rememberScrollState()).matchParentSize().fillMaxWidth(0.8f), horizontalAlignment = Alignment.CenterHorizontally ) {
                    Text(text = "¿Alguna vez te has preguntado por qué los bebés reciben vacunas desde el día en que nacen?", modifier = Modifier.padding(10.dp))

                    Spacer(modifier = Modifier.padding(10.dp))

                    Text(text = "La vacunación infantil es esencial porque ayuda a proporcionar inmunidad antes de que los niños",modifier = Modifier.padding(10.dp))
                    Text(text = "estén expuestos a enfermedades potencialmente mortales.",modifier = Modifier.padding(10.dp))

                    Spacer(modifier = Modifier.padding(10.dp))

                    Text(text = "De todos los grupos de edad, los bebés son hospitalizados con más frecuencia y a veces mueren por enfermedades que podemos prevenir con vacunas.",modifier = Modifier.padding(10.dp))
                    Text(text = "",modifier = Modifier.padding(10.dp))

                    Spacer(modifier = Modifier.padding(10.dp))

                    Text(text = "Es por eso que la mayoría de las vacunas infantiles están recomendadas para los primeros 12 a 18 meses de vida del bebé.",modifier = Modifier.padding(10.dp))
                    Text(text = "",modifier = Modifier.padding(10.dp))

                    Spacer(modifier = Modifier.padding(20.dp))

                    Text(text = "Importante: Esta aplicación solo ofrece una guía de referencia para monitorear el crecimiento de tu bebé, no ofrece información exhaustiva ni asesoramiento médico. Para un correcto seguimiento del crecimiento de tu bebé, acude con tu bebé al control mensual con un médico profesional.",modifier = Modifier.padding(10.dp))
                    Text(text = "",modifier = Modifier.padding(10.dp))
                    Text(text = "",modifier = Modifier.padding(10.dp))
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)) {
                        Image(
                            painter = painterResource(id = R.drawable.vacunas),
                            contentDescription = "foto de perfil",
                            modifier = Modifier.matchParentSize()
                        )
                    }
                    Spacer(modifier = Modifier.padding(30.dp))
                }
            }
        }
    }
}