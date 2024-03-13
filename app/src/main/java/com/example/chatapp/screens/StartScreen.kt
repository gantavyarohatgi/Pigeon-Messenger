package com.example.chatapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chatapp.R
import com.example.chatapp.components.ButtonComponent
import com.example.chatapp.components.EmailTextFieldComponent
import com.example.chatapp.components.GreyButtonComponent
import com.example.chatapp.components.PasswordTextFieldComponent
import com.example.chatapp.components.TextComponent

@Preview
@Composable
fun StartScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.startscreen),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Surface(
            color = Color.Transparent,
            modifier = Modifier
                .fillMaxSize()
                .padding(25.dp)
                .padding(top = 30.dp)
        ) {


            Column(
                Modifier
                    .fillMaxSize()
                    .padding(bottom = 150.dp),
                verticalArrangement = Arrangement.Bottom


            ) {
                TextComponent(
                    value = stringResource(id = R.string.startscreen),
                    FontStyle.Italic,
                    FontWeight.Normal,
                    18,
                    0,
                    Color.White
                )
                Spacer(modifier = Modifier.height(30.dp))
                ButtonComponent(value = stringResource(id = R.string.login_btn), Color.White)
                Spacer(modifier = Modifier.height(20.dp))
                GreyButtonComponent(value = stringResource(id = R.string.get_started), Color.White)

            }
        }
    }
}

@Preview
@Composable
fun DefaultPreviewOfStartScreen() {
    StartScreen()
}