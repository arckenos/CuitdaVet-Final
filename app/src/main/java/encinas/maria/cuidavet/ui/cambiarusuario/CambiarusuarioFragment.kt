package encinas.maria.cuidavet.ui.cambiarusuario

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import encinas.maria.cuidavet.R
import encinas.maria.cuidavet.databinding.FragmentEditarusuarioBinding

class CambiarusuarioFragment : Fragment() {

    private var _binding: FragmentEditarusuarioBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = inflater.inflate(R.layout.fragment_editarusuario, container, false)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}