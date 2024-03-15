package com.example.chatapp.app

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.chatapp.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

     object SignUpActivity {

         private val auth = FirebaseAuth.getInstance();

         private val database = Firebase.database.reference;

         fun registerUser(name: String, email: String, password: String, callback: (Boolean, String?) -> Unit) {
             auth.createUserWithEmailAndPassword(email, password) //Now a userid should be created for the registered user
                 .addOnCompleteListener { task ->
                     if (task.isSuccessful) { //Mean that registration was successful
                         val uid = auth.currentUser?.uid //Getting the automatically created userid if the firebase
                         if (uid != null) {
                             // Store additional user information in Firebase Realtime Database
                             val userRef = database.child("user_table").child(uid)
                             userRef.child("fullname").setValue(name);
                             userRef.child("email").setValue(email);

                             callback(true, null); //To indicate successful registeration

                         } else { //uid is null

                             callback(false, "Registeration has failed. Unable to get the userid")

                         }


                     } else { // Registration failed

                         callback(false, "Registration failed: ${task.exception?.message}")

                     }

                 }
         }
     }