package com.example.daro.recyclerviewexamenpokemon

import android.os.Parcel
import android.os.Parcelable

class PokemonData(val numeroPokemon: String, val nombrePokemon: String, val poderPokemonUno: String, val poderPokemonDos: String, val fechaC : String, val nivelPokemon:String, var idEntrenado: String) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(numeroPokemon)
        parcel.writeString(nombrePokemon)
        parcel.writeString(poderPokemonUno)
        parcel.writeString(poderPokemonDos)
        parcel.writeString(fechaC)
        parcel.writeString(nivelPokemon)
        parcel.writeString(idEntrenado)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PokemonData> {
        override fun createFromParcel(parcel: Parcel): PokemonData {
            return PokemonData(parcel)
        }

        override fun newArray(size: Int): Array<PokemonData?> {
            return arrayOfNulls(size)
        }
    }

}


