package com.example.daro.recyclerviewexamenpokemon

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_ingresar_datos_maestro_pokemon.*

class IngresarDatosMaestroPokemon : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingresar_datos_maestro_pokemon)

        btnGuardarMaestroPokemon.setOnClickListener{ view: View ->
            crearMaestroPokemon()

        }


    }


    fun crearMaestroPokemon() {
        val dbHandler = DbHandlerAplicacion(this)
        val nombre = txtNombreMaestro.text.toString()
        val apellido = txtApellidoMaestro.text.toString()
        val fechaN = txtFechaMaestro.text.toString()
        val medallas = txtMedallasMaestro.text.toString()
        val campeonActual = txtNombrePokemon.text.toString()
        if (nombre.equals("") || apellido.equals("") || fechaN.equals("") || medallas.equals("") || campeonActual.equals("")){
            Toast.makeText(this, "Campos Vacio", Toast.LENGTH_SHORT).show()
        }else{

            dbHandler.insertarMaestroPokemon(nombre,apellido,fechaN,medallas,campeonActual)
            Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show()
           val intent = Intent(this, RegistrarPokemones::class.java)
            startActivity(intent)


        }


    }
}


