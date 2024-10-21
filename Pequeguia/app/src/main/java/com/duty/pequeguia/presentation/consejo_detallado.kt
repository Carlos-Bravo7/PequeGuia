package com.duty.pequeguia.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.duty.pequeguia.data.Consejo

@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun consejo_detallado(consejo: Consejo){
    val scrollState = rememberScrollState()
    Column(modifier = Modifier.fillMaxSize()) {
        BoxWithConstraints {
            Surface() {
                Column(modifier = Modifier.fillMaxSize().
                verticalScroll(scrollState)
                )
                {
                    ConsejoHeader(consejo = consejo, containerHeight = this@BoxWithConstraints.maxHeight)
                    ConsejoContent(consejo = consejo, containerHeight = this@BoxWithConstraints.maxHeight)
                }
            }
        }
    }
}

@Composable
private fun ConsejoHeader(
    consejo: Consejo,
    containerHeight: Dp
){
    Image(
        modifier = Modifier.heightIn(max = containerHeight/2)
            .fillMaxWidth(),
        painter = painterResource(id = consejo.image),
        contentScale = ContentScale.Crop,
        contentDescription = ""
    )
}

@Composable
private fun ConsejoContent(consejo: Consejo, containerHeight: Dp){
    tittle(consejo)
    text(consejo)
}

@Composable
private fun tittle(consejo: Consejo){
    Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = consejo.tittle,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun text(consejo: Consejo){
    Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = consejo.content,
            fontSize = 15.sp
        )
    }
}