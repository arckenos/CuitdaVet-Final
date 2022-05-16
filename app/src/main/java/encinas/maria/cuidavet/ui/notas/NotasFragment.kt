package encinas.maria.cuidavet.ui.notas

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import encinas.maria.cuidavet.databinding.FragmentNotasBinding

class NotasFragment : Fragment() {

    private var _binding: FragmentNotasBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val bin = FragmentNotasBinding.inflate(layoutInflater)

        return bin.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}