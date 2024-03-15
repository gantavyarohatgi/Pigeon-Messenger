package com.example.chatapp.components

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.ModifierLocal
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.chatapp.components.CButton
import com.example.chatapp.components.CTextField
import com.example.chatapp.ui.theme.AlegreyaFontFamily
import com.example.chatapp.ui.theme.AlegreyaSansFontFamily
import com.example.chatapp.R

@Composable
fun ChatNavbar(
    painter: Painter,
    name: String
){
    val colorMatrix = floatArrayOf(
        -1f, 0f, 0f, 0f, 255f,
        0f, -1f, 0f, 0f, 255f,
        0f, 0f, -1f, 0f, 255f,
        0f, 0f, 0f, 1f, 0f
    )

    Surface(
        color = Color(0xFF253334),
        modifier = Modifier.height(60.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()){
            Row (
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 5.dp, horizontal = 2.dp)
            ){
                Image(
                    painter = painterResource(id = R.drawable.chatnavbarback),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(2.dp)
                        .align(Alignment.CenterVertically)
                        .height(30.dp)
                        .width(30.dp),

                )

                Image(
                    painter = painter,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(2.dp)
                        .align(Alignment.CenterVertically)
                        .clip(CircleShape)
                        .height(50.dp)
                        .width(45.dp)
                )

                Text(
                    text = "",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontFamily = AlegreyaFontFamily,
                        fontWeight = FontWeight.Normal,
                        color = Color.White
                    ),
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(2.dp)
                        .width(10.dp)
                )

                Text(
                    text = name,
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontFamily = AlegreyaFontFamily,
                        fontWeight = FontWeight.Normal,
                        color = Color.White
                    ),
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(2.dp)
                )

                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = 5.dp, horizontal = 10.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.chatnavbarvideo),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(2.dp)
                            .align(Alignment.CenterVertically)
                            .height(25.dp)
                            .width(30.dp),
                        colorFilter = ColorFilter.colorMatrix(ColorMatrix(colorMatrix))
                    )

                    Text(
                        text = "",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontFamily = AlegreyaFontFamily,
                            fontWeight = FontWeight.Normal,
                            color = Color.White
                        ),
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(2.dp)
                            .width(10.dp)
                    )

                    Image(
                        painter = painterResource(id = R.drawable.chatnavbarcall),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(2.dp)
                            .align(Alignment.CenterVertically)
                            .height(25.dp)
                            .width(30.dp),
                        colorFilter = ColorFilter.colorMatrix(ColorMatrix(colorMatrix))
                    )

                    Text(
                        text = "",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontFamily = AlegreyaFontFamily,
                            fontWeight = FontWeight.Normal,
                            color = Color.White
                        ),
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(2.dp)
                            .width(10.dp)
                    )

                    Image(
                        painter = painterResource(id = R.drawable.chatnavbarmenuicon),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(2.dp)
                            .align(Alignment.CenterVertically)
                            .height(25.dp)
                            .width(25.dp),
                        colorFilter = ColorFilter.colorMatrix(ColorMatrix(colorMatrix))
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun ChatNavbarPreview(){
    ChatNavbar(painter = painterResource(id = R.drawable.loginbkg), name = "Dhruv")
}