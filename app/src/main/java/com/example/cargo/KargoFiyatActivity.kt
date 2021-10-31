package com.example.cargo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.cargo.databinding.ActivityKargoFiyatBinding
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_kargo_fiyat.*
import java.util.*

class KargoFiyatActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kargo_fiyat)


        val bilgikg=intent.getStringExtra("bilgikg")
             sonuc.text=bilgikg

        val result=intent.getStringExtra("ucret")
             sonuc2.text=result

        val takip = intent.getStringExtra("takip")
            sonuc3.text=takip


        }

    }




