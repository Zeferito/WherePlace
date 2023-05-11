package orientacion.turistica.whereplace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class Pantalla_Inicio : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth
    private val Google_SIGN_IN = 100
    private lateinit var binding : Pantalla_Inicio
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_inicio)


        mAuth = FirebaseAuth.getInstance()

        val btn_registro: Button = findViewById(R.id.crear_cuenta)
        val btn_inicio: Button = findViewById(R.id.iniciar_sesion)
        val btn_inicio_google: ImageView = findViewById(R.id.inicio_google)


        btn_registro.setOnClickListener{
            val intent: Intent = Intent(this, Registro_Usuario::class.java)
            startActivity(intent)
        }
        btn_inicio.setOnClickListener{
            val intent: Intent = Intent(this, Inicio_Secion::class.java)
            startActivity(intent)
        }
        btn_inicio_google.setOnClickListener{
            //val intent: Intent = Intent(this, Inicio_Sesion_Google::class.java)
            //startActivity(intent)
            btn_inicio_google.setOnClickListener {
                // Configure Google Sign In
                val googleConf = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                    .requestIdToken(getString(R.string.default_web_client_id))
                    .requestEmail()
                    .build()

                val googleClient = GoogleSignIn.getClient(this, googleConf)
                googleClient.signOut()
                val signInIntent = googleClient.signInIntent
                startActivityForResult(signInIntent, Google_SIGN_IN)
            }
        }

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == Google_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                // Google Sign In was successful, authenticate with Firebase
                val account = task.getResult(ApiException::class.java)!!

                if(account!=null){
                    Log.d("TAG", "firebaseAuthWithGoogle:" + account.id)
                    firebaseAuthWithGoogle(account.idToken!!)
                }else{
                    Toast.makeText(this, "correo no existe",Toast.LENGTH_LONG).show()
                }



            } catch (e: ApiException) {
                // Google Sign In failed, update UI appropriately
                Log.w("TAG", "Google sign in failed", e)
            }
        }
    }
    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        mAuth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("TAG", "signInWithCredential:success")
                    val user = mAuth.currentUser?.email.toString()
                    login(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("TAG", "signInWithCredential:failure", task.exception)
                    Toast.makeText(this, "No se pudo loguear",Toast.LENGTH_LONG).show()
                }
            }
    }
}