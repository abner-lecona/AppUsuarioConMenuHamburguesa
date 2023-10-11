package mx.rmr.menuhamburguesa.view

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import mx.rmr.menuhamburguesa.R
import mx.rmr.menuhamburguesa.databinding.FragmentPrincipalBinding
import mx.rmr.menuhamburguesa.model.Usuario
import mx.rmr.menuhamburguesa.viewmodel.MainActivityVM

class PrincipalFragment : Fragment() {
    private val viewModel: MainActivityVM by viewModels()
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
            findNavController().navigate(R.id.action_principalFragment_to_mapaInicioFragment)
        }
        binding.txtRegistrarse.setOnClickListener {
            findNavController().navigate(R.id.action_principalFragment_to_registrarseFragment)
        }
    }
//    val usuarioPrueba = Usuario("Alonso", "Segura", "De Lucio", "LENAtest13",
//        "Mexico", "M", "2003-05-25","Persona perteneciente al colectivo LGBTQ+", "5521127409",
//        "max_lecona@hotmail.com" )

    override fun onStart() {
        super.onStart()
        //viewModel.registrarUsuario(usuarioPrueba)
    }
}