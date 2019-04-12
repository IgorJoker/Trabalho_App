package com.example.churracometro

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_resultado.*

class ResultadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        var dados: Bundle = intent.extras
        var qt_man = dados.getString("man")
        var qt_women = dados.getString("women")
        var qt_kid = dados.getString("kid")

        calcular(qt_man.toInt(), qt_women.toInt(), qt_kid.toInt())


        button.setOnClickListener {
            finish()
        }
    }



    fun calcular(man: Int, women: Int, kid: Int) {

        textPicanhaMan.setText((man * 240).toString())
        textPicanhaWomen.setText((women * 180).toString())
        textPicanhaKid.setText((kid * 120).toString())
        textMaminhaMan.setText((man * 80).toString())
        textMaminhaWomen.setText((women * 60).toString())
        textMaminhaKid.setText((kid * 40).toString())
        textLinguiçaMan.setText((man * 40).toString())
        textLinguiçaWomen.setText((women * 30).toString())
        textLinguiçaKid.setText((kid * 20).toString())
        textFrangoMan.setText((man * 40).toString())
        textFrangoWomen.setText((women * 30).toString())
        textFrangoKid.setText((kid * 20).toString())
        textArrozMan.setText((man * 100).toString())
        textArrozWomen.setText((women * 80).toString())
        textArrozKid.setText((0).toString())
        textBatataMan.setText((man * 200).toString())
        textBatataWomen.setText((women * 150).toString())
        textBatataKid.setText((kid * 100).toString())
        textFarofaMan.setText((man * 100).toString())
        textFarofaWomen.setText((women * 80).toString())
        textFarofaKid.setText((0).toString())
        textPãesMan.setText((man * 1.50).toString())
        textPãesWomen.setText((women * 1.50).toString())
        textPãesKid.setText((0).toString())




    }

}
