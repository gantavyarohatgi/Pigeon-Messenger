package com.example.chatapp.app

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.chatapp.screens.LoginScreen
import com.example.chatapp.screens.SignUpScreen
import com.example.chatapp.screens.StartScreen

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route){
            StartScreen(navController)
        }
        composable(route = Screen.SignUpScreen.route){
            SignUpScreen(navController)
        }
        composable(route = Screen.SignInScreen.route){
            LoginScreen(navController)
        }
    }
}