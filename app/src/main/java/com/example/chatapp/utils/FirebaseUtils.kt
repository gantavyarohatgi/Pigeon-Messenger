package com.example.chatapp.utils

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class FirebaseUtils {
    val auth: FirebaseAuth = FirebaseAuth.getInstance()
    val database: DatabaseReference = Firebase.database.reference
}