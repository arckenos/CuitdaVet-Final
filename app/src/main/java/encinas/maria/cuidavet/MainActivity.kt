package encinas.maria.cuidavet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.os.Handler

class MainActivity : AppCompatActivity() {
    lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        handler = Handler()
        handler.postDelayed({
            val intent = Intent(this, iniciar_sesion::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}