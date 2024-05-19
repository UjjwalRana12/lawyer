package com.android.lawyer.Navigation

sealed class Routes(val routes:String){

    object Home : Routes("home")
    object Profile : Routes("profile")
    object BottomNav : Routes("bottom_nav")
    object Call : Routes("call")
    object Register : Routes("register")


}
