package com.example.cargo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class AliciBilgileriActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alici_bilgileri)
    }

    fun donusgerigonderici(view: View) {
        val intent = Intent(this, KargoGonderActivity::class.java)
        startActivity(intent)
    }

    fun devamkg(view: View) {
        val intent = Intent(this, KargoFiyatActivity::class.java)
        startActivity(intent)
    }

}