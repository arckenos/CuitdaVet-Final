package encinas.maria.cuidavet.ui.cerrarsesion

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import encinas.maria.cuidavet.databinding.ActivityIniciarSesionBinding

class SalirFragment : Fragment() {
    private var _binding: ActivityIniciarSesionBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val bin = ActivityIniciarSesionBinding.inflate(layoutInflater)

        return bin.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}