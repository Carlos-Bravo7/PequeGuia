package com.duty.pequeguia

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.duty.pequeguia.data.Consejo
import com.duty.pequeguia.presentation.RegistroNino
import com.duty.pequeguia.presentation.bottomNavBar
import com.duty.pequeguia.presentation.graph.grados
import com.duty.pequeguia.presentation.splashScreen.SplashScreen
import com.duty.pequeguia.presentation.login.Login
import com.duty.pequeguia.presentation.notifications.notifications
import com.duty.pequeguia.presentation.registro.Registro
import com.duty.pequeguia.presentation.vacunas
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun NavigationWrapper(db: FirebaseFirestore, auth: FirebaseAuth, navHostController: NavHostController, navigateToFull:(Consejo) -> Unit) {
    NavHost(navController = navHostController, startDestination = "login") {
        composable("login") {
            Login (auth,{navHostController.navigate("registro")},{navHostController.navigate("bNav")})
        }
        composable("splash") {
            SplashScreen { navHostController.navigate("login") }
        }
        composable("registro") {
            Registro (db, auth,{ navHostController.navigate("login")},{ navHostController.navigate("bNav")})
        }
        composable("bNav") {
            //lazy()
            bottomNavBar(navigateToFull, auth, db, { navHostController.navigate("rni") }, { navHostController.navigate("login") }, { navHostController.navigate("vacu") }, { navHostController.navigate("derrota")})
        }

        composable("notif") {
            notifications()
        }
        composable("rni") {
            RegistroNino()
        }

        composable("vacu") {
            vacunas()
        }

        composable("derrota") {
            grados()
        }

    }
}