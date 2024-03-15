package com.example.chatapp.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import com.example.chatapp.R
import com.example.chatapp.screens.LoginScreen
import com.example.chatapp.screens.StartScreen

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            Navigation()
        }
    }
}