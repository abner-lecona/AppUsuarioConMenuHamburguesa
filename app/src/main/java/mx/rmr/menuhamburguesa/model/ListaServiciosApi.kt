package mx.rmr.menuhamburguesa.model

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ListaServiciosApi
{
    @POST("/registrarUsuarioP")
    fun registrarUsuario(@Body nuevoUsuario:Usuario): Call<Any>

}