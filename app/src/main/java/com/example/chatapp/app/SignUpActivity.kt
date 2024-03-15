package com.example.chatapp.app

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
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
                         checkEmail()
                         val uid = auth.currentUser?.uid //Getting the automatically created userid in the firebase
                         if (uid != null) {
                             // Store additional user information in Firebase Realtime Database
                             val userRef = database.child("user_table").child(uid)
                             userRef.child("fullname").setValue(name);
                             userRef.child("email").setValue(email);

                             callback(true, null); //To indicate successful registration

                         } else { //uid is null

                             callback(false, "Registeration has failed. Unable to get the userid")

                         }


                     } else { // Registration failed

                         callback(false, "Registration failed: ${task.exception?.message}")

                     }

                 }
         }

         fun checkEmail(){
             val firebaseUser = auth.currentUser
             firebaseUser?.sendEmailVerification()?.addOnCompleteListener { task ->
                 if(task.isSuccessful){
                     Toast.makeText(this,"Verification sent to your Email",Toast.LENGTH_SHORT).show()
                     auth.signOut()
                     finish()
                     startActivity(Intent(this,MainActivity::class.java))
                 }
                 else{
                     Toast.makeText(this,"Error occurred while sending Verification",Toast.LENGTH_SHORT).show()
                 }
             }

         }
         fun verifyEmail(){
             val firebaseUser = FirebaseAuth.getInstance().currentUser
             val verifyEmail = firebaseUser?.isEmailVerified
             startActivity(Intent(this,MainActivity::class.java))
             if (verifyEmail!!){
                 finish()
                 startActivity(Intent(this,MainActivity::class.java))
             }
             else{
                 Toast.makeText(this,"Please verify your email",Toast.LENGTH_SHORT).show()
                 auth.signOut()
             }
         }



     }