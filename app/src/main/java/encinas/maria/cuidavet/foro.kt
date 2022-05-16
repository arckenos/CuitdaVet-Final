package encinas.maria.cuidavet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class foro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foro)

        val btnTips : Button = findViewById(R.id.btn_tips)
        val btnHabitos : Button = findViewById(R.id.btn_habitos)

        btnHabitos.setOnClickListener{
            val intent = Intent(this, HabitosSaludables::class.java)
            startActivity(intent)
        }
        btnTips.setOnClickListener{
            val intent = Intent(this, Tips::class.java)
            startActivity(intent)
        }
    }
}