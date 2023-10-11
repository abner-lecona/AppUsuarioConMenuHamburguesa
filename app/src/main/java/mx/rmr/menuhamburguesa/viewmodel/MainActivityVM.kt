package mx.rmr.menuhamburguesa.viewmodel

import androidx.lifecycle.ViewModel
import mx.rmr.menuhamburguesa.model.ListaServiciosApi
import mx.rmr.menuhamburguesa.model.Usuario
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivityVM: ViewModel()
{
    //El objeto retrofit
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("http://44.217.43.137:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    //Crea el objeto que instancia al objeto que hara la descarga de datos
    private val descargarAPI by lazy {
        retrofit.create(ListaServiciosApi::class.java)
    }

    fun registrarUsuario(nuevoUsuario: Usuario) {
        val call = descargarAPI.registrarUsuario(nuevoUsuario)
        call.enqueue(object: Callback<Any> {
            override fun onResponse(call: Call<Any>, response: Response<Any>) {
                if (response.isSuccessful){
                    println("RESPUESTA: ${response.body()}")
                } else {
                    println("Error en la descarga ${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<Any>, t: Throwable) {
                println("ERROR: ${t.localizedMessage}")
            }
        })
    }
}