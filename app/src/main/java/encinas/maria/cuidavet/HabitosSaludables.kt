package encinas.maria.cuidavet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HabitosSaludables : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_habitos_saludables)

        val btnpasear : Button = findViewById(R.id.btn_pasear)
        val btnalimento : Button = findViewById(R.id.btn_alimento)
        val btnbano : Button = findViewById(R.id.btn_bano)
        val btncitas : Button = findViewById(R.id.btn_citas)

        btnpasear.setOnClickListener{
            val intent = Intent(this, pasear::class.java)
            startActivity(intent)
        }
        btnalimento.setOnClickListener{
            val intent = Intent(this, alimento::class.java)
            startActivity(intent)
        }
        btnbano.setOnClickListener{
            val intent = Intent(this, bano::class.java)
            startActivity(intent)
        }
        btncitas.setOnClickListener{
            val intent = Intent(this, citas::class.java)
            startActivity(intent)
        }
    }
}