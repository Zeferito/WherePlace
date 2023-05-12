package orientacion.turistica.whereplace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class GaleriaFotos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_galeria_fotos)

        val btn_regreso: ImageView = findViewById(R.id.regreso)

        btn_regreso.setOnClickListener{
            val intent: Intent = Intent(this, LugarVisitar::class.java)
            startActivity(intent)
        }
    }
}