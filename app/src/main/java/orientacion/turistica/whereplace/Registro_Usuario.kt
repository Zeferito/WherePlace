package orientacion.turistica.whereplace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.google.firebase.ktx.Firebase
import com.google.firebase.firestore.FirebaseFirestore

class Registro_Usuario : AppCompatActivity() {
    private lateinit var storage: FirebaseFirestore ////Modificar acorde a la BD

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_usuario)

        storage = FirebaseFirestore.getInstance() //Modificar acorde a la BD

        // Buttons
        val btn_crear: Button = findViewById(R.id.crear)
        val btn_regreso: ImageView = findViewById(R.id.regreso)
        //Edit text
        val etNombre: EditText = findViewById(R.id.nombre_usuario)
        val etCorreo: EditText = findViewById(R.id.correo_usuario)
        val etContra: EditText = findViewById(R.id.contra_usuario)
        val etContra2: EditText = findViewById(R.id.confir_contra)

        btn_crear.setOnClickListener{
            val datos = hashMapOf(
                "nombre" to etNombre.text.toString(),
                "correo" to etCorreo.text.toString(),
                "contra" to etContra.text.toString()
            )
            storage.collection("usuarios")
                .add(datos)
                .addOnSuccessListener {
                    Toast.makeText(applicationContext, "Cuenta creada", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener{
                    Toast.makeText(applicationContext, it.toString(), Toast.LENGTH_SHORT).show()
                }
            val intent: Intent = Intent(this, Pantalla_Inicio::class.java)
            startActivity(intent)
        }
        btn_regreso.setOnClickListener{
            val intent: Intent = Intent(this, Pantalla_Inicio::class.java)
            startActivity(intent)
        }

    }
}