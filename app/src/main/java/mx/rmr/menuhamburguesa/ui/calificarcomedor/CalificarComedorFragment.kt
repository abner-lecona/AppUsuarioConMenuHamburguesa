package mx.rmr.menuhamburguesa.ui.calificarcomedor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import mx.rmr.menuhamburguesa.R
import mx.rmr.menuhamburguesa.databinding.FragmentCalficaComedoresBinding
import mx.rmr.menuhamburguesa.model.Calificacion
import mx.rmr.menuhamburguesa.viewmodel.SharedViewModel

class CalificarComedorFragment : Fragment() {

    private val sharedViewModel: SharedViewModel by activityViewModels()
    private val viewModel: CalificarComedorVM by viewModels()
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

        //Estrellas
        binding.rbRapidezComedor.rating = 0f
        binding.rbRapidezComedor.stepSize = 1f
        binding.rbComidaComedor.stepSize = 1f
        binding.rbLimpiezaComedor.stepSize = 1f

        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.obtenerComedores()
        // Spinner de comedores
        viewModel.comedores.observe(viewLifecycleOwner){array->
            val arrComedores = array
            binding.spinnerComedores.adapter = ArrayAdapter( requireContext(),
                android.R.layout.simple_spinner_item, arrComedores)
        }
        registrarEventos()
    }

    private fun registrarEventos() {
        binding.btnCalificarComedor.setOnClickListener{
            var calificacion = Calificacion(sharedViewModel.usuario.value!!.IDUsuario,1, binding.etFechaComedores.text.toString(),binding.rbLimpiezaComedor.rating.toInt(),
                binding.rbComidaComedor.rating.toInt(), binding.rbRapidezComedor.rating.toInt(), binding.etComentarioComedor.text.toString())
            viewModel.calificarComedor(calificacion)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}