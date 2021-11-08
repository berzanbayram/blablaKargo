package com.example.cargo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.cargo.databinding.ActivityAliciBilgileriBinding
import com.google.firebase.database.FirebaseDatabase



class AliciBilgileriActivity : AppCompatActivity() {

    lateinit var binding: ActivityAliciBilgileriBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        val binding = ActivityAliciBilgileriBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var database = FirebaseDatabase.getInstance().reference

        binding.btnAlGonder.setOnClickListener{
            var AdSoyad= binding.AdSoyad.text.toString()
            var idTelefon= binding.telefon.text.toString()
            var ilce= binding.ilce.text.toString()
            var mahalle= binding.mahalle.text.toString()
            var cadde= binding.cadde.text.toString()
            var sokak= binding.sokak.text.toString()

            database.child("Cargo Alici Bilgileri").child(idTelefon).setValue(kisiBilgileri(AdSoyad,ilce,mahalle,cadde,sokak))

            val intent = Intent(this, KargoFiyatActivity::class.java)
            startActivity(intent)

        }

    }

    fun donusgerigonderici(view: View) {
        val intent = Intent(this, KargoGonderActivity::class.java)
        startActivity(intent)
    }



}