package com.example.churracometro

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_calc.setOnClickListener {

            val intent = Intent(applicationContext, ResultadoActivity::class.java)

            val qt_Man = text_man.text.toString()
            val qt_Women = text_women.text.toString()
            val qt_Kid = text_kid.text.toString()

            intent.putExtra("man", qt_Man)
            intent.putExtra("women", qt_Women)
            intent.putExtra("kid", qt_Kid)

            val validaCampo = validaCampo(qt_Man, qt_Women, qt_Kid)

            if(validaCampo == true){
                startActivity(intent)
            }else{
                text_erro.setText("Preencha todos os campos campos primeiro")
            }
        }
    }

    fun validaCampo(qt_man: String, qt_women: String, qt_kid: String) : Boolean{
        var camposValidos:Boolean = true

        if(qt_man == null || qt_man.equals("") && qt_women == null || qt_women.equals("") && qt_kid == null || qt_kid.equals("")){

            camposValidos = false

        }

        return camposValidos
    }
}
