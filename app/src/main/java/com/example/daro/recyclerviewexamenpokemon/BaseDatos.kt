package com.example.daro.recyclerviewexamenpokemon

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class BaseDatos{
    companion object {
        val NOMBRE_BASEDATOS = "pokemon"
        val NOMBRE_TABLA = "maestroPokemon"
        val CAMPO_ID = "id"
        val CAMPO_NOMBRE = "nombre"
        val CAMPO_APELLIDO = "apellido"
        val CAMPO_FECHANACIMIENTO = "fechaNacimiento"
        val CAMPO_NUMEROMEDALLAS = "numeroMedallas"
        val CAMPO_CAMPEONACTUAL = "camepeonActual"
    }
}

class DbHandlerAplicacion(context: Context) : SQLiteOpenHelper(context, BaseDatos.NOMBRE_BASEDATOS, null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {

        val createTableSQL = "CREATE TABLE ${BaseDatos.NOMBRE_TABLA} (${BaseDatos.CAMPO_ID} INTEGER PRIMARY KEY AUTOINCREMENT, ${BaseDatos.CAMPO_NOMBRE} VARCHAR(50),${BaseDatos.CAMPO_APELLIDO} VARCHAR(50),${BaseDatos.CAMPO_FECHANACIMIENTO} VARCHAR(20), ${BaseDatos.CAMPO_NUMEROMEDALLAS} INTEGER, ${BaseDatos.CAMPO_CAMPEONACTUAL} VARCHAR(20))"

        db?.execSQL(createTableSQL)
    }


    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun insertarMaestroPokemon(nombre: String, apellido:String,fechaNacimiento: String,numeroMedallas: String, campeonActual:String) {
        val dbWriteable = writableDatabase
        val cv = ContentValues()

        cv.put(BaseDatos.CAMPO_NOMBRE, nombre)
        cv.put(BaseDatos.CAMPO_APELLIDO, apellido)
        cv.put(BaseDatos.CAMPO_FECHANACIMIENTO, fechaNacimiento)
        cv.put(BaseDatos.CAMPO_NUMEROMEDALLAS, numeroMedallas)
        cv.put(BaseDatos.CAMPO_CAMPEONACTUAL, campeonActual)

        val resultado = dbWriteable.insert(BaseDatos.NOMBRE_TABLA, null, cv)

        Log.i("database", "Si es -1 hubo error, sino exito: Respuesta: $resultado")

        dbWriteable.close()

    }


    //// ***** RECUPERO TODOS LOS DATOS DE LA BASE, EN UN ARRAY LIST *****/////

    fun getArrayList() : ArrayList<MaestroPokemonData>{
        var lista = ArrayList<MaestroPokemonData>()

        val dbReadable = readableDatabase

        val query = "SELECT * FROM ${BaseDatos.NOMBRE_TABLA}"

        val resultado = dbReadable.rawQuery(query, null)

        if (resultado.moveToFirst()) {
            do {
                val idActual = resultado.getString(0).toInt()
                val nombreMaestroPokemon = resultado.getString(1)
                val apellidoMaestroPokemon = resultado.getString(2)
                val fechaNacimientoMaestro = resultado.getString(3)
                val numeroMedallas = resultado.getString(4)
                val campeonActualMaestro = resultado.getString(5)

                Log.i("database", "Nombre: $nombreMaestroPokemon, $apellidoMaestroPokemon, $fechaNacimientoMaestro, $numeroMedallas, $campeonActualMaestro con id $idActual")


                lista.add(MaestroPokemonData(nombreMaestroPokemon,apellidoMaestroPokemon,fechaNacimientoMaestro,numeroMedallas,campeonActualMaestro))



            } while (resultado.moveToNext())
        }

        resultado.close()
        dbReadable.close()

        return lista
    }

    /*************************************************************************************************/



    fun leerDatos()  {
        val dbReadable = readableDatabase

        val query = "SELECT * FROM ${BaseDatos.NOMBRE_TABLA}"

        val resultado = dbReadable.rawQuery(query, null)




        if (resultado.moveToFirst()) {
            do {
                val idActual = resultado.getString(0).toInt()
                val nombreMaestroPokemon = resultado.getString(1)
                val apellidoMaestroPokemon = resultado.getString(2)
                val fechaNacimientoMaestro = resultado.getString(3)
                val numeroMedallas = resultado.getString(4)
                val campeonActualMaestro = resultado.getString(5)

                Log.i("database", "Nombre: $nombreMaestroPokemon, $apellidoMaestroPokemon, $fechaNacimientoMaestro, $numeroMedallas, $campeonActualMaestro con id $idActual")


            } while (resultado.moveToNext())
        }
        resultado.close()
        dbReadable.close()
    }




}

