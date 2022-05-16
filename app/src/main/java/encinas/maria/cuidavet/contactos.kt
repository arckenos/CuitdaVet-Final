package encinas.maria.cuidavet

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase

class contactos : AppCompatActivity() {

    private val userRef = FirebaseDatabase.getInstance().getReference("Contacts")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contactos)

        userRef.addChildEventListener(object : ChildEventListener {
            override fun onCancelled(databaseError: DatabaseError) {}
            override fun onChildMoved(dataSnapshot: DataSnapshot, previousName: String?) {}
            override fun onChildChanged(dataSnapshot: DataSnapshot, previousName: String?) {}
            override fun onChildRemoved(dataSnapshot: DataSnapshot) {}

            override fun onChildAdded(dataSnapshot: DataSnapshot, p1: String?) {
//                val usuario = dataSnapshot.getValue(Contacts::class.java)
  //              if (usuario != null) writeMark(usuario)
            }
        })

    }

    private fun writeMark(mark: Contacts) {
        var listV: TextView =findViewById(R.id.lista) as TextView
        val text = listV.text.toString() + mark.toString() + "\n"
        listV.text = text
    }

}