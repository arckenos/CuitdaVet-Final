package encinas.maria.cuidavet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class EntrenamientoPata4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entrenamiento_pata4)

        val btnAtras : Button = findViewById(R.id.btn_atras)

        btnAtras.setOnClickListener{
            val intent = Intent(this, EntrenamientoPata3::class.java)
            startActivity(intent)
            finish()
        }
    }
}