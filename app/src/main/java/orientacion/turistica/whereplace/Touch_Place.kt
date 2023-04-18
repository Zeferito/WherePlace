package orientacion.turistica.whereplace

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.content.Intent
import android.widget.Button

class Touch_Place : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_touch_place)



         val btn : Button = findViewById(R.id.btngohome)
        btn.setOnClickListener{
          val intent: Intent= Intent(this,Pantalla_Inicio :: class.java )
        startActivity(intent)
        }
    }
}