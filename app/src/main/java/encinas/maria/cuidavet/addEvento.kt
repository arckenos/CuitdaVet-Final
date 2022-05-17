package encinas.maria.cuidavet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.firebase.database.FirebaseDatabase
import java.util.*

class addEvento : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_evento)

        val calendarView: CalendarView = findViewById(R.id.calendarView)
        val dateView: TextView = findViewById(R.id.tvFecha)
        val btnGuardar: Button = findViewById(R.id.btn_guardar)
        val evento: EditText = findViewById(R.id.etEvento)

        // Date
        var anio = "aaaa"
        var mes = "mm"
        var dia = "dd"

        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val msg = "" + dayOfMonth + "/" + (month + 1) + "/" + year
            anio = year.toString()
            mes = month.toString()
            dia = dayOfMonth.toString()
            dateView.setText(msg)
            dateView.text = msg
        }

        btnGuardar.setOnClickListener {
            var fecha = dateView.getText() as String
            var evento = evento.getText().toString()

            if (fecha.isEmpty() || evento.isEmpty()) {
                Toast.makeText(baseContext,"Ingrese todos los datos", Toast.LENGTH_SHORT).show()
            } else {
                if(mes == "0"){
                    mes = "Enero"
                }else if(mes == "1"){
                    mes= "Febrero"
                }else if(mes == "2"){
                    mes= "Marzo"
                }else if(mes == "3"){
                    mes= "Abril"
                }else if(mes == "4"){
                    mes= "Mayo"
                }else if(mes == "5"){
                    mes= "Junio"
                }else if(mes == "6"){
                    mes= "Julio"
                }else if(mes == "7"){
                    mes= "Agosto"
                }else if(mes == "8"){
                    mes= "Septiembre"
                }else if(mes == "9"){
                    mes= "Octubre"
                }else if(mes == "10"){
                    mes= "Noviembre"
                }else if(mes == "11"){
                    mes= "Diciembre"
                }

                var fecha = Fecha(dia, mes, anio)
                addEvento(fecha, evento)
            }
        }
    }

    private fun addEvento(fecha: Fecha, evento: String) {
        val eventoRef = FirebaseDatabase.getInstance().getReference("Eventos")
        val uniqueID: String = UUID.randomUUID().toString()
        var eventoNuevo = Evento(evento, fecha, sesion.usuarioActivo.usuario)

        eventoRef.child(uniqueID).setValue(eventoNuevo)
        reload()
    }

    private fun reload(){
        val intent : Intent = Intent(this, calendario::class.java)
        startActivity(intent)
        finish()
    }
}