package encinas.maria.cuidavet

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import com.google.firebase.database.FirebaseDatabase

class mascotas : AppCompatActivity() {

    private var listamascotas = ArrayList<Pets>()
    private val mascotasRef = FirebaseDatabase.getInstance().getReference("Pets")
    lateinit var listView : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mascotas)

        val btnAgregar : Button = findViewById(R.id.btn_agregarMascota)

        btnAgregar.setOnClickListener{
            val intent = Intent(this, addMascota::class.java)
            startActivity(intent)
            finish()
        }

        listamascotas.clear()
        listView= findViewById(R.id.listaMascotas)
        cargarEventos()
    }

    fun cargarEventos(){
        //Consultamos la lista de todos las mascotas desde la base de datos
        mascotasRef.get().addOnSuccessListener {
            //Recorremos el arreglo de todos las mascotas "it.children" los hijos vienen siendo cada objeto
            for (mascota in it.children){

                var usuario = mascota.child("usuario").value.toString()
                var nombre = mascota.child("nombre").value.toString()
                var edad = mascota.child("edad").value.toString()
                var raza = mascota.child("raza").value.toString()

                var mascota = Pets(nombre,edad,raza,usuario)
                if (usuario == sesion.usuarioActivo.usuario){
                    listamascotas.add(mascota)
                }
            }
            var adaptador =AdaptadorMascotas(this, listamascotas)
            listView.adapter=adaptador

        }

    }

    private class AdaptadorMascotas : BaseAdapter {
        var lista = ArrayList<Pets>()
        var contexto: Context?=null

        constructor(contexto: Context, lista: ArrayList<Pets>){
            this.lista=lista
            this.contexto=contexto
        }

        override fun getCount(): Int {
            return lista.size
        }

        override fun getItem(p0: Int): Any {
            return lista[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val mascota = lista[p0]
            val inflador = LayoutInflater.from(contexto)
            val vista = inflador.inflate(R.layout.mascota_view,null)

            var tvNombre = vista.findViewById(R.id.tvNombre) as TextView
            var tvEdad = vista.findViewById(R.id.tvEdad) as TextView
            var tvRaza = vista.findViewById(R.id.tvRaza) as TextView

            tvNombre.setText(mascota.nombre)
            tvEdad.setText(mascota.edad)
            tvRaza.setText(mascota.raza)

            return vista
        }
    }
}