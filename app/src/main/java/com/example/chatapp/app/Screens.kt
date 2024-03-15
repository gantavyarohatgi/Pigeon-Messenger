package com.example.chatapp.app

sealed class Screen(val route: String) {
    data object MainScreen : Screen("start-screen")
    data object SignUpScreen : Screen("signup-screen")
    data object SignInScreen : Screen("signin-screen")

}