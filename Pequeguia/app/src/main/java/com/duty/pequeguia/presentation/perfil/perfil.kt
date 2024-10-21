package com.duty.pequeguia.presentation.perfil

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.duty.pequeguia.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@Composable
fun perfil(navToLogin: () -> Unit, navextra: () -> Unit) {

//    Box(modifier = Modifier.fillMaxSize()) {
//        Image(
//            painter = painterResource(id = R.drawable.newfondo),
//            contentDescription = "Fondo",
//            contentScale = ContentScale.FillBounds,
//            modifier = Modifier.matchParentSize()
//        )
//    }

    perf(navToLogin, navextra)

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SmallTopAppBar() {

    TopAppBar(
        modifier = Modifier.height(50.dp),
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.White.copy(alpha = 0.3f),
            titleContentColor = Color.Black
        ),
        title = { Text("") },
        navigationIcon = {
            Icon(imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = "")
        }
    )


}


@Composable
fun perf(navToLogin: () -> Unit, navextra: () -> Unit) {

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
            SmallTopAppBar()
            Spacer(modifier = Modifier.padding(20.dp))
            Text(
                text = "Perfil",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )
            Text(
                text = "Información General",
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
                        .verticalScroll(scroll),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.padding(5.dp))
                    namemama(navToLogin, navextra)
                }

            }
        }
    }

}

@Composable
fun namemama(navToLogin: () -> Unit, navextra: () -> Unit) {
    val auth:FirebaseAuth = Firebase.auth
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
//        Column() {
//            Spacer(modifier = Modifier.padding(10.dp))
//            Text(text = "Nombre")
//            OutlinedTextField(
//                value = "",
//                enabled = false,
//                onValueChange = { },
//                modifier = Modifier,
//                textStyle = TextStyle(color = Color.Black),
//                label = { Text(text = "") },
//                placeholder = { Text(text = "") },
//                leadingIcon = {
//                    Icon(imageVector = Icons.Default.Face, contentDescription = "")
//                },
//                //keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
//                shape = RoundedCornerShape(20.dp)
//            )
//        }
        Column() {
            Text(text = "Usuario o Correo:")
            OutlinedTextField(
                value = "",
                enabled = false,
                onValueChange = { },
                modifier = Modifier,
                textStyle = TextStyle(color = Color.Black),
                label = { Text(text = auth.currentUser?.email.toString()) },
                placeholder = { Text(text = "") },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Email, contentDescription = "")
                },
                //keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                shape = RoundedCornerShape(20.dp)
            )
        }
        Spacer(modifier = Modifier.padding(50.dp))
        Button(
            onClick = { navToLogin() },
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
            Text(text = "Cerrar sesión")
        }
        Spacer(modifier = Modifier.padding(20.dp))
//        Button(
//            onClick = { navextra() },
//            modifier = Modifier
//                .fillMaxWidth(0.6f)
//                .height(48.dp),
//            colors = ButtonDefaults.buttonColors(
//                Color(0xFF95BDFF),
//                Color.White,
//                Color.Gray,
//                Color.White
//            )
//        )
//        {
//            Text(text = "ir a graficas ")
//        }
//        Column() {
//            Spacer(modifier = Modifier.padding(10.dp))
//            Text(text = "Número de niños registrados:")
//            Spacer(modifier = Modifier.padding(2.dp))
//            Text(text = "Niños registrados:")
//            OutlinedTextField(
//                value = "",
//                enabled = false,
//                onValueChange = { },
//                modifier = Modifier,
//                textStyle = TextStyle(color = Color.Black),
//                label = { Text(text = "") },
//                placeholder = { Text(text = "") },
//                leadingIcon = {
//                //    Icon(imageVector = Icons.Default.Email, contentDescription = "")
//                },
//                //keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
//                shape = RoundedCornerShape(20.dp)
//            )
//        }
    }
    //Text(
    //   text = ("Nombre"),
    //    fontSize = 12.sp,
    //    fontWeight = FontWeight.Bold,
    //    color = Color.Gray
    //)
    //Spacer(modifier = Modifier.padding(2.dp))

    //Spacer(modifier = Modifier.padding(40.dp))
    //OutlinedTextField(
    //    value = "",
    //    enabled = false,
    //    onValueChange = { },
    //    modifier = Modifier,
    //    textStyle = TextStyle(color = Color.Black),
    //    label = { Text(text = "") },
    //    placeholder = { Text(text = "") },
    //    leadingIcon = {
    //        Icon(imageVector = Icons.Default.Face, contentDescription = "")
    //    },
    //    //keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
    //    shape = RoundedCornerShape(20.dp)
    //)

}
