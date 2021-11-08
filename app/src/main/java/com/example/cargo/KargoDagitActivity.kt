package com.example.cargo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class KargoDagitActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kargo_dagit)
    }
}