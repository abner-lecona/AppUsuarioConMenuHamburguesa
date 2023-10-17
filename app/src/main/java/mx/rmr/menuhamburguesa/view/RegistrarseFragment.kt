package mx.rmr.menuhamburguesa.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import mx.rmr.menuhamburguesa.R
import mx.rmr.menuhamburguesa.databinding.FragmentRegistrarseBinding
import mx.rmr.menuhamburguesa.model.Usuario
import mx.rmr.menuhamburguesa.model.UsuarioR
import mx.rmr.menuhamburguesa.viewmodel.RegistrarseVM
import java.sql.Date
import java.text.SimpleDateFormat
import java.util.Locale

class RegistrarseFragment : Fragment() {

    private lateinit var binding: FragmentRegistrarseBinding

    private val viewModel: RegistrarseVM by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegistrarseBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.pbEnvioDatos.visibility = View.GONE
        registrarEventos()
        //registrarObservables()
        registrarSpinners()

    }

    private fun registrarSpinners() {
        // Spinner de Sexo
        val spinnerSexo = requireView().findViewById<Spinner>(R.id.spinnerSexo)

        val opcionesSexo = arrayOf("Masculino", "Femenino", "Otros")

        val opcionesSexo = arrayOf(
            "Masculino",
            "Femenino",
            "Otro"
        )

        val adaptadorSexo = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, opcionesSexo)
        spinnerSexo.adapter = adaptadorSexo

        // Spinner de Condicion
        val spinnerCondicion = requireView().findViewById<Spinner>(R.id.spinnerCondicion)

        val opcionesCondicion = arrayOf("Ninguna Condicion", "Embarazo", "Mayor de 60", "Indigena",
            "Discapacidad", "LGBTQ+", "Trabajador informal", "No aplica")

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
            var sexo = binding.spinnerSexo.selectedItem.toString()
            if (sexo == "Masculino"){
                sexo = "M"
            } else if(sexo == "Femenino"){
                sexo = "F"
            } else{
                sexo = "O"
            }
            val usuario = UsuarioR(binding.tiNombre.text.toString(),binding.tiApellido1.text.toString(),binding.tiApellido2.text.toString(),
                binding.tiCURP.text.toString(),binding.spinnerNacionalidad.selectedItem.toString(), sexo,
                binding.etFechaNacimiento.text.toString(), binding.spinnerCondicion.selectedItem.toString(), binding.etCelular.text.toString(),
                binding.etCorreo.text.toString())
            binding.pbEnvioDatos.visibility = View.VISIBLE
            println(usuario)
            android.os.Handler().postDelayed({
                viewModel.resgitrarUsuarioVM(usuario)
                findNavController().navigate(R.id.action_registrarseFragment_to_nav_home)
            },4000)


        }


        }
    }

