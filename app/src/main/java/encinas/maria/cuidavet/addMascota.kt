package encinas.maria.cuidavet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import java.util.*

class addMascota : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_mascota)

        val btnAgregarMascota : Button = findViewById(R.id.btn_guardar)
        val etNombre : EditText = findViewById(R.id.etNombre)
        val etEdad : EditText = findViewById(R.id.etEdad)
        val etRaza : EditText = findViewById(R.id.etRaza)

        btnAgregarMascota.setOnClickListener {
            val nombre = etNombre.text.toString()
            val edad = etEdad.text.toString()
            val raza = etRaza.text.toString()

            if(nombre.isEmpty() || edad.isEmpty() || raza.isEmpty()){
                Toast.makeText(baseContext,"Ingrese todos los datos", Toast.LENGTH_SHORT).show()
            }else{
                addMascota(nombre,edad, raza)
            }
        }
    }

    private fun addMascota(nombre: String, edad: String, raza: String){
        val mascotasRef = FirebaseDatabase.getInstance().getReference("Pets")
        val uniqueID: String = UUID.randomUUID().toString()
        var mascotaNueva = Pets(nombre, edad, raza, sesion.usuarioActivo.usuario)
        mascotasRef.child(uniqueID).setValue(mascotaNueva)
        reload()
    }

    private fun reload(){
        val intent : Intent = Intent(this, mascotas::class.java)
        startActivity(intent)
        finish()
    }
}