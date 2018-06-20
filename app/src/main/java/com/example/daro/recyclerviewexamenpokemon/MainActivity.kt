package com.example.daro.recyclerviewexamenpokemon

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById(R.id.recyclerViewMaestroPokemon) as RecyclerView

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL,false) as RecyclerView.LayoutManager?

        val dbHandler = DbHandlerAplicacion(this)

        /****MUESTRO EN CONDOLA***/

        //dbHandler.leerDatos()

        /**********************/

        /******SETEO LA CONSULTA DE LA BD EN RECYCLERVIEW **************/
        val adapter = CustomAdapterMaestro(dbHandler.getArrayList())
        recyclerView.adapter = adapter
        /************************************************************/



    }



        /*btn_listar.setOnClickListener {view: View ->
            irRecyclerView()
        }*/

    }

    /*fun irRecyclerView(){
        val intent = Intent(this, RecyclerView::class.java)
        startActivity(intent)
    }*/

