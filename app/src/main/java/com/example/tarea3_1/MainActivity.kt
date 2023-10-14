package com.example.ejemplorv

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ejemplorv.databinding.ContactosBinding
import com.example.tarea3_1.Contacto
import com.example.tarea3_1.ContactoPulsadoListener

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val contactos = ContactosBinding.inflate(layoutInflater)
        setContentView(contactos.root)
        contactos.VistaContactos.adapter = ContactosAdapter(listOf(
            Contacto("Alejandro Sosa García", "123456789", "Hombre"),
            Contacto("Angel Navarro Mesas", "987654321", "Hombre"),
            Contacto("David Bermúdez Alcántara", "666666666", "Hombre"),
            Contacto("Alejandro Mulero Muletas", "000000000", "Hombre"),
            Contacto("Francisco Javier ", "987654321", "Hombre"),
            Contacto("Rubén Lindes ", "612511120", "Hombre"),
            Contacto("David Perea ", "123456789", "Hombre"),
            Contacto("Claudia Mendoza", "666666666", "Mujer"),
            Contacto("Lydia Pérez González", "123456789", "Mujer"),
            Contacto("Carmen Martín Núñez", "987654321", "Mujer"),
            Contacto("Antonio Navarro", "666666666", "Hombre"),
            Contacto("Fernando José Miguel Gómez", "123456789", "Hombre"),
            Contacto("Britany Sanchez Ballón", "987654321", "Mujer"),
            Contacto("Yeray Jimenez", "666666666", "Hombre"),
            Contacto("Juan Manuel Sánchez Moreno", "123456789", "Hombre")), object :
            ContactoPulsadoListener {
            override fun contactoPulsado(contacto: Contacto) {
                val dial = Intent(
                    Intent.ACTION_DIAL,
                    Uri.parse("tel:" + contacto.tlfn)
                )
                startActivity(dial)
            }
        })
    }
}