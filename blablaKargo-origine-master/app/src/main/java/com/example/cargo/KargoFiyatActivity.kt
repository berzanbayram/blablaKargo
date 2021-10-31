package com.example.cargo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class KargoFiyatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kargo_fiyat)
    }


    fun donusgeriAlicibilgileri( view: View) {
        val intent = Intent(this, AliciBilgileriActivity::class.java)
        startActivity(intent)
    }

    fun devamEtBasarili( view: View) {
        val intent = Intent(this, BasariliActivity::class.java)
        startActivity(intent)
    }



}