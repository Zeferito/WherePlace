package orientacion.turistica.whereplace

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.content.Intent
import android.widget.Button
import android.widget.ImageView

class Touch_Place : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_touch_place)



         val btn : ImageView = findViewById(R.id.regreso)
        btn.setOnClickListener{
          val intent: Intent= Intent(this,Pantalla_Principal:: class.java )
        startActivity(intent)
        }


        val btn2 : Button = findViewById(R.id.btntouchplace)
        btn2.setOnClickListener{
            val intent: Intent= Intent(this,Pantalla_Cargando:: class.java )
            startActivity(intent)
        }
    }
}