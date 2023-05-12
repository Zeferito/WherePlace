package orientacion.turistica.whereplace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.google.firebase.firestore.FirebaseFirestore

class Editar_Usuario : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_usuario)

        val btn_guardar: Button = findViewById(R.id.guardar)
        val et_nombreu: TextView = findViewById(R.id.nombre)
        val et_nombre: EditText = findViewById(R.id.nombre_usuario)
        val et_biografia: EditText = findViewById(R.id.biografia)
        val et_cuenta: EditText = findViewById(R.id.cuenta_algo)
        val et_link: EditText = findViewById(R.id.link)
        val btn_regreso: ImageView = findViewById(R.id.regreso)

        db.collection("users").document("usuario").get().addOnSuccessListener {
            et_nombreu.setText(it.get("nombre") as String?)
        }

        btn_guardar.setOnClickListener{
            db.collection("users").document("usuario").set(
                hashMapOf("nombre" to et_nombre.text.toString(),"biografia" to et_biografia.text.toString(),
                "cuenta" to et_cuenta.text.toString(),
                "link" to et_link.text.toString())
            )
            val intent: Intent = Intent(this, Perfil_Usuario::class.java)
            startActivity(intent)
        }
        btn_regreso.setOnClickListener{
            val intent: Intent = Intent(this, Perfil_Usuario::class.java)
            startActivity(intent)
        }
    }
}