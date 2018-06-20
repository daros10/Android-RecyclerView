package com.example.daro.recyclerviewexamenpokemon

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_pantalla_principal.*

class PantallaPrincipal : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_principal)

        btnListar.setOnClickListener { view: View ->
            irAListarRecyclerView()
        }

        btnCrear.setOnClickListener { view: View ->
            irIngresarMaestro()
        }
    }

    fun  irAListarRecyclerView(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)

    }


    fun irIngresarMaestro(){
        val intent = Intent(this, IngresarDatosMaestroPokemon::class.java)
        startActivity(intent)
    }
}
