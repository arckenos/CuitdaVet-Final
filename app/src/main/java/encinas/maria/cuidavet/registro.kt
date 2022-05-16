package encinas.maria.cuidavet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import encinas.maria.cuidavet.databinding.ActivityRegistroBinding


class registro : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityRegistroBinding
    private val userRef = FirebaseDatabase.getInstance().getReference("Users")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth

        binding.btnSiguiente.setOnClickListener {
            val email = binding.etCorreo.text.toString()
            val user = binding.etUsuario.text.toString()
            val nombre = binding.etNombre.text.toString()
            val password = binding.etContrasenia.text.toString()
            if(email.isEmpty() || password.isEmpty()){
                Toast.makeText(baseContext,"Ingrese todos los datos", Toast.LENGTH_SHORT).show()
            }else if(password.length < 6){
                Toast.makeText(baseContext,"Contrasenia muy corta", Toast.LENGTH_SHORT).show()
            }else{
                createAccount(user,email,nombre,password)
            }

        }

    }

    private fun createAccount(usuario: String, correo:String, nombre: String, password: String){
        auth.createUserWithEmailAndPassword(correo,password)
            .addOnCompleteListener(this){ task ->
                if(task.isSuccessful){
                    Toast.makeText(baseContext,"Usuario registado con exito", Toast.LENGTH_SHORT).show()
                    var nuevo_usuario = Usuario(
                        usuario,
                        correo,
                        nombre,
                        password
                    )
                    userRef.child(usuario).setValue(nuevo_usuario)
                    reload()
                }else{
                    Toast.makeText(baseContext,"Autentication failed", Toast.LENGTH_SHORT).show()
                }

            }
    }

    private fun reload(){
        val intent : Intent = Intent(this, iniciar_sesion::class.java)
        startActivity(intent)
    }
}