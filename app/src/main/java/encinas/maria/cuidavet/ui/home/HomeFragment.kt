package encinas.maria.cuidavet.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import encinas.maria.cuidavet.*
import encinas.maria.cuidavet.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        var bin = FragmentHomeBinding.inflate(layoutInflater)

        bin.btnCalendario.setOnClickListener {
            val intent = Intent(this@HomeFragment.requireContext(), calendario::class.java)
            startActivity(intent)
        }
        bin.btnCompras.setOnClickListener {
            val intent = Intent(this@HomeFragment.requireContext(), comprar::class.java)
            startActivity(intent)
        }
        bin.btnEntrenamiento.setOnClickListener{
            val intent = Intent(this@HomeFragment.requireContext(), entrenamiento::class.java)
            startActivity(intent)
        }

        bin.btnForo.setOnClickListener{
            val intent = Intent(this@HomeFragment.requireContext(), foro::class.java)
            startActivity(intent)
        }
        bin.btnTelefono.setOnClickListener{
            val intent = Intent(this@HomeFragment.requireContext(), contactos::class.java)
            startActivity(intent)
        }
        bin.btnMascotas.setOnClickListener{
            val intent = Intent(this@HomeFragment.requireContext(), mascotas::class.java)
            startActivity(intent)
        }

        return bin.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}