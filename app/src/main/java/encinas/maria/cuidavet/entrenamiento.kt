package encinas.maria.cuidavet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class entrenamiento : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entrenamiento)

        val btnPatita : Button = findViewById(R.id.btn_patita)
        val btnPelota : Button = findViewById(R.id.btn_pelota)
        val btnSentarse : Button = findViewById(R.id.btn_sentarse)

        btnPatita.setOnClickListener{
            val intent = Intent(this, EntrenamientoPata1::class.java)
            startActivity(intent)
        }
        btnPelota.setOnClickListener{
            val intent = Intent(this, EntrenamientoPelota1::class.java)
            startActivity(intent)
        }
        btnSentarse.setOnClickListener{
            val intent = Intent(this, EntrenamientoSentarse1::class.java)
            startActivity(intent)
        }
    }
}