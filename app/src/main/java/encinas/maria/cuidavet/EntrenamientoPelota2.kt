package encinas.maria.cuidavet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class EntrenamientoPelota2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entrenamiento_pelota2)

        val btnSiguiente : Button = findViewById(R.id.btn_siguiente)
        val btnAtras : Button = findViewById(R.id.btn_atras)

        btnSiguiente.setOnClickListener{
            val intent = Intent(this, EntrenamientoPelota3::class.java)
            startActivity(intent)
            finish()
        }
        btnAtras.setOnClickListener{
            val intent = Intent(this, EntrenamientoPelota1::class.java)
            startActivity(intent)
            finish()
        }
    }
}