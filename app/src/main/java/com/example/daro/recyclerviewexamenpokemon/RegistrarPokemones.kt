package com.example.daro.recyclerviewexamenpokemon

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_registrar_pokemones.*

class RegistrarPokemones : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_pokemones)

        btnGuardarPokemon.setOnClickListener{ view: View ->
            crearPokemon()

        }
    }

    fun crearPokemon() {
        val dbHandler = DbPokemonHandlerAplicacion(this)
        val numeroPokemon = txtNumeroPokemon.text.toString()
        val nombrePokemon = txtNombrePokemon.text.toString()
        val poderUno = txtPoderUno.text.toString()
        val poderDos = txtPoderDos.text.toString()
        val fechaCaptura = txtFechaCaptura.text.toString()
        val nivel = txtNivel.text.toString()
        val entrenadoId = txtIdEntrenador.text.toString()
        if (numeroPokemon.equals("") || nombrePokemon.equals("") || poderUno.equals("") || poderDos.equals("") || fechaCaptura.equals("") || nivel.equals("")){
            Toast.makeText(this, "Campos Vacio", Toast.LENGTH_SHORT).show()
        }else{


            dbHandler.insertarPokemon(numeroPokemon,nombrePokemon,poderUno,poderDos,fechaCaptura,nivel,entrenadoId)
            Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show()
            dbHandler.leerDatos()

        }


    }
}
