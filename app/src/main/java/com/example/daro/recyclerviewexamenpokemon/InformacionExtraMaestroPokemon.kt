package com.example.daro.recyclerviewexamenpokemon

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_ingresar_datos_pokemon.*

class InformacionExtraMaestroPokemon : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingresar_datos_pokemon)

        val recyclerView = findViewById(R.id.recyclerViewMostrarPokemons) as RecyclerView

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL,false) as RecyclerView.LayoutManager?

        val dbHandler = DbPokemonHandlerAplicacion(this)

        /****MUESTRO EN CONDOLA***/

        //dbHandler.leerDatos()

        /**********************/

        /******SETEO LA CONSULTA DE LA BD EN RECYCLERVIEW **************/
        val adapter = CustomAdapterPokemon(dbHandler.getArrayList())
        recyclerView.adapter = adapter
        /************************************************************/


        val nombre:String = intent.getStringExtra("nombreM")
        val apellido:String = intent.getStringExtra("apellidoM")
        val campeon:String = intent.getStringExtra("campeonM")
        val medallas:String = intent.getStringExtra("medallasM")

        txtNombreM.text = nombre
        txtApellidoM.text = apellido
        txtCampeonM.text = campeon
        txtMedallasM.text = medallas



    }
}
