package com.example.memoriaapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import com.example.memoriaapi.models.Estados

class Principal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        val btEstados = findViewById<Button>(R.id.estados)
        btEstados.setOnClickListener {
            goToEstados()
        }
        val btJuegos = findViewById<Button>(R.id.juego)
        btJuegos.setOnClickListener {
            goToJueegos()
        }
    }
    private fun goToEstados(){
        val i = Intent(this, MainActivity::class.java)
        startActivity(i)
    }
    private fun goToJueegos(){
        val ii = Intent(this, JuegoMemoria::class.java)
        startActivity(ii)
    }
}