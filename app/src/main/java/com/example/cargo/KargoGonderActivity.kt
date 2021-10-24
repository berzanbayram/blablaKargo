package com.example.cargo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class KargoGonderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kargo_gonder)
    }

    fun donusgeri(view: View) {
        val intent = Intent(this, GonderimTipiActivity::class.java)
        startActivity(intent)
    }

    fun devamEt(view: View) {
        val intent = Intent(this, AliciBilgileriActivity::class.java)
        startActivity(intent)
    }








}