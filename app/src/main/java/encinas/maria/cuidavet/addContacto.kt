package encinas.maria.cuidavet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import java.util.*

class addContacto : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_contacto)

        val btnAgregarContacto : Button = findViewById(R.id.btnAgregar)
        val etNombre : EditText = findViewById(R.id.etNombre)
        val etNumero : EditText = findViewById(R.id.etTelefono)

        btnAgregarContacto.setOnClickListener {
            val nombre = etNombre.text.toString()
            val telefono = etNumero.text.toString()

            if(nombre.isEmpty() || telefono.isEmpty()){
                Toast.makeText(baseContext,"Ingrese todos los datos", Toast.LENGTH_SHORT).show()
            }else{
                addContact(nombre,telefono)
            }
        }
    }

    private fun addContact(nombre: String, telefono:String){
        val contactosRef = FirebaseDatabase.getInstance().getReference("Contacts")
        val uniqueID: String = UUID.randomUUID().toString()
        var contactoNuevo = Contacts(nombre, telefono, sesion.usuarioActivo.usuario)
        contactosRef.child(uniqueID).setValue(contactoNuevo)
        reload()
    }

    private fun reload(){
        val intent : Intent = Intent(this, contactos::class.java)
        startActivity(intent)
        finish()
    }
}