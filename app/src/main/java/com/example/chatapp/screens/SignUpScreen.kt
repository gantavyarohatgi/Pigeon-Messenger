package com.example.chatapp.screens

import SignUpActivity
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.chatapp.components.CButton
import com.example.chatapp.components.CTextField
import com.example.chatapp.ui.theme.AlegreyaFontFamily
import com.example.chatapp.ui.theme.AlegreyaSansFontFamily
import com.example.chatapp.R
import com.example.chatapp.app.Screen
import com.example.chatapp.models.UserData

@Composable
fun SignUpScreen(
    navController: NavController
) {
    var userData by remember { mutableStateOf(UserData("", "", "")) }
    Surface(
        color = Color(0xFF253334),
        modifier = Modifier.fillMaxSize()
    ) {
        Image(painter = painterResource(id = R.drawable.bkg1),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(190.dp),
            contentScale = ContentScale.Crop

        )


        Box(modifier =  Modifier.fillMaxSize()){

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp, vertical = 48.dp)
            ) {

                // Logo
                Image(painter = painterResource(id = R.drawable.logotr),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 54.dp)
                        .height(100.dp)
                        .align(Alignment.CenterHorizontally)
                )

                Text(text = "Sign Up",
                    style = TextStyle(
                        fontSize = 28.sp,
                        fontFamily = AlegreyaFontFamily,
                        fontWeight = FontWeight(500),
                        color = Color.White
                    ),
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Text("",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontFamily = AlegreyaSansFontFamily,
                        color = Color(0xB2FFFFFF)
                    ),
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(bottom = 24.dp)
                )

                // Text Field
                CTextField(
                    hint = "Full Name",
                    value = userData.username,
                    onValueChange = { newName -> userData = userData.copy(username = newName) }
                )

                CTextField(
                    hint = "Email Address",
                    value = userData.email,
                    onValueChange = { newEmail -> userData = userData.copy(email = newEmail) }
                )

                CTextField(
                    hint = "Password",
                    value = userData.password,
                    onValueChange = { newPassword -> userData = userData.copy(password = newPassword) }
                )

                Spacer(modifier = Modifier.height(24.dp))

                CButton(
                    text = "Register",
                    onClick = {
                        // Call registerUser function
                        val signUpActivity = SignUpActivity()
                        signUpActivity.registerUser(userData, navController) { success, errorMessage ->
                            if (success) {
                                // Registration successful, navigate to next screen
                                navController.navigate(Screen.SignInScreen.route)
                            } else {
                                // Registration failed, show error message
                                Log.e("SignUpActivity", "Registration failed: $errorMessage")
                            }
                        }
                    }
                )


                Row(
                    modifier = Modifier.padding(top=12.dp, bottom = 52.dp)
                ){
                    Text("Already have an account? ",
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontFamily = AlegreyaSansFontFamily,
                            color = Color.White
                        )
                    )

                    Text("Sign In",
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontFamily = AlegreyaSansFontFamily,
                            fontWeight = FontWeight(800),
                            color = Color.White
                        ),
                        modifier = Modifier.clickable {
                            navController.navigate(route = Screen.SignInScreen.route)
                        }
                    )


                }

            }

        }

    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 640)
@Composable
fun SignupScreenPreview() {
    SignUpScreen(rememberNavController())
}

