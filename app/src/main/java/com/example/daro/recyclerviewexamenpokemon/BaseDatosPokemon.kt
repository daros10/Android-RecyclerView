package com.example.daro.recyclerviewexamenpokemon

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class BaseDatosPokemon{
    companion object {
        val NOMBRE_BASEDATOS = "personajePokemon"
        val NOMBRE_TABLA = "personajePokemon"
        val CAMPO_ID = "id"
        val CAMPO_NUMEROPOKEMON = "numeroPokemon"
        val CAMPO_NOMBRE = "nombrePokemon"
        val CAMPO_PODERUNO = "poderUno"
        val CAMPO_PODERDOS = "poderDos"
        val CAMPO_FECHACAPTURA = "fechaCap"
        val CAMPO_NIVEL = "nivel"
        val CAMPO_ENTRENADORID = "entrenadorId"
    }
}

class DbPokemonHandlerAplicacion(context: Context) : SQLiteOpenHelper(context, BaseDatosPokemon.NOMBRE_BASEDATOS, null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {

        val createTableSQL = "CREATE TABLE ${BaseDatosPokemon.NOMBRE_TABLA} (${BaseDatosPokemon.CAMPO_ID} INTEGER PRIMARY KEY AUTOINCREMENT, ${BaseDatosPokemon.CAMPO_NUMEROPOKEMON} VARCHAR(20),${BaseDatosPokemon.CAMPO_NOMBRE} VARCHAR(50),${BaseDatosPokemon.CAMPO_PODERUNO} VARCHAR(20), ${BaseDatosPokemon.CAMPO_PODERDOS} VARCHAR(20), ${BaseDatosPokemon.CAMPO_FECHACAPTURA} VARCHAR(20), ${BaseDatosPokemon.CAMPO_NIVEL} VARCHAR(20), ${BaseDatosPokemon.CAMPO_ENTRENADORID} VARCHAR(20))"

        db?.execSQL(createTableSQL)
    }


    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun insertarPokemon(numeroPoken: String, nombre:String, poderUno: String, poderDos: String, fechaCaptura:String, nivel:String, entrenadorId: String) {
        val dbWriteable = writableDatabase
        val cv = ContentValues()

        cv.put(BaseDatosPokemon.CAMPO_NUMEROPOKEMON, numeroPoken)
        cv.put(BaseDatosPokemon.CAMPO_NOMBRE, nombre)
        cv.put(BaseDatosPokemon.CAMPO_PODERUNO, poderUno)
        cv.put(BaseDatosPokemon.CAMPO_PODERDOS, poderDos)
        cv.put(BaseDatosPokemon.CAMPO_FECHACAPTURA, fechaCaptura)
        cv.put(BaseDatosPokemon.CAMPO_NIVEL, nivel)
        cv.put(BaseDatosPokemon.CAMPO_ENTRENADORID, entrenadorId)



        val resultado = dbWriteable.insert(BaseDatosPokemon.NOMBRE_TABLA, null, cv)

        Log.i("database", "Si es -1 hubo error, sino exito: Respuesta: $resultado")

        dbWriteable.close()

    }


    //// ***** RECUPERO TODOS LOS DATOS DE LA BASE, EN UN ARRAY LIST *****/////

    fun getArrayList() : ArrayList<PokemonData>{
        var lista = ArrayList<PokemonData>()

        val dbReadable = readableDatabase

        val query = "SELECT * FROM ${BaseDatosPokemon.NOMBRE_TABLA}"

        val resultado = dbReadable.rawQuery(query, null)

        if (resultado.moveToFirst()) {
            do {
                val idActual = resultado.getString(0).toInt()
                val numeroPokemon = resultado.getString(1)
                val nombrePokemon = resultado.getString(2)
                val poderUno = resultado.getString(3)
                val poderDos = resultado.getString(4)
                val fechaCaptura = resultado.getString(5)
                val nivel = resultado.getString(6)
                val entrenadorId = resultado.getString(7)

                Log.i("database", "Nombre: $numeroPokemon, $nombrePokemon, $poderUno, $poderDos, $fechaCaptura, $nivel, $entrenadorId con id $idActual")


                lista.add(PokemonData(numeroPokemon,nombrePokemon,poderUno,poderDos,fechaCaptura,nivel,entrenadorId))



            } while (resultado.moveToNext())
        }

        resultado.close()
        dbReadable.close()

        return lista
    }

    /*************************************************************************************************/

    fun leerDatos(){

        val dbReadable = readableDatabase

        val query = "SELECT * FROM ${BaseDatosPokemon.NOMBRE_TABLA}"

        val resultado = dbReadable.rawQuery(query, null)

        if (resultado.moveToFirst()) {
            do {
                val idActual = resultado.getString(0).toInt()
                val numeroPokemon = resultado.getString(1)
                val nombrePokemon = resultado.getString(2)
                val poderUno = resultado.getString(3)
                val poderDos = resultado.getString(4)
                val fechaCaptura = resultado.getString(5)
                val nivel = resultado.getString(6)
                val entrenadorId = resultado.getString(7)

                Log.i("database", "Nombre: $numeroPokemon, $nombrePokemon, $poderUno, $poderDos, $fechaCaptura, $nivel, $entrenadorId con id $idActual")



            } while (resultado.moveToNext())
        }

        resultado.close()
        dbReadable.close()

    }






}
