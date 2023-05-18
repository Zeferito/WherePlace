package orientacion.turistica.whereplace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.firestore.FirebaseFirestore

class Fin_Dinamica : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fin_dinamica)

        val et_lugar: TextView = findViewById(R.id.text_1)
        val et_descripcion: TextView = findViewById(R.id.text_2)
        val et_mensaje: TextView = findViewById(R.id.mensaje)

        val lugar1 = intent.getIntExtra("number1", -1)
        val lugar2 = intent.getIntExtra("number2", -1)

        val ganador = if(lugar1 > lugar2) lugar1 else lugar2

        et_mensaje.setText("Felicidades el ganador ha sido el numero" + ganador.toString() + "el lugar sera " +
        et_lugar)

        if (ganador == 1) {
            db.collection("interes").document("Nicoletta").get().addOnSuccessListener {
                et_lugar.setText(it.get("titulo") as String?)
                et_descripcion.setText(it.get("descripcion") as String?)
            }
        }
        if (ganador == 2) {
            db.collection("interes").document("Resertt").get().addOnSuccessListener {
                et_lugar.setText(it.get("titulo") as String?)
                et_descripcion.setText(it.get("descripcion") as String?)
            }
        }
        if (ganador == 3) {
            db.collection("interes").document("Sun and Sky").get().addOnSuccessListener {
                et_lugar.setText(it.get("titulo") as String?)
                et_descripcion.setText(it.get("descripcion") as String?)
            }
        }
        if (ganador == 4) {
            db.collection("interes").document("3 monaquillos").get().addOnSuccessListener {
                et_lugar.setText(it.get("titulo") as String?)
                et_descripcion.setText(it.get("descripcion") as String?)
            }
        }

        val btn : Button = findViewById(R.id.btnintentar)
        btn.setOnClickListener{
            val  intent= Intent(this,Pantalla_Huellas :: class.java )
            startActivity(intent)
        }

         val btnvolverinicio : Button= findViewById(R.id.btnvolverinicio)
        btnvolverinicio.setOnClickListener{
         val  intent= Intent(this,Pantalla_Principal :: class.java )
         startActivity(intent)
        }
    }
}