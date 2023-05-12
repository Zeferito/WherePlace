package orientacion.turistica.whereplace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.google.firebase.firestore.FirebaseFirestore

class Perfil_Usuario : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil_usuario)

        val editar: TextView = findViewById(R.id.editar)
        val et_nombreu: TextView = findViewById(R.id.nombre)
        val et_nombre: EditText = findViewById(R.id.nombreuse)
        val et_biografia: EditText = findViewById(R.id.biografia)
        val et_cuenta: EditText = findViewById(R.id.cuenta_algo)
        val et_link: EditText = findViewById(R.id.link)
        val btn_regreso: ImageView = findViewById(R.id.regreso)

        db.collection("users").document("usuario").get().addOnSuccessListener {
            et_nombreu.setText(it.get("nombre") as String?)
            et_nombre.setText(it.get("nombre") as String?)
            et_biografia.setText(it.get("biografia") as String?)
            et_cuenta.setText(it.get("cuenta") as String?)
            et_link.setText(it.get("link") as String?)
        }

        editar.setOnClickListener{
            val intent: Intent = Intent(this, Editar_Usuario::class.java)
            startActivity(intent)
        }
        btn_regreso.setOnClickListener{
            val intent: Intent = Intent(this, Pantalla_Principal::class.java)
            startActivity(intent)
        }
    }
}