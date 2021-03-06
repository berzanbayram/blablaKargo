package com.example.cargo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.cargo.databinding.ActivityAliciBilgileriBinding
import com.example.cargo.databinding.ActivityKargoGonderBinding
import com.google.firebase.database.FirebaseDatabase

class KargoGonderActivity : AppCompatActivity() {

    lateinit var binding: ActivityKargoGonderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityKargoGonderBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var database = FirebaseDatabase.getInstance().reference

        binding.btnAlGonder.setOnClickListener {
            var gonAdSoyad = binding.gonAdSoyad.text.toString()
            var telefon = binding.telefon.text.toString()
            var ilce = binding.ilce.text.toString()
            var mahalle = binding.mahalle.text.toString()
            var cadde = binding.cadde.text.toString()
            var sokak = binding.sokak.text.toString()

            database.child(telefon).setValue(aliciBilgileri(gonAdSoyad, ilce, mahalle, cadde, sokak))

        }


    }
        fun donusgeri(view: View) {
            val intent = Intent(this, GonderimTipiActivity::class.java)
            startActivity(intent)
         }

        fun button(view: View) {
            val intent = Intent(this, AliciBilgileriActivity::class.java)
            startActivity(intent)
        }

}