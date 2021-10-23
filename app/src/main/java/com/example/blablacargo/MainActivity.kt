package com.example.blablacargo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.content.ContextCompat.startActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        }

            fun kayitAnasayfa(view: View){
                val ilkKayitol = findViewById<Button>(R.id.buttonKayitol)
                ilkKayitol.setOnClickListener {
                val intent = Intent(this, MainKayit::class.java)
                startActivity(intent)
                }
            }


            fun kayitGirisYap(view: View){
                val ilkGirisyap = findViewById<Button>(R.id.buttonGirisYap)
                ilkGirisyap.setOnClickListener {
                    val intent = Intent(this, MainGirisYapildi::class.java)
                    startActivity(intent)
                }

            }
}

