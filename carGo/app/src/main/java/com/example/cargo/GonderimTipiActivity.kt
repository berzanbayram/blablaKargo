package com.example.cargo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class GonderimTipiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gonderim_tipi)


    }
    fun kargogonder(view: View) {
        val intent = Intent(this, KargoGonderActivity::class.java)
        startActivity(intent)
    }
    fun kargodagit(view: View) {
        val intent = Intent(this, KargoDagitActivity::class.java)
        startActivity(intent)
    }
}