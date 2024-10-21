package com.duty.pequeguia.presentation.registro

import android.app.AlertDialog
import android.content.Context
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
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
import androidx.compose.ui.window.Dialog
import com.duty.pequeguia.R
import com.duty.pequeguia.data.Kid
import com.duty.pequeguia.data.Usuario
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


@Composable
fun Registro(
    db: FirebaseFirestore,
    auth: FirebaseAuth,
    navToLogin: () -> Unit,
    navToHome: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.newfondo),
            contentDescription = "Fondo",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
            Contenido(Modifier.align(Alignment.Center), navToLogin, auth, db, navToHome)
    }

}

@Composable
fun Contenido(
    modifier: Modifier,
    navToLogin: () -> Unit,
    auth: FirebaseAuth,
    db: FirebaseFirestore,
    navToHome: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var confi_password by remember { mutableStateOf("") }

    val context = LocalContext.current

    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally){
        Spacer(modifier = Modifier.padding(30.dp))
        Text(
            text = stringResource(R.string.registro_tittle),
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp
        )
        Text(
            text = stringResource(R.string.registro_subtittle),
            fontSize = 15.sp
        )
        Spacer(modifier = Modifier.padding(20.dp))

        //Parte blanca
        Box(
            modifier = Modifier.fillMaxSize().
            background(Color.White.copy(alpha = 0.7f)).
            blur(30.dp)


        )
        {
            Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(modifier = Modifier.padding(5.dp))
                OutlinedTextField(
                    value = name,
                    onValueChange = {name = it},
                    modifier = Modifier,
                    textStyle = TextStyle(color = Color.Black),
                    label = { Text(text = "Nombre") },
                    placeholder = { Text(text = "Ingrese su nombre") },
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Person, contentDescription = "")
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    singleLine = true,
                    maxLines = 1,
                    minLines = 1,
                    shape = RoundedCornerShape(20.dp)
                )
                Spacer(modifier = Modifier.padding(5.dp))
                OutlinedTextField(
                    value = email,
                    onValueChange = {email = it},
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
                    onValueChange = {password = it},
                    modifier = Modifier,
                    textStyle = TextStyle(color = Color.Black),
                    label = { Text(text = "Contraseña") },
                    placeholder = { Text(text = "Ingrese su contraseña") },
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Lock, contentDescription = "")
                    },
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    singleLine = true,
                    maxLines = 1,
                    minLines = 1,
                    shape = RoundedCornerShape(20.dp)
                )
                Spacer(modifier = Modifier.padding(5.dp))
                OutlinedTextField(
                    value = confi_password,
                    onValueChange = {confi_password = it},
                    modifier = Modifier,
                    textStyle = TextStyle(color = Color.Black),
                    label = { Text(text = "Confirmar contraseña") },
                    placeholder = { Text(text = "Confirme su contraseña") },
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Lock, contentDescription = "")
                    },
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    singleLine = true,
                    maxLines = 1,
                    minLines = 1,
                    shape = RoundedCornerShape(20.dp)
                )

                Spacer(modifier = Modifier.padding(20.dp))
                button_login(email, password, name, auth, confi_password, db, context, navToHome)
                Spacer(modifier = Modifier.padding(10.dp))
                si_cuenta(navToLogin)
            }
        }
    }
}

@Composable
fun emailfield(){
    OutlinedTextField(
        value = "",
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
fun namefield(){
    OutlinedTextField(
        value = "",
        onValueChange = {},
        modifier = Modifier,
        textStyle = TextStyle(color = Color.Cyan),
        label = { Text(text = "Nombre") },
        placeholder = { Text(text = "Ingrese su nombre") },
        leadingIcon = {
            Icon(imageVector = Icons.Default.Person, contentDescription = "")
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,
        minLines = 1,
        shape = RoundedCornerShape(20.dp)
    )
}

@Composable
fun passwordfield(){
    OutlinedTextField(
        value = "",
        onValueChange = {},
        modifier = Modifier,
        textStyle = TextStyle(color = Color.Cyan),
        label = { Text(text = "Contraseña") },
        placeholder = { Text(text = "Ingrese su contraseña") },
        leadingIcon = {
            Icon(imageVector = Icons.Default.Lock, contentDescription = "")
        },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
        maxLines = 1,
        minLines = 1,
        shape = RoundedCornerShape(20.dp)
    )

}

@Composable
fun confirmpasswordfield(){
    OutlinedTextField(
        value = "",
        onValueChange = {},
        modifier = Modifier,
        textStyle = TextStyle(color = Color.Cyan),
        label = { Text(text = "Confirmar contraseña") },
        placeholder = { Text(text = "Confirme su contraseña") },
        leadingIcon = {
            Icon(imageVector = Icons.Default.Lock, contentDescription = "")
        },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
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
    name: String,
    auth: FirebaseAuth,
    confi_password: String,
    db: FirebaseFirestore,
    context: Context,
    navToHome: () -> Unit
) {
    var show by rememberSaveable { mutableStateOf(false) }


    Button(
        onClick = { show = full_registro(email, password, name, auth, confi_password, db, context, navToHome) },
        modifier = Modifier.fillMaxWidth(0.6f).
        height(48.dp),
        colors = ButtonDefaults.buttonColors(Color(0xFF95BDFF),Color.White, Color.Gray, Color.White)
    )
    {
        Text(text = stringResource(R.string.registro))

        if (show == true) {
            auth.signInWithEmailAndPassword(email, password)
        }

    }
}

@Composable
fun si_cuenta(navToLogin: () -> Unit) {
    Row(modifier = Modifier.clickable { navToLogin() },) {
        Text(
            text = stringResource(R.string.si_cuenta),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.padding(2.dp))
        Text(
            text = stringResource(R.string.si_cuenta2),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xff4379F2),
            textDecoration = TextDecoration.Underline
        )
    }
}

fun full_registro(
    email: String,
    password: String,
    name: String,
    auth: FirebaseAuth,
    confi_password: String,
    db: FirebaseFirestore,
    context: Context,
    navToHome: () -> Unit
):Boolean {
    if (confi_password != password || password.length < 6 || name.isNullOrEmpty() || email.isNullOrEmpty() ){
        mostrar_dialog_bad(context)
        return false

    }
    else {
        val user = Usuario(email, name,password,"", emptyList<Kid>())

        db.collection("users").document(email).set(user)

        auth.createUserWithEmailAndPassword(email, password)

        mostrar_dialog_gud(context, navToHome)

        return true
    }
}


fun mostrar_dialog_bad(context: Context) {
    val builder: AlertDialog.Builder = AlertDialog.Builder(context)
    builder
        .setIcon(R.drawable.cancel)
        .setMessage("Por favor, verifique información")
        .setTitle("Error")

    val dialog: AlertDialog = builder.create()
    dialog.show()
}

fun mostrar_dialog_gud(context: Context, navToHome: () -> Unit) {
    val builder: AlertDialog.Builder = AlertDialog.Builder(context)
    builder
        .setIcon(R.drawable.correct)
        .setMessage("será redirigido al home")
        .setTitle("Registro exitoso")
        .setPositiveButton("Entendido") { dialog, which ->
            navToHome()
        }

    val dialog: AlertDialog = builder.create()
    dialog.show()
}

@Composable
fun dialogmal(show:Boolean, onDismiss:() -> Unit){
    if (show){
        Dialog(onDismissRequest = { onDismiss() }) {
            // Draw a rectangle shape with rounded corners inside the dialog
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(375.dp)
                    .padding(16.dp),
                shape = RoundedCornerShape(16.dp),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.cancel),
                        contentDescription = "imageDescription",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .height(140.dp)
                    )
                    Text(
                        text = "Error, verifique información",
                        modifier = Modifier.padding(16.dp),
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        Button(
                            onClick = { onDismiss() },
                            modifier = Modifier.padding(8.dp),
                            colors = ButtonDefaults.buttonColors(
                                Color(0xFFF95454),
                                Color(0xFF54473F),
                                Color(0xFFF95454),
                                Color(0xFF54473F)

                            )
                        )
                        {
                            Text("Entendido", fontSize = 15.sp)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun dialogbien(show:Boolean, onDismiss:() -> Unit){
    if (show){
        Dialog(onDismissRequest = { }) {
            // Draw a rectangle shape with rounded corners inside the dialog
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(375.dp)
                    .padding(16.dp),
                shape = RoundedCornerShape(16.dp),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.correct),
                        contentDescription = "imageDescription",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .height(140.dp)
                    )
                    Text(
                        text = "Se ha registrado exitosamente",
                        modifier = Modifier.padding(16.dp),
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                    ) {
//                        TextButton(
//                            onClick = { onDismiss() },
//                            modifier = Modifier.padding(8.dp),
//                        ) {
//                            Text("Confirm", fontSize = 30.sp, color = Color(0xFF54473F))
//                        }
                        Button(
                            onClick = { onDismiss() },
                            modifier = Modifier.padding(8.dp),
                            colors = ButtonDefaults.buttonColors(
                                Color(0xFF88C273),
                                Color(0xFF54473F),
                                Color(0xFF88C273),
                                Color(0xFF54473F)

                            )
                        )
                        {
                            Text("Entendido", fontSize = 15.sp)
                        }
                    }
                }
            }
        }
    }
}