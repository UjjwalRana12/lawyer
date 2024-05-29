package com.android.lawyer.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.android.lawyer.screens.Call
import com.android.lawyer.screens.ChatScreen
import com.android.lawyer.screens.Home
import com.android.lawyer.screens.Message
import com.android.lawyer.screens.Profile
import com.android.lawyer.screens.aiChat
import com.android.lawyer.screens.bottomNav

@Composable

fun navGraph(navController: NavHostController){

    NavHost(navController = navController, startDestination = Routes.BottomNav.routes ){

        composable(route = Routes.BottomNav.routes) {
            bottomNav(navController)
        }

         composable(route = Routes.Call.routes) {
            Call(navController)
        }


        composable(route = Routes.Profile.routes) {
            Profile(navController)
        }

            composable(route = Routes.Home.routes) {
            Home(navController)
        }

        composable(Routes.ChatScreen.routes){
            ChatScreen(navController)
        }

        composable(Routes.Message.routes){
            Message(navController )
        }
    }
}