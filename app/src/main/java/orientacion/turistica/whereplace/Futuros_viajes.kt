package orientacion.turistica.whereplace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.*
import com.google.firebase.firestore.FirebaseFirestore


class Futuros_viajes : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_futuros_viajes)

        val btn_regreso: ImageView = findViewById(R.id.regreso)
        val btn_agendar_viaje: Button = findViewById(R.id.agendar)
        val btn_inicio: Button = findViewById(R.id.inicio)

        val et_lugar: TextView = findViewById(R.id.text_1)
        val et_fecha: TextView = findViewById(R.id.text_2)

        db.collection("lugar").document("lugar").get().addOnSuccessListener {
            et_lugar.setText(it.get("lugar") as String?)
            et_fecha.setText(it.get("fecha") as String?)
        }

        btn_regreso.setOnClickListener {
            val intent: Intent = Intent(this, Pantalla_Principal::class.java)
            startActivity(intent)
        }
        btn_agendar_viaje.setOnClickListener {
            val intent: Intent = Intent(this, Agendar_viaje::class.java)
            startActivity(intent)
        }
        btn_inicio.setOnClickListener {
            val intent: Intent = Intent(this, Pantalla_Principal::class.java)
            startActivity(intent)
        }
    }
}