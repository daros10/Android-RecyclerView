package com.example.daro.recyclerviewexamenpokemon

import android.os.Parcel
import android.os.Parcelable
import java.util.*

//data class MaestroPokemonData(val nombreMaestroPokemon: String, val apellidoMaestroPokemon: String, val fechaNacimiento: String,  val numeroMedallas: String,val campeonActual: String )

class MaestroPokemonData(val nombreMaestroPokemon: String, val apellidoMaestroPokemon: String, val fechaNacimiento: String,  val numeroMedallas: String,val campeonActual: String ) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombreMaestroPokemon)
        parcel.writeString(apellidoMaestroPokemon)
        parcel.writeString(fechaNacimiento)
        parcel.writeString(numeroMedallas)
        parcel.writeString(campeonActual)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MaestroPokemonData> {
        override fun createFromParcel(parcel: Parcel): MaestroPokemonData {
            return MaestroPokemonData(parcel)
        }

        override fun newArray(size: Int): Array<MaestroPokemonData?> {
            return arrayOfNulls(size)
        }
    }
}

