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

class contactos : AppCompatActivity() {

    private var listacontactos = ArrayList<Contacts>()
    private val contactsRef = FirebaseDatabase.getInstance().getReference("Contacts")
    lateinit var listView : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contactos)

        val btnAgregar : Button = findViewById(R.id.btn_agregarContacto)

        btnAgregar.setOnClickListener{
            val intent = Intent(this, addContacto::class.java)
            startActivity(intent)
            finish()
        }

        listacontactos.clear()
        listView= findViewById(R.id.listaContactos)
        cargarEventos()
    }

    fun cargarEventos(){
        //Consultamos la lista de todos los contactos desde la base de datos
        contactsRef.get().addOnSuccessListener {
            //Recorremos el arreglo de todos los contactos "it.children" los hijos vienen siendo cada objeto
            for (contacto in it.children){

                var usuario = contacto.child("usuario").value.toString()
                var numero = contacto.child("number").value.toString()
                var nombre = contacto.child("name").value.toString()

                var contacto = Contacts(nombre,numero,usuario)
                if (usuario == sesion.usuarioActivo.usuario){
                    listacontactos.add(contacto)
                }
            }
            var adaptador =AdaptadorContactos(this, listacontactos)
            listView.adapter=adaptador

        }

    }

    private class AdaptadorContactos : BaseAdapter {
        var lista = ArrayList<Contacts>()
        var contexto: Context?=null

        constructor(contexto: Context, lista: ArrayList<Contacts>){
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
            val contacto = lista[p0]
            val inflador = LayoutInflater.from(contexto)
            val vista = inflador.inflate(R.layout.contacto_view,null)

            var tvNombre = vista.findViewById(R.id.persona_nombre) as TextView
            var tvnumero = vista.findViewById(R.id.persona_numero) as TextView

            tvNombre.setText(contacto.name)
            tvnumero.setText(contacto.number)

            return vista
        }
    }
}