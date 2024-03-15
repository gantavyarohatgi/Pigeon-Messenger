import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.chatapp.app.Screen
import com.example.chatapp.models.UserData
import com.example.chatapp.utils.FirebaseUtils

class SignUpActivity : AppCompatActivity() {

    private val firebaseUtils = FirebaseUtils()
    private val auth = firebaseUtils.auth
    private val database = firebaseUtils.database

    fun registerUser(userData: UserData, navController: NavController, callback: (Boolean, String?) -> Unit) {
        auth.createUserWithEmailAndPassword(userData.email, userData.password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val uid = auth.currentUser?.uid
                    if (uid != null) {
                        val userRef = database.child("Users").child(uid)
                        userRef.child("username").setValue(userData.username)
                        userRef.child("email").setValue(userData.email)

                        callback(true, null)
                        navController.navigate(Screen.MainScreen.route)

                    } else {
                        callback(false, "Registration has failed. Unable to get the userid")
                    }
                } else {
                    callback(false, "Registration failed: ${task.exception?.message}")
                }
            }
    }
}
