package com.example.cargo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.cargo.databinding.ActivityKargoGonderBinding
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_kargo_fiyat.*
import kotlinx.android.synthetic.main.activity_kargo_gonder.*

class KargoGonderActivity : AppCompatActivity() {

    lateinit var binding: ActivityKargoGonderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityKargoGonderBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var database = FirebaseDatabase.getInstance().reference



        binding.btnAlGonder.setOnClickListener {

            var aliciAdSoyad = binding.aliciadSoyad.text.toString()
            var aliciadres = binding.aliciadres.text.toString()
            var alicitelefon = binding.alicitelefon.text.toString()
            var GondericiAdSoyad = binding.gonAdSoyad.text.toString()
            var GondericiAdres= binding.gonAdres.text.toString()
            var GondericiTelefon = binding.gontelefon.text.toString()
            var telefon=binding.alicitelefon.text.toString()
            var kg = binding.aliciadres2.text.toString()
            var result=binding.aliciadres2.text.toString()


            database.child("carGoDB").child("Alici Telefon"+telefon).setValue(kisiBilgi(aliciAdSoyad,aliciadres,alicitelefon,kg,GondericiAdSoyad,GondericiAdres,GondericiTelefon))




            val intent = Intent(this, KargoFiyatActivity::class.java)
            intent.putExtra("bilgikg",kg)
            intent.putExtra("takip",telefon)
            intent.putExtra("ucret",result)
            startActivity(intent)
        }


    }
        fun donusgeri(view: View) {
            val intent = Intent(this, GonderimTipiActivity::class.java)
            startActivity(intent)
         }



}