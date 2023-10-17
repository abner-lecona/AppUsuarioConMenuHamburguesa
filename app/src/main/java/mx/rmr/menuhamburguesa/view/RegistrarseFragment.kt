package mx.rmr.menuhamburguesa.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import mx.rmr.menuhamburguesa.R
import mx.rmr.menuhamburguesa.databinding.FragmentRegistrarseBinding
import mx.rmr.menuhamburguesa.viewmodel.RegistrarseVM

class RegistrarseFragment : Fragment() {

    private lateinit var binding: FragmentRegistrarseBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegistrarseBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registrarEventos()
        //registrarObservables()
        registrarSpinners()
    }

    private fun registrarSpinners() {
        // Spinner de Sexo
        val spinnerSexo = requireView().findViewById<Spinner>(R.id.spinnerSexo)
        val opcionesSexo = arrayOf(
            "Masculino",
            "Femenino",
            "Otro"
        )
        val adaptadorSexo = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, opcionesSexo)
        spinnerSexo.adapter = adaptadorSexo

        // Spinner de Condicion
        val spinnerCondicion = requireView().findViewById<Spinner>(R.id.spinnerCondicion)
        val opcionesCondicion = arrayOf(
            "Persona mayor de 60 años",
            "Menor de edad",
            "Persona indígena",
            "Persona con discapacidad",
            "Persona perteneciente al colectivo LGBTQ+",
            "Migrante o desplazado por conflictos",
            "Persona en condición de calle",
            "Mujer embarazada",
            "Trabajador/a informal",
            "Otra condición",
            "No aplica"
        )
        val adaptadorCondicion = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, opcionesCondicion)
        spinnerCondicion.adapter = adaptadorCondicion

        // Spinner de Nacionalidad
        val spinnerNacionalida = requireView().findViewById<Spinner>(R.id.spinnerNacionalidad)
        val opcionesNacionalidad = arrayOf(
            "México",
            "Guatemala",
            "El Salvador",
            "Chile",
            "Brasil",
            "Perú",
            "Honduras",
            "Bolivia",
            "Venezuela",
            "Ecuador",
            "Cuba",
            "Belice",
            "Uruguay",
            "Argentina",
        )
        val adaptadorNacionalidad = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, opcionesNacionalidad)
        spinnerNacionalida.adapter = adaptadorNacionalidad

    }

    private fun registrarEventos() {
        binding.btnEnviarDatos.setOnClickListener{
            // mandar los datos a la base
        }
    }

}