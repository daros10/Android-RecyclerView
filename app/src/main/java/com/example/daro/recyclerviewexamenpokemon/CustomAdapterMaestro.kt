package com.example.daro.recyclerviewexamenpokemon

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.support.v4.content.ContextCompat


class CustomAdapterMaestro(val maestroPokemonList : ArrayList<MaestroPokemonData>) : RecyclerView.Adapter<CustomAdapterMaestro.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.layoutmaestropoken,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return maestroPokemonList.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val maestroPokemon: MaestroPokemonData = maestroPokemonList[position]
        holder?.txtCampeonActual?.text = maestroPokemon.campeonActual
        holder?.txtNombreMaestroPokemon?.text = maestroPokemon.nombreMaestroPokemon
        holder?.txtApellidoMaestroPokemon?.text = maestroPokemon.apellidoMaestroPokemon
        holder?.txtNumeoMedallas?.text = maestroPokemon.numeroMedallas

        holder?.mostrarInformacionMaestroPokemon()

        //holder?.cambiarColor()



    }

    class  ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val txtCampeonActual = itemView.findViewById(R.id.txtNombrePokemon) as TextView
        val txtNombreMaestroPokemon = itemView.findViewById(R.id.txtNombreMaestroPokemon) as TextView
        val txtApellidoMaestroPokemon = itemView.findViewById(R.id.txtApellidoMaestroPokemon) as TextView
        val txtNumeoMedallas = itemView.findViewById(R.id.txtNumeroMedallas) as TextView
        val btnDetalleMaestroPokemon = itemView.findViewById(R.id.btn_detalleMaestroPokemon) as Button
        //val txtFechaNacimiento = itemView.findViewById(R.id.txtFechaNacimientoMaestroPokemon) as TextView
        //val numeroMedallas = itemView.findViewById(R.id.txtNumeroMedallasMaestroPokemon) as TextView
        //val btnColor = itemView.findViewById(R.id.btnCambiarTexto) as Button




        fun mostrarInformacionMaestroPokemon(){
            btnDetalleMaestroPokemon.setOnClickListener { v ->
                Toast.makeText(v.context, "Info de: ${txtNombreMaestroPokemon.text}", Toast.LENGTH_SHORT).show()
                val intent = Intent(v.context,InformacionExtraMaestroPokemon::class.java)
                intent.putExtra("nombreM","${txtNombreMaestroPokemon.text}")
                intent.putExtra("apellidoM","${txtApellidoMaestroPokemon.text}")
                intent.putExtra("campeonM","${txtCampeonActual.text}")
                intent.putExtra("medallasM","${txtNumeoMedallas.text}")
               // intent.putExtra("status","Status:${btnColor.text}")
              ContextCompat.startActivity(v.context, intent, null)


            }

            //clic en la informacion--- implementar menu
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







}