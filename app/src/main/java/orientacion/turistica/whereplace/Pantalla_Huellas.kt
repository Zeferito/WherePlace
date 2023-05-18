package orientacion.turistica.whereplace

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import kotlin.random.Random

class Pantalla_Huellas : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_huellas)

        val et_lugar: TextView = findViewById(R.id.text_1)
        val et_descripcion: TextView = findViewById(R.id.text_2)
        val et_lugar2: TextView = findViewById(R.id.text_3)
        val et_descripcion2: TextView = findViewById(R.id.text_4)

        val number = Random.nextInt(1, 5)
        val number2 = Random.nextInt(1, 5)

        mostrarToast(applicationContext, "Mantengan presionada la pantalla en sus respectivos lugares con su dedo pulgar.\n" +
                " Al terminar uno de los dos colores abarcará mayormente el espacio de la pantalla\n" +
                " y será el lugar escogido. \n" +
                "\n" +
                "¡Vamos!")

        if (number == 1) {
            var num1 = 1
            db.collection("interes").document("Nicoletta").get().addOnSuccessListener {
                et_lugar.setText(it.get("titulo") as String?)
                et_descripcion.setText(it.get("descripcion") as String?)
            }
        }
        if (number2 == 1) {
            var num2 = 1
            db.collection("interes").document("Nicoletta").get().addOnSuccessListener {
                et_lugar2.setText(it.get("titulo") as String?)
                et_descripcion2.setText(it.get("descripcion") as String?)
            }
        }
        if (number == 2) {
            var num1 = 2
            db.collection("interes").document("Resertt").get().addOnSuccessListener {
                et_lugar.setText(it.get("titulo") as String?)
                et_descripcion.setText(it.get("descripcion") as String?)
            }
        }
        if (number2 == 2) {
            var num2 = 2
            db.collection("interes").document("Resertt").get().addOnSuccessListener {
                et_lugar2.setText(it.get("titulo") as String?)
                et_descripcion2.setText(it.get("descripcion") as String?)
            }
        }
        if (number == 3) {
            var num1 = 3
            db.collection("interes").document("Sun and Sky").get().addOnSuccessListener {
                et_lugar.setText(it.get("titulo") as String?)
                et_descripcion.setText(it.get("descripcion") as String?)
            }
        }
        if (number2 == 3) {
            var num2 = 3
            db.collection("interes").document("Sun and Sky").get().addOnSuccessListener {
                et_lugar2.setText(it.get("titulo") as String?)
                et_descripcion2.setText(it.get("descripcion") as String?)
            }
        }
        if (number == 4) {
            var num1 = 4
            db.collection("interes").document("3 monaquillos").get().addOnSuccessListener {
                et_lugar.setText(it.get("titulo") as String?)
                et_descripcion.setText(it.get("descripcion") as String?)
            }
        }
        if (number2 == 4) {
            var num2 = 4
            db.collection("interes").document("3 monaquillos").get().addOnSuccessListener {
                et_lugar2.setText(it.get("titulo") as String?)
                et_descripcion2.setText(it.get("descripcion") as String?)
            }

        }



        val imageView1: ImageView = findViewById(R.id.btnfin1)
        val imageView2: ImageView = findViewById(R.id.btnfin2)

        imageView1.setOnClickListener {
            checkImagesClicked(number, number2)
        }

        imageView2.setOnClickListener {
            checkImagesClicked(number, number2)
        }


    }
    private fun checkImagesClicked(db1: Int, db2: Int) {
        val db1 = db1
        val db2 = db2
            val intent = Intent(this, Fin_Dinamica::class.java)
            intent.putExtra("number1", db1)
            intent.putExtra("number2", db2)
            startActivity(intent)
    }
    fun mostrarToast(context: Context, mensaje: String) {
        Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show()
    }
}
