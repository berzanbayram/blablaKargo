package com.example.blablacargo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class kargogonder : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kargogonder)


        }

        fun kargoGonder(view: View){
            val kargoGonder = findViewById<View>(R.id.imageView23)
            kargoGonder.setOnClickListener {
                val intent = Intent(this, kargogonderme::class.java)
                startActivity(intent)
            }

    }
}