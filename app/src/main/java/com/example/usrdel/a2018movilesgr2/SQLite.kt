package com.example.usrdel.a2018movilesgr2

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class SQLite(context:Context):
    SQLiteOpenHelper(context,  "proyecto", null, 1){
    override fun onCreate(baseDeDatos: SQLiteDatabase?) {
        val queryTable = "CREATE TABLE"+
                "Usuario" +
                "("+
                "usuario_id integer primary key autoincrement,"+
                "nombre varchar(500),"+
                "password varchar(500),"+
                "edad integer"+
                ")"
        Log.i("bdd", "Creando la tabla Usuario")
        baseDeDatos?.execSQL(queryTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun buscarRegistro (){
        val querySelect = "select * from Usuario where usuario_id=1"
        val dbReadable = readableDatabase
        val resultado = dbReadable.rawQuery(querySelect, null)
        var existeUsuario = 0
        if(resultado.moveToFirst()){
            do{
                existeUsuario++
            }while(resultado.moveToNext())
        }
        resultado.close()
        dbReadable.close()
        return
    }

}
