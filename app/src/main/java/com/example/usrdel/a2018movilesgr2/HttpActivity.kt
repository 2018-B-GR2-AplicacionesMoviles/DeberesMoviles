package com.example.usrdel.a2018movilesgr2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result

class HttpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_http)
/*        val url = "http://172.29.66.67:1337/Estudiante"
        url.httpGet().responseString { request, response, result ->
            when(result){
                is Result.Failure ->{
                    val exepcion = result.getException()
                    Log.i("http", "Error:${exepcion}")

                }
                is Result.Success ->{
                    val data = result.get()
                    Log.i("http", "Datos:${data}")
                }
            }
        }
        */
        val url = "http://172.29.66.67:1337/Estudiante"
        val parametro = listOf("nombre" to "Mario",
                "apellido" to "Giler",
                "altura" to 12)
        url.httpPost(parametro).responseString { request, response, result ->
            when(result){
                is Result.Failure ->{
                    val exepcion = result.getException()
                    Log.i("http", "Error:${exepcion}")

                }
                is Result.Success ->{
                    val data = result.get()
                    Log.i("http", "Datos:${data}")
                }
            }
        }
    }

}
