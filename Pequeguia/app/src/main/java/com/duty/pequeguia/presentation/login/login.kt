package com.duty.pequeguia.presentation.login

import android.app.AlertDialog
import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.duty.pequeguia.R
import com.duty.pequeguia.presentation.registro.mostrar_dialog_bad
import com.google.firebase.auth.FirebaseAuth

@Composable
fun Login(auth: FirebaseAuth, navToRegistro: () -> Unit, navToHome: () -> Unit) {

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.newfondo),
            contentDescription = "Fondo",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
        Box(modifier = Modifier.matchParentSize()) {
            Contenido(Modifier.align(Alignment.Center), navToRegistro, auth, navToHome)
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.padding(90.dp))
                Imagen_user()
            }

        }

    }

}

@Composable
fun Contenido(
    modifier: Modifier,
    navToRegistro: () -> Unit,
    auth: FirebaseAuth,
    navToHome: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.padding(40.dp))
        Text(
            text = stringResource(R.string.Login_tittle),
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp
        )
        Text(
            text = stringResource(R.string.Login_subtittle),
            fontSize = 15.sp
        )
        Spacer(modifier = Modifier.padding(40.dp))

        //Parte blanca
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White.copy(alpha = 0.7f))
                .blur(30.dp)


        )
        {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.padding(40.dp))
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    modifier = Modifier,
                    textStyle = TextStyle(color = Color.Black),
                    label = { Text(text = "Correo") },
                    placeholder = { Text(text = "Ingrese su correo") },
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Email, contentDescription = "")
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    singleLine = true,
                    maxLines = 1,
                    minLines = 1,
                    shape = RoundedCornerShape(20.dp)
                )
                Spacer(modifier = Modifier.padding(5.dp))
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    modifier = Modifier,
                    textStyle = TextStyle(color = Color.Black),
                    label = { Text(text = "Contraseña") },
                    placeholder = { Text(text = "Ingrese su contraseña") },
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Lock, contentDescription = "")
                    },
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    singleLine = true,
                    maxLines = 1,
                    minLines = 1,
                    shape = RoundedCornerShape(20.dp)
                )
                Spacer(modifier = Modifier.padding(20.dp))
                button_login(email, password, auth,navToHome, context)
                Spacer(modifier = Modifier.padding(10.dp))
                no_cuenta(navToRegistro)
            }
        }
    }
}

@Composable
fun Imagen_user() {
    Image(
        painter = painterResource(id = R.drawable.foto_user),
        contentDescription = "foto de perfil",
        modifier = Modifier.size(120.dp)
    )
}

@Composable
fun emailfield(email: String) {
    OutlinedTextField(
        value = email,
        onValueChange = {},
        modifier = Modifier,
        textStyle = TextStyle(color = Color.Cyan),
        label = { Text(text = "Correo") },
        placeholder = { Text(text = "Ingrese su correo") },
        leadingIcon = {
            Icon(imageVector = Icons.Default.Email, contentDescription = "")
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        maxLines = 1,
        minLines = 1,
        shape = RoundedCornerShape(20.dp)
    )
}

@Composable
fun passwordfield(password: String) {
    OutlinedTextField(
        value = password,
        onValueChange = {},
        modifier = Modifier,
        textStyle = TextStyle(color = Color.Cyan),
        label = { Text(text = "Contraseña") },
        placeholder = { Text(text = "Ingrese su contraseña") },
        leadingIcon = {
            Icon(imageVector = Icons.Default.Lock, contentDescription = "")
        },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        maxLines = 1,
        minLines = 1,
        shape = RoundedCornerShape(20.dp)
    )

}

@Composable
fun button_login(
    email: String,
    password: String,
    auth: FirebaseAuth,
    navToHome: () -> Unit,
    context: Context
) {
    Button(
        onClick = { ini_ses(email, password, auth, navToHome, context) },
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
        Text(text = stringResource(R.string.login))
    }
}

@Composable
fun no_cuenta(navToRegistro: () -> Unit) {
    Row(modifier = Modifier.clickable { navToRegistro() }) {
        Text(
            text = stringResource(R.string.no_cuenta),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.padding(2.dp))
        Text(
            text = stringResource(R.string.no_cuenta2),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xff4379F2),
            textDecoration = TextDecoration.Underline
        )
    }
}

fun ini_ses(
    email: String,
    password: String,
    auth: FirebaseAuth,
    navToHome: () -> Unit,
    context: Context
) {

    if (password.length < 6 || email.isNullOrEmpty() || password.isNullOrEmpty() ){
        mostrar_dialogin_bad(context)
    }
    else {
        auth.signInWithEmailAndPassword(email, password).addOnFailureListener {
            mostrar_dialog_bad(context)
        }.addOnSuccessListener {
            mostrar_dialogin_gud(context, navToHome)
        }

    }
}



fun mostrar_dialogin_bad(context: Context) {
    val builder: AlertDialog.Builder = AlertDialog.Builder(context)
    builder
        .setIcon(R.drawable.cancel)
        .setMessage("Correo o contraseña incorrectos")
        .setTitle("Error")

    val dialog: AlertDialog = builder.create()
    dialog.show()
}

fun mostrar_dialogin_gud(context: Context, navToHome: () -> Unit) {
    val builder: AlertDialog.Builder = AlertDialog.Builder(context)
    builder
        .setIcon(R.drawable.correct)
        .setMessage("será redirigido al home")
        .setTitle("Login exitoso")
        .setPositiveButton("Entendido") { dialog, which ->
            navToHome()
        }

    val dialog: AlertDialog = builder.create()
    dialog.show()
    navToHome()
}