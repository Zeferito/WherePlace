package orientacion.turistica.whereplace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.ImageView
import android.widget.TextView
import com.google.firebase.firestore.FirebaseFirestore
import java.text.SimpleDateFormat
import java.util.*

class Agendar_viaje : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agendar_viaje)

        val btn_regreso: ImageView = findViewById(R.id.regreso)
        val btn_guardar_viaje: Button = findViewById(R.id.guardar)
        val btn_ver_proximos_viajes: Button = findViewById(R.id.verviajes)

        val et_lugar: TextView = findViewById(R.id.multiAutoCompleteTextView)
        val et_fecha: CalendarView = findViewById(R.id.calendarView)

        val fechaSeleccionada = et_fecha.date
        val fechaTexto = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date(fechaSeleccionada))


        btn_regreso.setOnClickListener{
            val intent: Intent = Intent(this, Pantalla_Principal::class.java)
            startActivity(intent)
        }
        btn_ver_proximos_viajes.setOnClickListener{
            val intent: Intent = Intent(this, Futuros_viajes::class.java)
            startActivity(intent)
        }
        btn_guardar_viaje.setOnClickListener{
            db.collection("lugar").document("lugar").set(
                hashMapOf("lugar" to et_lugar.text.toString(),"fecha" to fechaTexto.toString())
            )
        }
    }
}