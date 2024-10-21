package com.duty.pequeguia.presentation.home

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.duty.pequeguia.R
import com.duty.pequeguia.data.Consejo
import com.duty.pequeguia.data.DataProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun home(
    navigateToFull: (Consejo) -> Unit,
    auth: FirebaseAuth,
    db: FirebaseFirestore,
    navToguia: () -> Unit,
    navToVacu: () -> Unit,
    navextra: () -> Unit
) {


    Scaffold(
        topBar = { /**TopBar(stringResource(R.string.app_name))**/ },
        bottomBar = {},
        floatingActionButton = { }
    )
    {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            Image(
                painter = painterResource(id = R.drawable.newfondo),
                contentDescription = "Fondo",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.matchParentSize()
            )
        }
        contenido(Modifier.fillMaxSize(), navigateToFull, auth, db, navToguia, navToVacu, navextra)
    }

}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun contenido(
    modifier: Modifier,
    navigateToFull: (Consejo) -> Unit,
    auth: FirebaseAuth,
    db: FirebaseFirestore,
    navToguia: () -> Unit,
    navToVacu: () -> Unit,
    navextra: () -> Unit,
) {
    //val scrollState = rememberScrollState()
    val consejos = remember { DataProvider.consejo_list }
    val user = auth.currentUser



    Column(
        modifier = modifier
        /**.verticalScroll(scrollState)**/
        ,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Spacer(modifier = Modifier.padding(25.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .height(50.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center

        )
        {
            Text(
                text = "Bienvenida a Pequeguia",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF424242),
            )
            Spacer(modifier = Modifier.padding(2.dp))
        }
        Spacer(modifier = Modifier.padding(5.dp))
        section_servicios()
        Spacer(modifier = Modifier.padding(5.dp))
        section_kids(navToguia, navToVacu, navextra)
        Spacer(modifier = Modifier.padding(10.dp))
        section_consejos()
        LazyColumn(
            modifier = Modifier.fillMaxSize(0.9f)
        ) {
            items(
                items = consejos,
                itemContent = {
                    ConsejoListItem(consejo = it, navigateToFull)
                }
            )

        }
    }
}


//fun obt_nombre(user: FirebaseUser?, db: FirebaseFirestore): String {
//    val email = user?.email.toString()
//    db.collection("users").whereEqualTo("email",email).get().addOnSuccessListener { documents->
//        var nombr = ""
//        for (document in documents){
//            //Log.i("listis", "${document.id} => ${document.data.getValue("name")}")
//            nombr = document.data.getValue("name").toString()
//        }
//
//    }
//    return nombr
//
//}

//suspend fun esperarResultado(user: FirebaseUser?, db: FirebaseFirestore): String? = db.collection("users").
//document(user?.email.toString()).
//    get().await().getString("name")

@Composable
fun section_kids(navToguia: () -> Unit, navToVacu: () -> Unit, navextra: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.SpaceEvenly
    )
    {
        Box(modifier = Modifier
            .height(200.dp)
            .width(280.dp)) {
            Image(
                painter = painterResource(id = R.drawable.peso),
                contentDescription = "Fondo",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .matchParentSize()
                    .clip(RoundedCornerShape(16.dp))
                    .border(
                        BorderStroke(1.dp, Color(0xFF758694)),
                        RoundedCornerShape(16.dp)
                    )
            )
            Column(
                modifier = Modifier.matchParentSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(16.dp))){
                    Row(modifier = Modifier.background(Color.Black.copy(alpha = 0.4f)).fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                        Text(text = "Guia de crecimiento", fontSize = 12.sp, color = Color.White, modifier = Modifier.padding(5.dp))
                    }
                }
                Spacer(modifier = Modifier.padding(60.dp))
                Button(
                    onClick = { navToguia() },
                    modifier = Modifier
                        .fillMaxWidth(0.3f)
                        .height(35.dp),
                    colors = ButtonDefaults.buttonColors(
                        Color(0xFF95BDFF),
                        Color.White,
                        Color.Gray,
                        Color.White
                    )
                )
                {
                    Text(text = "Ir")
                }
                Spacer(modifier = Modifier.padding(3.dp))
            }
        }
        Spacer(modifier = Modifier.padding(3.dp))
        Box(modifier = Modifier
            .height(200.dp)
            .width(280.dp)) {
            Image(
                painter = painterResource(id = R.drawable.werwerwr),
                contentDescription = "Fondo",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .matchParentSize()
                    .clip(RoundedCornerShape(16.dp))
                    .border(
                        BorderStroke(1.dp, Color(0xFF758694)),
                        RoundedCornerShape(16.dp)
                    )
            )
            Column(
                modifier = Modifier.matchParentSize(),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(16.dp))){
                    Row(modifier = Modifier.background(Color.Black.copy(alpha = 0.4f)).fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                        Text(text = "Guia de vacunas", fontSize = 12.sp, color = Color.White, modifier = Modifier.padding(5.dp))
                    }
                }
                Spacer(modifier = Modifier.padding(62.dp))
                Button(
                    onClick = { navToVacu() },
                    modifier = Modifier
                        .fillMaxWidth(0.3f)
                        .height(35.dp),
                    colors = ButtonDefaults.buttonColors(
                        Color(0xFF95BDFF),
                        Color.White,
                        Color.Gray,
                        Color.White
                    )
                )
                {
                    Text(text = "Ir")
                }
                Spacer(modifier = Modifier.padding(6.dp))
            }

        }
    }

}

@Composable
fun section_consejos() {
    Column() {
        Row(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .height(40.dp),
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Text(
                text = "Consejos para tu bebé",
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
}

@Composable
fun section_servicios() {
    Column() {
        Row(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .height(40.dp),
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Text(
                text = "Servicios",
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
}


@Composable
fun Imagen_user() {
    Image(
        painter = painterResource(id = R.drawable.foto_user),
        contentDescription = "foto de perfil",
        modifier = Modifier.size(70.dp)
    )
}

@Composable
fun ConsejoListItem(consejo: Consejo, navigateToFull: (Consejo) -> Unit) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        shape = RoundedCornerShape(corner = CornerSize(16.dp))

    ) {
        Row(
            modifier = Modifier.clickable { navigateToFull(consejo) }
        ) {
            ConsejoImage(consejo = consejo)
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            ) {
                Text(text = consejo.tittle, fontSize = 13.sp, fontWeight = FontWeight.Bold)
                Text(text = "Ver detalles", fontSize = 10.sp)

            }
        }
    }

}

@Composable
private fun ConsejoImage(consejo: Consejo) {
    Image(
        painter = painterResource(id = consejo.image),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(8.dp)
            .size(84.dp)
            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
    )
}
