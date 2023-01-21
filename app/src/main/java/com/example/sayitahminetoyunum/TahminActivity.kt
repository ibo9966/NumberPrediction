package com.example.sayitahminetoyunum

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_tahmin.*
import java.util.Random

class TahminActivity : AppCompatActivity() {

    private var rasgeleSayi = 0

    private var sayac =5


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tahmin)

        rasgeleSayi = kotlin.random.Random.nextInt(101)//0 ile 100 arası
        Log.e("Rasgele Sayı",rasgeleSayi.toString())

        buttonTahmin.setOnClickListener {

            sayac = sayac-1

            val tahmin = editTextGirdi.text.toString().toInt()

            if (tahmin == rasgeleSayi){
                val intent = Intent(this@TahminActivity,SonucActivity::class.java)
                intent.putExtra("Sonuc",true)
                startActivity(intent)

                finish()

                return@setOnClickListener
            }

            if (tahmin>rasgeleSayi){

                textViewYardim.text = "Azaltın"
                textViewKalanHak.text = "Kalan Hak : $sayac"

            }
            if (tahmin<rasgeleSayi){

                textViewYardim.text = "Arttır"
                textViewKalanHak.text = "Kalan Hak :  $sayac"

            }
            if (sayac ==0 ){

                startActivity(Intent(this@TahminActivity,SonucActivity::class.java))
                intent.putExtra("Sonuc",false)

                finish()

            }
            editTextGirdi.setText("")

        }
    }
}