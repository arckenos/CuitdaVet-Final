package encinas.maria.cuidavet

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import encinas.maria.cuidavet.databinding.ActivityIniciarSesionBinding

class iniciar_sesion : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityIniciarSesionBinding
    private val userRef = FirebaseDatabase.getInstance().getReference("Users")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIniciarSesionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val btnUsuarioNuevo : Button = findViewById(R.id.btnUsuarioNuevo)

        auth = Firebase.auth

        binding.btnIniciar.setOnClickListener {
            val mEmail = binding.etUsuario.text.toString()
            val mPassw = binding.etContrasenia.text.toString()

            when{
                mEmail.isEmpty() || mPassw.isEmpty() ->{
                    Toast.makeText(baseContext, "Usuario o contrasenia incorrecta. ",
                        Toast.LENGTH_SHORT).show()
                }else->{
                signIn(mEmail, mPassw)
            }
            }
        }

        binding.btnUsuarioNuevo.setOnClickListener {
            var intent : Intent = Intent(this, registro::class.java)
            startActivity(intent)
        }

    }

    private fun signIn(user:String, password: String){
        var usuarioRef = userRef.child(user)
        usuarioRef.get().addOnSuccessListener {
            var correo = it.child("correo").getValue().toString()
            var nombre = it.child("nombre").getValue().toString()
            var user = it.child("usuario").getValue().toString()
            var usuario = Usuario(user, correo, nombre,password)

            auth.signInWithEmailAndPassword(usuario.correo,password)
                .addOnCompleteListener(this){ task->
                    if(task.isSuccessful){
                        Log.d("TAG", "Inicio de sesion con exito")
                        sesion.usuarioActivo = usuario
                        reload();


                    }else{
                        Log.d("TAG", usuario.correo)
                        var correo : String = usuario.correo
                        Toast.makeText(baseContext, "Fallo al iniciar sesion "+correo,
                            Toast.LENGTH_LONG).show();
                    }
                }

        }.addOnFailureListener{
            Toast.makeText(baseContext, "Usuario no encontrado", Toast.LENGTH_LONG).show()

        }

    }

    private fun reload(){
        val intent = Intent(this,calendario::class.java)
        this.startActivity(intent)
    }
}