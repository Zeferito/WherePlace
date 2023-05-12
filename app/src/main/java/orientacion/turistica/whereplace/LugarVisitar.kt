package orientacion.turistica.whereplace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class LugarVisitar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lugar_visitar)

        val btn_regreso: ImageView = findViewById(R.id.regreso)
        val btn_galeria: TextView = findViewById(R.id.galeria)


        btn_regreso.setOnClickListener{
            val intent: Intent = Intent(this, Pantalla_Principal::class.java)
            startActivity(intent)
        }
        btn_galeria.setOnClickListener{
            val intent: Intent = Intent(this, GaleriaFotos::class.java)
            startActivity(intent)
        }
    }
}