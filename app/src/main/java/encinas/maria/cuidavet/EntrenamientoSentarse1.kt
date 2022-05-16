package encinas.maria.cuidavet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class EntrenamientoSentarse1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entrenamiento_sentarse1)

        val btnSiguiente : Button = findViewById(R.id.btn_siguiente)

        btnSiguiente.setOnClickListener{
            val intent = Intent(this, EntrenamientoSentarse2::class.java)
            startActivity(intent)
            finish()
        }
    }
}