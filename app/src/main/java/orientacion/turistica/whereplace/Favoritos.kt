package orientacion.turistica.whereplace

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.google.firebase.firestore.FirebaseFirestore

class Favoritos : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favoritos)

        val btn_perfil_usuario: ImageView = findViewById(R.id.regreso)

        val et_lugar: TextView = findViewById(R.id.text_1)
        val et_fecha: TextView = findViewById(R.id.text_2)
        val et_lugar2: TextView = findViewById(R.id.text_3)
        val et_fecha2: TextView = findViewById(R.id.text_4)
        val et_lugar3: TextView = findViewById(R.id.text_5)
        val et_fecha3: TextView = findViewById(R.id.text_6)
        val et_lugar4: TextView = findViewById(R.id.text_7)
        val et_fecha4: TextView = findViewById(R.id.text_8)

        db.collection("interes").document("Nicoletta").get().addOnSuccessListener {
            et_lugar.setText(it.get("titulo") as String?)
            et_fecha.setText(it.get("descripcion") as String?)
        }
        db.collection("interes").document("Resertt").get().addOnSuccessListener {
            et_lugar2.setText(it.get("titulo") as String?)
            et_fecha2.setText(it.get("descripcion") as String?)
        }
        db.collection("interes").document("Sun and Sky").get().addOnSuccessListener {
            et_lugar3.setText(it.get("titulo") as String?)
            et_fecha3.setText(it.get("descripcion") as String?)
        }
        db.collection("interes").document("3 monaquillos").get().addOnSuccessListener {
            et_lugar4.setText(it.get("titulo") as String?)
            et_fecha4.setText(it.get("descripcion") as String?)
        }

        btn_perfil_usuario.setOnClickListener{
            val intent: Intent = Intent(this, MenuProvisional::class.java)
            startActivity(intent)
        }
    }
}

