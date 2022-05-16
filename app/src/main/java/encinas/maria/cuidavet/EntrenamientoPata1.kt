package encinas.maria.cuidavet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class EntrenamientoPata1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entrenamiento_pata1)

        val btnSiguiente : Button = findViewById(R.id.btn_siguiente)

        btnSiguiente.setOnClickListener{
            val intent = Intent(this, EntrenamientoPata2::class.java)
            startActivity(intent)
            finish()
        }
    }
}