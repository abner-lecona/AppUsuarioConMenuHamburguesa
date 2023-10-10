package mx.rmr.menuhamburguesa.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import mx.rmr.menuhamburguesa.databinding.FragmentCalficaComedoresBinding

class CalificarComedorFragment : Fragment() {

    private var _binding: FragmentCalficaComedoresBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val calificarComedorVM =
            ViewModelProvider(this).get(CalificarComedorVM::class.java)

        _binding = FragmentCalficaComedoresBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}