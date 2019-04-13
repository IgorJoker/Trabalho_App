package com.example.prova

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_resultado.*

class ResultadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)
        var dados: Bundle = intent.extras
        var Etanol = dados.getString("Etanol")
        var Gasolina = dados.getString("Gasolina")

        calcular(Etanol.toInt(), Gasolina.toInt())

        button.setOnClickListener {
            finish()
        }

    }

    fun calcular(etanol: Int, gasolina: Int){
        val valorEtanol = etanol.toDouble()
        val valorGasolina = gasolina.toDouble()

        val resultPreco = valorEtanol / valorGasolina

        if(resultPreco <= 0.7){
            textViewResultado.setText("Melhor usar Gasolina")
        } else{
            textViewResultado.setText("Melhor usar Etanol")
        }
    }
}
