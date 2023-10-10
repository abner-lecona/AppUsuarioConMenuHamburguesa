package mx.rmr.menuhamburguesa.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import mx.rmr.menuhamburguesa.R
import mx.rmr.menuhamburguesa.databinding.FragmentPrincipalBinding

class PrincipalFragment : Fragment() {
    private lateinit var binding: FragmentPrincipalBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPrincipalBinding.inflate(layoutInflater)
        return binding.root
    }

    // Crea la vista e inicializa los Eventos y Observables
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registrarEventos()
        //registrarObservables()
    }

    // Registra los eventos
    private fun registrarEventos() {

        // Evento de cuando el usuario da clic en el botón del mapa
        binding.btnEntrar.setOnClickListener {
            findNavController().navigate(R.id.action_principalFragment_to_nav_home)
        }
        binding.imgMapa.setOnClickListener {
            findNavController().navigate(R.id.action_principalFragment_to_mapasFragment)
        }
        binding.txtRegistrarse.setOnClickListener {
            findNavController().navigate(R.id.action_principalFragment_to_registrarseFragment)
        }
    }
}