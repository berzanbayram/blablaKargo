package com.example.cargo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class KargolarimActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kargolarim)
    }
}