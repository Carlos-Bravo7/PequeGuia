package com.duty.pequeguia.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.duty.pequeguia.Items_bottombar
import com.duty.pequeguia.data.Consejo
import com.duty.pequeguia.presentation.home.home
import com.duty.pequeguia.presentation.perfil.perfil
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun bottomNavBar(
    navigateToFull: (Consejo) -> Unit,
    auth: FirebaseAuth,
    db: FirebaseFirestore,
    navToGuia: () -> Unit,
    navToLogin: () -> Unit,
    navToVacu: () -> Unit,
    navextra: () -> Unit
)
{

    val itemNavList = listOf(
        Items_bottombar(Icons.Default.Home, "Home"),
        Items_bottombar(Icons.Default.AccountCircle, "Perfil")
    )

    var selectedindex by remember {
        mutableIntStateOf(0)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        content = { content(selectedindex,navigateToFull, auth, db, navToGuia, navToLogin, navToVacu, navextra)},
        bottomBar = {
            //    bottombar(itemNavList, selectedindex)
            NavigationBar() {
                itemNavList.forEachIndexed { index, itemsBottombar ->
                    NavigationBarItem(
                        selected = selectedindex == index,
                        onClick = {
                            selectedindex = index
                        },
                        icon = {
                            Icon(imageVector = itemsBottombar.icon, contentDescription = "Icon")
                        },
                        label = {
                            Text(text = itemsBottombar.title)
                        }
                    )
                }
            }
        }
    )
}

@Composable
fun content(
    selectedindex: Int,
    navigateToFull: (Consejo) -> Unit,
    auth: FirebaseAuth,
    db: FirebaseFirestore,
    navToGuia: () -> Unit,
    navToLogin: () -> Unit,
    navToVacu: () -> Unit,
    navextra: () -> Unit
) {
    when(selectedindex){
        0 -> home(navigateToFull = navigateToFull, auth,db, navToGuia, navToVacu, navextra)
        1 -> perfil(navToLogin, navextra)
    }
}