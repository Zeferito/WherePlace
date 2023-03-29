package orientacion.turistica.whereplace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

class Inicio_Secion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio_secion)

        val btn_iniciar: Button = findViewById(R.id.iniciar_sesion_2)
        val btn_regreso: ImageView = findViewById(R.id.regreso)
        val text_usuario: EditText = findViewById(R.id.usuario)
        val text_contra: EditText = findViewById(R.id.contra)

        btn_iniciar.setOnClickListener{
            val intent: Intent = Intent(this, Pantalla_Principal::class.java)
            startActivity(intent)
        }
        btn_regreso.setOnClickListener{
            val intent: Intent = Intent(this, Pantalla_Inicio::class.java)
            startActivity(intent)
        }

    }
}