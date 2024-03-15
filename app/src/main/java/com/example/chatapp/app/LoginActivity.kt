import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import com.example.chatapp.app.Screen
import com.example.chatapp.models.UserData
import com.example.chatapp.utils.FirebaseUtils
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private val firebaseUtils = FirebaseUtils()
    private val auth = firebaseUtils.auth

    fun Login(userData: UserData, navController: NavController, callback: (Boolean, String?) -> Unit) {
        auth.signInWithEmailAndPassword(userData.email, userData.password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Navigate to the main activity
                    navController.navigate(Screen.MainScreen.route)
                } else {
                    // Login failed, show error message
                }
            }
    }
}
