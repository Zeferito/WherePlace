package orientacion.turistica.whereplace

import android.content.Context
import android.content.Intent
import com.google.firebase.auth.FirebaseAuth

//login
fun Context.login(email:String){
    val intent = Intent(this, Pantalla_Principal::class.java).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    }
    startActivity(intent)
}

//logout
fun Context.logout(){
    FirebaseAuth.getInstance().signOut()
    val intent = Intent(this, Pantalla_Inicio::class.java).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    }
    startActivity(intent)
}