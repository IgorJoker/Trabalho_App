package com.example.prova

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        passar_dados.setOnClickListener {

            val intent = Intent(applicationContext, ResultadoActivity::class.java)

            val precoEtanol = editTextEtanol.text.toString()
            val precoGasolina = editTextGasolina.text.toString()

            intent.putExtra("Gasolina", precoEtanol)
            intent.putExtra("Etanol", precoGasolina)

            val validaCampo = validaCampo(precoEtanol, precoGasolina)

            if(validaCampo == true){
                startActivity(intent)
            }else{
                textViewError.setText("Preencha todos os campos campos primeiro")
            }
        }
    }

    fun validaCampo(etanol: String, gasolina: String) : Boolean{
        var camposValidos:Boolean = true

        if(etanol == null || etanol.equals("") && gasolina == null || gasolina.equals("")){

            camposValidos = false

        }
        return camposValidos
    }
}