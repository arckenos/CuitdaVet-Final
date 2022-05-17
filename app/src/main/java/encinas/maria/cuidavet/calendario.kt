package encinas.maria.cuidavet

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.google.firebase.database.FirebaseDatabase

class calendario : AppCompatActivity() {

    private var eventos = ArrayList<Evento>()
    private val eventosRef = FirebaseDatabase.getInstance().getReference("Eventos")
    lateinit var listView : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendario)

        val btnAgregar : Button = findViewById(R.id.btn_agregarEvento)

        btnAgregar.setOnClickListener{
            val intent = Intent(this, addEvento::class.java)
            startActivity(intent)
            finish()
        }

        eventos.clear()
        listView= findViewById(R.id.listaEventos)
        cargarEventos()

    }


    fun cargarEventos(){
        //Consultamos la lista de todos los eventos desde la base de datos
        eventosRef.get().addOnSuccessListener {
            //Recorremos el arreglo de todos los eventos "it.children" los hijos vienen siendo cada objeto
            for (evento in it.children){

                var usuario = evento.child("usuario").value.toString()
                var asunto = evento.child("asunto").value.toString()
                var dia = evento.child("fecha").child("dia").value.toString()
                var anio = evento.child("fecha").child("anio").value.toString()
                var mes = evento.child("fecha").child("mes").value.toString()

                var fecha = Fecha(dia, mes, anio)
                var evento = Evento(asunto,fecha,usuario)

                if (usuario == sesion.usuarioActivo.usuario){
                    eventos.add(evento)

                }
            }
            var adaptador =AdaptadorEventos(this, eventos)
            listView.adapter=adaptador


        }

    }

    private class AdaptadorEventos : BaseAdapter {
        var lista = ArrayList<Evento>()
        var contexto: Context?=null

        constructor(contexto: Context, lista: ArrayList<Evento>){
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
            val evento = lista[p0]
            val inflador = LayoutInflater.from(contexto)
            val vista = inflador.inflate(R.layout.detalle_calendario,null)

            var tvMes = vista.findViewById(R.id.tvMes) as TextView
            var tvDia = vista.findViewById(R.id.tvDia) as TextView
            var tvAsunto = vista.findViewById(R.id.tvAsunto) as TextView

            tvMes.setText(evento.fecha.mes)
            tvDia.setText(evento.fecha.dia)
            tvAsunto.setText(evento.asunto)

            return vista
        }


    }
}