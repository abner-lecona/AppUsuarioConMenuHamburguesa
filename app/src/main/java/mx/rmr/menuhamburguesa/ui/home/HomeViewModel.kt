package mx.rmr.menuhamburguesa.ui.home

import android.graphics.Bitmap
import android.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.zxing.BarcodeFormat
import com.google.zxing.EncodeHintType
import com.google.zxing.qrcode.QRCodeWriter
import mx.rmr.menuhamburguesa.model.Usuario

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    val usuario = Usuario(
        IDUsuario = 1000,
        Nombre = "Karla",
        Apellido1 = "Cruz",
        Apellido2 = "Muñiz",
        CURP = "CUMK030414MDFRXRA9",
        Nacionalidad = "Mexico",
        Sexo = "F",
        FechaNac = "2003-04-14T00:00:00.000Z",
        Condicion = "No aplica",
        Cel = "5567861076",
        Correo = "karla.cruzmz@gmail.com"
    )

    fun getQrCodeBitmap(ssid: String, password: String): Bitmap {
        val size = 512 //pixels
        val qrCodeContent = "IDUsuario=${usuario.IDUsuario}, " +
                "Nombre=${usuario.Nombre}, " +
                "Apellido1=${usuario.Apellido1}, " +
                "Apellido2=${usuario.Apellido2}, " +
                "CURP=${usuario.CURP}, " +
                "Nacionalidad=${usuario.Nacionalidad}, " +
                "Sexo=${usuario.Sexo}, " +
                "FechaNac=${usuario.FechaNac}, " +
                "Condicion=${usuario.Condicion}, " +
                "Cel=${usuario.Cel}, " +
                "Correo=${usuario.Correo}"
        val hints = hashMapOf<EncodeHintType, Int>().also { it[EncodeHintType.MARGIN] = 1 } // Make the QR code buffer border narrower
        val bits = QRCodeWriter().encode(qrCodeContent, BarcodeFormat.QR_CODE, size, size)
        return Bitmap.createBitmap(size, size, Bitmap.Config.RGB_565).also {
            for (x in 0 until size) {
                for (y in 0 until size) {
                    it.setPixel(x, y, if (bits[x, y]) Color.BLACK else Color.WHITE)
                }
            }
        }
    }

}