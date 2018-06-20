package com.example.daro.recyclerviewexamenpokemon

import android.content.Intent
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast

class CustomAdapterPokemon(val pokemonList : ArrayList<PokemonData>) : RecyclerView.Adapter<CustomAdapterPokemon.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomAdapterPokemon.ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.layoutpokemonlistar,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val personajePokemon: PokemonData = pokemonList[position]
        holder?.txtNombrePokemon?.text = personajePokemon.nombrePokemon
        holder?.txtPoderUo?.text = personajePokemon.poderPokemonDos
        holder?.txtPoderDos?.text = personajePokemon.poderPokemonDos



        holder?.mostrarInformacionPokemon()

        //holder?.cambiarColor()



    }

    class  ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){


        val txtNombrePokemon = itemView.findViewById(R.id.txtNombrePokemon) as TextView
        val txtPoderUo = itemView.findViewById(R.id.txtPoderUno) as TextView
        val txtPoderDos = itemView.findViewById(R.id.txtPoderDos) as TextView
        val btnDetallePokemon = itemView.findViewById(R.id.btn_detallePokemon) as Button

        fun mostrarInformacionPokemon(){

            btnDetallePokemon.setOnClickListener{ v ->
                Toast.makeText(v.context, "Info de: ${txtNombrePokemon.text}", Toast.LENGTH_SHORT).show()
                //clic en la informacion--- implementar menu


            }

            itemView.setOnClickListener{ view ->
                //Toast.makeText(itemView.context,"PRRRROOO",Toast.LENGTH_LONG).show()
                val popup = PopupMenu(itemView.context, view)
                val inflater = popup.menuInflater
                inflater.inflate(R.menu.menu_popup, popup.menu)
                //////////////



                //////
                popup.show()
            }
        }


    }
        /*fun cambiarColor(){
            btnColor.setOnClickListener {
                if (btnColor.text=="LIKE"){
                    btnColor.text="NO LIKE"
                    btnColor.setBackgroundColor(Color.YELLOW)
                    status = "NO LIKE"


                }else if (btnColor.text=="NO LIKE"){
                    btnColor.text="LIKE"
                    btnColor.setBackgroundColor(Color.GREEN)
                    status = "LIKE"
                }
            }
        }*/

        /*fun onContextItemSelected(item: MenuItem): Boolean {
            val info = item.menuInfo as AdapterContextMenuInfo
            when (item.getItemId()) {
                R.id.menu_eliminar -> {
                    Toast.makeText(itemView.context,"+100",Toast.LENGTH_LONG).show()
                    return true
                }

                else -> {
                    Toast.makeText(itemView.context,"+100",Toast.LENGTH_LONG).show()
                    return true
                }
            }
        }*/

    }